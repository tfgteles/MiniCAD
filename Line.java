/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniCad;

import javafx.scene.canvas.GraphicsContext;

/**
 * This class is a GeometricObject class to draw a line.
 *
 * @author Tiago Franco de Goes Teles, 000786450
 * March, 2019
 */
public class Line extends GeometricObject {

    /**
     * No argument Constructor
     */
    public Line() {
        super();
    }

    /**
     * This method draw a line from the instance variables.
     *
     * @param gc the Graphics Context
     */
    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(super.getFillColour());
        gc.setStroke(super.getLineColour());
        gc.setLineWidth(super.getLw());
        gc.strokeLine(super.getX1(), super.getY1(), super.getX2(),
                super.getY2());
    }

}
