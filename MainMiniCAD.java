/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniCad;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Main class for Mini CAD, an application to perform basic drawings. It can
 * draw lines, rectangles, and circles. Also, the user can choose the stroke
 * width, stroke colour, filling colour, and undo the shapes already drawn.
 *
 * @author Tiago Franco de Goes Teles, 000786450
 * March, 2019
 */
public class MainMiniCAD extends Application {

    // TODO: Instance Variables for View Components and Model
    Canvas c = new Canvas(1000, 600);
    GraphicsContext gc = c.getGraphicsContext2D();

    TextField lineWidth; // TextField to let users type the line width
    Label instructions; // Text to inform users how to use the app
    Label currentShape; // Text to be displayed to users the current shape
    Label status; // Text to indicate the status line field
    Label lineLabel; // Text to indicate the TextField of lineWidth
    Label strokeLabel; // Text to indicate the ColorPicker for shape line
    Label fillLabel; // Text to indicate the ColorPicker for shape filling
    ColorPicker fillColour; // ColorPicker for shape filling
    ColorPicker lineColour; // ColorPicker for shape line
    boolean shapeActive = false; // Indication if a shape is chosen
    // ArrayList to store all shapes drawn
    ArrayList<GeometricObject> shape = new ArrayList<>();
    int shapeIndex = -1; // Indication of current index in ArrayList

    // TODO: Private Event Handlers and Helper Methods
    /**
     * Handler to add a Line object to ArrayList
     */
    private void addLine(ActionEvent e) {
        if (!shapeActive) { // no action if a shape is already selected
            shapeActive = true;
            shape.add(new Line());
            shapeIndex++;
            currentShape.setText(" Line Selected");
        }
    }

    /**
     * Handler to add a Rectangle object to ArrayList
     */
    private void addRectangle(ActionEvent e) {
        if (!shapeActive) { // no action if a shape is already selected
            shapeActive = true;
            shape.add(new Rectangle());
            shapeIndex++;
            currentShape.setText(" Rectangle Selected");
        }
    }

    /**
     * Handler to add a Circle object to ArrayList
     */
    private void addCircle(ActionEvent e) {
        if (!shapeActive) { // no action if a shape is already selected
            shapeActive = true;
            shape.add(new Circle());
            shapeIndex++;
            currentShape.setText(" Circle Selected");
        }
    }

    /**
     * Handler to remove the last shape object from the ArrayList
     */
    private void undoShape(ActionEvent e) {
        if (shapeIndex >= 0) { // The last shape is deleted if it exist
            shape.remove(shapeIndex);
            shapeIndex--;
            currentShape.setText(" Choose a Shape to Draw");
            shapeActive = false;
            gc.setFill(Color.BLACK);
            gc.fillRect(0, 0, 1000, 500);
            gc.setFill(Color.LIGHTGRAY);
            gc.fillRect(0, 500, 1000, 100);
            shape.forEach((go) -> {
                go.draw(gc);
            });
        }
    }

    /**
     * Handler to capture the start point of the selected shape when the mouse
     * right button is pressed
     */
    private void pressHandler(MouseEvent me) {
        double lw = 1.0;
        try { // It warns if the data type for line width is not double
            lw = Double.parseDouble(lineWidth.getText());
        } catch (IllegalArgumentException e) {
            lineWidth.setText("1.0");
            new Alert(Alert.AlertType.WARNING, "Invalid Line "
                    + "Width").showAndWait();
        }
        if (shapeActive) {
            shape.get(shapeIndex).setFillColour(fillColour.getValue());
            shape.get(shapeIndex).setLineColour(lineColour.getValue());
            shape.get(shapeIndex).setLw(lw);
            shape.get(shapeIndex).setX1(me.getX());
            shape.get(shapeIndex).setY1(me.getY());
        }
    }

