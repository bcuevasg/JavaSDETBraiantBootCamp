package com.braiant.java.interfaces;

import java.util.Random;

public class TestVehicle {
    public static void main(String[] args) {
        Vehicle[] vehicles;
        Random random = new Random();

        vehicles = new Vehicle[6];
        vehicles[0] = new Moto();
        vehicles[1] = new Car();
        vehicles[2] = new Moto();
        vehicles[3] = new Moto();
        vehicles[4] = new Car();
        vehicles[5] = new Moto();

        int upperBound = 200;

        for (Vehicle vehicle: vehicles){
            System.out.println(vehicle.accelerate(random.nextInt(upperBound)));
            System.out.println(vehicle.stop(random.nextInt(upperBound)));
        }

    }
}
