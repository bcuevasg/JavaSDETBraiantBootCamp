package com.braiant.java.interfaces;

public class Car implements Vehicle{
    int speed = 0;

    @Override
    public String stop(int quantity) {
        speed -=  quantity;
        if (speed <= 0){
            speed = 0;
        }
        return "The Car has reduce their speed and now is " + speed + "Km/h";
    }

    @Override
    public String accelerate(int quantity) {
        String speeding = "";
        speed += quantity;

        if (speed > maxSpeed) {
            speeding = "Speeding ";
        }
        speeding += "The car  is going at " + speed + "Km/h";
        return speeding;
    }
    @Override
    public void vehicleName(String name) {
        System.out.println("I'm a car");

    }
}
