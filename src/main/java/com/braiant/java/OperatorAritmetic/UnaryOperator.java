package com.braiant.java.OperatorAritmetic;

import java.util.Scanner;

public class UnaryOperator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = sc.nextInt();
        //System.out.println(num);

        // print the results using plus
        int result = +num;
        System.out.println(result);
        // print the results using plus
        result = -num;
        System.out.println(result);
        //print the results using prefix (++exp,--exp)
        System.out.println(++num);
        System.out.println(--num);
        //print the results using postfix (expp++,exp--)
        System.out.println(num++);
        System.out.println(num--);


    }
}
