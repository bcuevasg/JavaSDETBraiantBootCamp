package com.braiant.CyclesArraysColl;

import java.util.ArrayList;
import java.util.List;

public class ListCollection {
    public static void main(String[] args) {
        List<String> cars = new ArrayList<>();
        cars.add("BMW");
        cars.add("Audi");
        cars.add("Porsche");
        cars.add("Mercedez");
        cars.add("Mercedez");
        cars.add("Porshe");

        System.out.println(cars.size());
        System.out.println(cars);

        cars.set(4, "Jaguar");
        System.out.println(cars);

        int index = cars.indexOf("Audi");
        System.out.println("The first occurrence of Audi is at index: "+ index);

        int lastIndex = cars.lastIndexOf("Porshe");
        System.out.println("The last occurrence of Porsche is at index: "+ lastIndex);

        for(String car:cars){
            System.out.println("The Car is: "+ car);
        }
        for(int i = 0;i<cars.size();i++){
            System.out.println("The car using normal for is: "+ cars.get(i));
        }
    }
}
