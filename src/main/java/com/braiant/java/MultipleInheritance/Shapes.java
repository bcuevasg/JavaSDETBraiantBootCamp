package com.braiant.java.MultipleInheritance;

import java.util.LinkedList;

public class Shapes {
    private LinkedList<Shape> shapeLinkedList = new LinkedList<>();

    public void addShape (Shape shape){
        shapeLinkedList.add(shape);
    }

    public void list(){
        for(Shape shape: shapeLinkedList){
            System.out.println("Shame name is: " + shape.shapeName() );
            if (shape instanceof Sides){
                Sides s =(Sides)shape;
                System.out.println("The number of sides is: " + s.numSides());
            }
        }
    }
}
