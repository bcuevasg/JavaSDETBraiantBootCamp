package com.braiant.java.MultipleInheritance;

public class Circle extends Shape{
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculatedArea() {
        return Math.PI * radius;
    }

    @Override
    public String shapeName() {
        return "Circle";
    }
}