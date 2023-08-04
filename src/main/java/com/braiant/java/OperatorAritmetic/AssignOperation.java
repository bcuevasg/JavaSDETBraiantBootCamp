package com.braiant.java.OperatorAritmetic;

import java.util.Scanner;

public class AssignOperation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter first number: ");
        int num1 = sc.nextInt();

        System.out.println("Enter second number: ");
        int num2 = sc.nextInt();

        num1 *= num2; // n1 += n2 , n1 -= n2 , n1 *= n2 , n1 /= n2
        System.out.println(num1);
    }
}
