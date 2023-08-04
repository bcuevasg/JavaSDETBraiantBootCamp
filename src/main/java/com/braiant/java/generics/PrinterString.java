package com.braiant.java.generics;

public class PrinterString {
    String thingToPrint;

    public String printer(String p) {
        this.thingToPrint = p;
        return p;
    }

    public void print() {
        System.out.println(thingToPrint);
    }

    //BETTER TO USE PrinterGeneric
}
