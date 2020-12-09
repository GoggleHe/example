package org.example.designpattern.decorator;

public abstract class ShapeDecorator implements Shape{
    protected Shape shape;

    public ShapeDecorator(Shape shape) {
        this.shape = shape;
    }

    @Override
    public void draw() {
        shape.draw();
    }

    @Override
    public double area(){
        return shape.area();
    }

    @Override
    public double girth(){
        return shape.girth();
    }
}
