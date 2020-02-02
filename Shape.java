/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniCad;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * This is the interface for GeometricObject class.
 *
 * @author Tiago Franco de Goes Teles, 000786450
 * March, 2019
 */
public interface Shape {

    /**
     * Set method to input x1 coordinate
     *
     * @param x1 horizontal coordinate of first point
     */
    public abstract void setX1(double x1);

    /**
     * Set method to input y1 coordinate
     *
     * @param y1 vertical coordinate of first point
     */
    public abstract void setY1(double y1);

    /**
     * Set method to input x2 coordinate
     *
     * @param x2 horizontal coordinate of second point
     */
    public abstract void setX2(double x2);

    /**
     * Set method to input y2 coordinate
     *
     * @param y2 vertical coordinate of second point
     */
    public abstract void setY2(double y2);

    /**
     * Set method to input filling colour
     *
     * @param fillColour filling colour
     */
    public abstract void setFillColour(Color fillColour);

    /**
     * Set method to input line colour
     *
     * @param lineColour line colour
     */
    public abstract void setLineColour(Color lineColour);

    /**
     * Set method to input line colour
     *
     * @param lw line width
     */
    public abstract void setLw(double lw);

    /**
     * Abstract method to draw the geometric object
     *
     * @param gc the Graphics Context
     */
    public abstract void draw(GraphicsContext gc);

}
