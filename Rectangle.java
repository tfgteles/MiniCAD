/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniCad;

import javafx.scene.canvas.GraphicsContext;

/**
 * This class is a GeometricObject class to draw a rectangle.
 *
 * @author Tiago Franco de Goes Teles, 000786450
 * March, 2019
 */
public class Rectangle extends GeometricObject {

    /**
     * No argument Constructor
     */
    public Rectangle() {
        super();
    }

    /**
     * This method draw a rectangle from the instance variables.
     *
     * @param gc the Graphics Context
     */
    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(super.getFillColour());
        gc.setStroke(super.getLineColour());
        gc.setLineWidth(super.getLw());
        double x, y, w, h;
        if (super.getX1() > super.getX2()) {
            x = super.getX2();
            w = super.getX1() - super.getX2();
        } else {
            x = super.getX1();
            w = super.getX2() - super.getX1();
        }
        if (super.getY1() > super.getY2()) {
            y = super.getY2();
            h = super.getY1() - super.getY2();
        } else {
            y = super.getY1();
            h = super.getY2() - super.getY1();
        }
        gc.fillRect(x, y, w, h);
        gc.strokeRect(x, y, w, h);
    }

}
