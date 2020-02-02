/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniCad;

import javafx.scene.paint.Color;

/**
 * Parent class of shape classes: Line, Rectangle, Circle, and any other to be
 * implemented. This class implements the interface class Shape.
 *
 * @author Tiago Franco de Goes Teles, 000786450
 * March, 2019
 */
public abstract class GeometricObject implements Shape {

    /**
     * Coordinate x1 (horizontal coordinate of first point)
     */
    private double x1;

    /**
     * Coordinate y1 (vertical coordinate of first point)
     */
    private double y1;

    /**
     * Coordinate x2 (horizontal coordinate of second point)
     */
    private double x2;

    /**
     * Coordinate y2 (vertical coordinate of second point)
     */
    private double y2;

    /**
     * Line Width
     */
    private double lw;

    /**
     * Filling Colour
     */
    private Color fillColour;

    /**
     * Stroke Colour (line colour)
     */
    private Color lineColour;

    /**
     * No argument Constructor
     */
    public GeometricObject() {

    }

    /**
     * Full argument Constructor
     *
     * @param newX1 the Coordinate x1
     * @param newY1 the Coordinate y1
     * @param newX2 the Coordinate x2
     * @param newLineColour the stroke colour
     * @param newY2 the Coordinate y2
     * @param newLw the line width
     * @param newFillColour the filling colour
     */
    public GeometricObject(double newX1, double newY1, double newX2,
            double newY2, double newLw, Color newFillColour,
            Color newLineColour) {
        x1 = newX1;
        y1 = newY1;
        x2 = newX2;
        y2 = newY2;
        lw = newLw;
        fillColour = newFillColour;
        lineColour = newLineColour;
    }

    /**
     * @return the x1 (horizontal coordinate of first point)
     */
    public double getX1() {
        return x1;
    }

    /**
     * @param x1 the x1 to set (horizontal coordinate of first point)
     */
    @Override
    public void setX1(double x1) {
        this.x1 = x1;
    }

    /**
     * @return the y1 (vertical coordinate of first point)
     */
    public double getY1() {
        return y1;
    }

    /**
     * @param y1 the y1 to set (vertical coordinate of first point)
     */
    @Override
    public void setY1(double y1) {
        this.y1 = y1;
    }

    /**
     * @return the x2 (horizontal coordinate of second point)
     */
    public double getX2() {
        return x2;
    }

    /**
     * @param x2 the x2 to set - (horizontal coordinate of second point)
     */
    @Override
    public void setX2(double x2) {
        this.x2 = x2;
    }

    /**
     * @return the y2 (vertical coordinate of second point)
     */
    public double getY2() {
        return y2;
    }

    /**
     * @param y2 the y2 to set (vertical coordinate of second point)
     */
    @Override
    public void setY2(double y2) {
        this.y2 = y2;
    }

    /**
     * @return the lw (line width)
     */
    public double getLw() {
        return lw;
    }

    /**
     * @param lw the lw to set (line width)
     */
    @Override
    public void setLw(double lw) {
        this.lw = lw;
    }

    /**
     * @return the fillColour (filling colour)
     */
    public Color getFillColour() {
        return fillColour;
    }

    /**
     * @param fillColour the fillColour to set (filling colour)
     */
    @Override
    public void setFillColour(Color fillColour) {
        this.fillColour = fillColour;
    }

    /**
     * @return the lineColour (line colour)
     */
    public Color getLineColour() {
        return lineColour;
    }

    /**
     * @param lineColour the lineColour to set (line colour)
     */
    @Override
    public void setLineColour(Color lineColour) {
        this.lineColour = lineColour;
    }

}
