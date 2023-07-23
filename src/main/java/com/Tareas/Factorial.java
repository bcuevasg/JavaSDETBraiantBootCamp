package com.Tareas;

import java.util.stream.IntStream;


public class Factorial {
    public static void main(String[] args) {
        int num = 7;
        int fact = 1;
        for(int i = 1;i<=num;i++){
            fact = fact * i;
        }
        System.out.println("Valor de la forma clasica: " + fact);
        //
        int z = IntStream.rangeClosed(1,num).reduce(1,(x,y) -> x*y);
        System.out.println("Valor de la forma declarativa: " + z);
    }
}
