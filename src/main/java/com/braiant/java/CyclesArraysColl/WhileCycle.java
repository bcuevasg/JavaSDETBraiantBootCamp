package com.braiant.java.CyclesArraysColl;

public class WhileCycle {
    public static void main(String[] args) {

        int i = 1;
        while (i<6){
            System.out.println("Hi number: "+i);
            i++;
        }

        int x = 1;
        int sum = 0;

        while (x<=10){
            sum += x;
            System.out.println("La suma es: "+sum);
            x++;
        }
    }
}
