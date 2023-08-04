package com.braiant.java.polymorphism.inheritance;

public class Airplane extends Vehicle {
    public void fuelMix(){
        System.out.println("Fuel mixed!");
    }

    public void injectFuel(){
        System.out.println("Fuel is injected");
    }


    public void turnOn(){
        fuelMix();
        injectFuel();

    }

}