    /**
     * Handler to capture the end point of the selected shape when the mouse
     * right button is released
     */
    private void releaseHandler(MouseEvent me) {
        if (shapeActive) {
            shape.get(shapeIndex).setX2(me.getX());
            shape.get(shapeIndex).setY2(me.getY());
            shape.get(shapeIndex).draw(gc);
            currentShape.setText(" Choose a Shape to Draw");
            shapeActive = false;
        }

    }

    /**
     * This is where you create your components and the model and add event
     * handlers.
     *
     * @param stage The main stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        Pane root = new Pane();
        Scene scene = new Scene(root, 1000, 600); // scene here
        stage.setTitle("Mini CAD"); // window title
        stage.setScene(scene);
        // TODO: Add your GUI-building code here

        // 1. Create the model
        // 2. Create the GUI components
        instructions = new Label("Instructions:\n1. Select the shape.\n"
                + "2. Set the line width, line colour, and fill colour.\n"
                + "3. Right click and drag to draw the shape.\n"
                + "4. Always read the Status Line!!!");
        status = new Label("Status Line:");
        currentShape = new Label(" Choose a Shape to Draw");
        lineLabel = new Label("Line Width");
        strokeLabel = new Label("Line Colour");
        fillLabel = new Label("Fill Colour");
        lineWidth = new TextField("1.0");
        // Button to select the line shape
        Button drawLine = new Button("Line (start/end)");
        // Button to select the rectangle shape
        Button drawRectangle = new Button("Rectangle (opposite corners)");
        // Button to select the rectangle shape
        Button drawCircle = new Button("Circle (diameter)");
        // Button delete the last shape drawn
        Button undo = new Button("Undo");
        fillColour = new ColorPicker(Color.rgb(0, 0, 0, 0));
        lineColour = new ColorPicker();

        // 3. Add components to the root
        root.getChildren().addAll(c, instructions, currentShape, lineLabel,
                strokeLabel, fillLabel, lineWidth, drawLine, drawRectangle,
                drawCircle, undo, fillColour, lineColour, status);

        // 4. Configure the components (colors, fonts, size, location)
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, 1000, 500);
        gc.setFill(Color.LIGHTGRAY);
        gc.fillRect(0, 500, 1000, 100);

        status.setLayoutX(10);
        status.setLayoutY(515);
        currentShape.setStyle("-fx-background-color: white; "
                + "-fx-text-fill: red;");
        currentShape.setLayoutX(10);
        currentShape.setLayoutY(540);
        currentShape.setMinWidth(180);
        currentShape.setMinHeight(25);

        drawLine.setLayoutX(210);
        drawLine.setLayoutY(515);
        drawLine.setMinWidth(60);

        drawRectangle.setLayoutX(320);
        drawRectangle.setLayoutY(515);
        drawRectangle.setMinWidth(60);

        drawCircle.setLayoutX(500);
        drawCircle.setLayoutY(515);
        drawCircle.setMinWidth(60);

        undo.setLayoutX(650);
        undo.setLayoutY(515);

        instructions.setLayoutX(730);
        instructions.setLayoutY(505);

        lineWidth.setLayoutX(210);
        lineWidth.setLayoutY(570);
        lineWidth.setPrefWidth(40);
        lineLabel.setLayoutX(210);
        lineLabel.setLayoutY(550);

        lineColour.setLayoutX(300);
        lineColour.setLayoutY(570);
        strokeLabel.setLayoutX(300);
        strokeLabel.setLayoutY(550);

        fillColour.setLayoutX(460);
        fillColour.setLayoutY(570);
        fillLabel.setLayoutX(460);
        fillLabel.setLayoutY(550);

        // 5. Add Event Handlers and do final setup
        drawLine.setOnAction(this::addLine);
        drawRectangle.setOnAction(this::addRectangle);
        drawCircle.setOnAction(this::addCircle);
        undo.setOnAction(this::undoShape);
        c.addEventHandler(MouseEvent.MOUSE_PRESSED, this::pressHandler);
        c.addEventHandler(MouseEvent.MOUSE_RELEASED, this::releaseHandler);

        // 6. Show the stage
        stage.show();
    }

    /**
     * Make no changes here.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        launch(args);
    }
}
