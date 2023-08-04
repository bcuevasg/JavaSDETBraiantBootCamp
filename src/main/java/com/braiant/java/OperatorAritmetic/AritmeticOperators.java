package com.braiant.java.OperatorAritmetic;

import java.util.Scanner;

public class AritmeticOperators {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter first number: ");
        double num1 = sc.nextDouble();

        System.out.println("Enter second number: ");
        double num2 = sc.nextDouble();

        double sum = num1 + num2;
        double sub = num1 - num2;
        double mult = num1 * num2;
        double div = num1 / num2;

        System.out.println("The Sum of the two numbers is: " + sum);
        System.out.println(String.format("The Differece of the two numbers is %f and the product is %f", sub, mult));
        System.out.println("The quotient of the two numbers is: " + div);
    }
}
