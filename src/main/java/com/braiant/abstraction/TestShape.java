package com.braiant.abstraction;

public class TestShape {
    public static void main(String[] args) {
        // Variable for Rectangle
        double width = 5;
        double lenght = 12;

        Shape rectangle = new Rectangle(width, lenght);
        System.out.println("Rectangle area: " + rectangle.area() +
                "\nRectangle perimeter: " + rectangle.perimeter());

        //Circle
        double radious = 5;
        Shape circle = new Circle(radious);
        System.out.println("Circle area: " + circle.area() +
                "\nCircle perimeter: " + circle.perimeter());

        //Triangle
        double a = 5;
        double b = 4;
        double c = 3;
        Shape triangle = new Triangle(a, b, c);
        System.out.println("Triangle area: " + circle.area() +
                "\nTriangle perimeter: " + circle.perimeter());
    }
}
