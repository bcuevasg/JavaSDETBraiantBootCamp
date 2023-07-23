package com.Tareas;


import java.util.stream.Stream;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println("Fibonacci Series");

        int num1 = 0, num2 = 1, limit = 15;

        for(int i = 0; i<limit; i++){
            System.out.println(num1 + " ");
            int sum = num1 + num2;

            num1 = num2;
            num2 = sum;
        }

        int[] fibo = {0,1};
        Stream.iterate(fibo, r -> new int[]{r[1],r[0] +r[1]})
                .limit(14)
                .map(r -> r[0])
                .forEach(x -> System.out.println("Fibonacci stream: " + x));
    }
}
