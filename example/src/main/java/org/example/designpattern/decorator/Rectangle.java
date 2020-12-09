package org.example.designpattern.decorator;

/**
 *
 **/
public class Rectangle implements Shape {

    private double length;

    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public void draw() {
        System.out.println("rectangle");
    }

    @Override
    public double girth() {
        return length * width * 2;
    }

    @Override
    public double area() {
        return length * width;
    }
}
