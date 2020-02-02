/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniCad;

import javafx.scene.canvas.GraphicsContext;

/**
 * This class is a GeometricObject class to draw a circle.
 *
 * @author Tiago Franco de Goes Teles, 000786450
 * March, 2019
 */
public class Circle extends GeometricObject {

    /**
     * No argument Constructor
     */
    public Circle() {
        super();
    }

    /**
     * This method draw a circle from the instance variables.
     *
     * @param gc the Graphics Context
     */
    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(super.getFillColour());
        gc.setStroke(super.getLineColour());
        gc.setLineWidth(super.getLw());
        double x1 = super.getX1();
        double y1 = super.getY1();
        double x2 = super.getX2();
        double y2 = super.getY2();
        double dia, x, y;
        dia = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
        x = ((x1 + x2) / 2) - (dia / 2);
        y = ((y1 + y2) / 2) - (dia / 2);
        gc.fillOval(x, y, dia, dia);
        gc.strokeOval(x, y, dia, dia);
    }

}
