package org.example.designpattern.decorator;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 *
 **/
public class Main {

    public static void main(String[] args) {

        Shape circle = new RedShapeDecorator(new Circle(1));
        circle.draw();
        System.out.println(circle.area());
        System.out.println(circle.girth());

        Shape rectangle = new RedShapeDecorator(new Rectangle(2, 1));
        rectangle.draw();
        System.out.println(rectangle.girth());
        System.out.println(rectangle.area());

    }

}
