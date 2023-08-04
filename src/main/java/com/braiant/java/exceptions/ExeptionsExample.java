package com.braiant.java.exceptions;

public class ExeptionsExample {
    public static void main(String[] args) {
        int a = 5;
        int b = 0;

        //System.out.println(a / b);
        //abajo es el casico try/catch que aplica para identificar errores
        try {
            System.out.println(a/b);

        }catch (ArithmeticException e){
            // e.printStackTrace();
            // System.out.println(b/a);
            System.err.println(e);
            System.err.println(e.getMessage());
        }finally {
            
        }
    }
}
