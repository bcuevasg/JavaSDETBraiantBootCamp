package com.braiant.java.abstraction;

public class Rectangle extends Shape {

    private final double width;
    private final double lenght;

    public Rectangle(double width, double lenght) {
        this.width = width;
        this.lenght = lenght;
    }

    @Override
    public double area() {
        return width * lenght;
    }

    @Override
    public double perimeter() {
        return 2 * (width + lenght);
    }
    @Override
    public String shapeName() {
        return "I'm Rectangle";
    }
}
