package com.braiant.java.generics;

public class Printer {
    int thingToPrint;

    public int printer(int p){
        this.thingToPrint = p;
        return p;
    }

    public void print(){
        System.out.println(thingToPrint);
    }

//BETTER TO USE PrinterGeneric
}
