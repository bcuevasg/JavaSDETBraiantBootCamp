package com.braiant.polymorphism.inheritance;

public class ElectricBicycle extends Vehicle{
    public void energizeEngine(){
        System.out.println("Engine energized");
    }

    public void turnOnScreen(){
        System.out.println("Screen turned on!");
    }

    public void turnOn(){
        energizeEngine();
        turnOnScreen();
    }
}
