package com.braiant.java.lambdas;

public class TestExecute {
    public static void main(String[] args) {
        Cat cat = new Cat();
        //cat.print();
        printThing(cat);
    }

    static void printThing(Printable printable){
        printable.print();
    }

}
