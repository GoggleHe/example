package org.example.designpattern.decorator;

/**
 *
 **/
public class RedShapeDecorator extends ShapeDecorator{

    public RedShapeDecorator(Shape shape) {
        super(shape);
    }

    @Override
    public void draw() {
        setRed();
        shape.draw();
    }

    private void setRed(){
        System.out.println("Color : red");
    }
}
