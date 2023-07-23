package com.braiant.OperatorAritmetic;

import java.util.Scanner;

public class TerniaryOperator
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Tu Variable 1 es: ");
        int var1 = sc.nextInt();
        System.out.println("Tu Variable 2 es: ");
        int var2 = sc.nextInt();


        int res;

        if(var1 > var2){
            System.out.println(var1 + var2);
        }else{
            System.out.println(var1 - var2);
        }

        System.out.println((var1>var2)?(var1+var2):(var1-var2));

        res = (var1>var2)?(var1+var2):(var1-var2);

        System.out.println("El resultado es: " + res);

    }
}
