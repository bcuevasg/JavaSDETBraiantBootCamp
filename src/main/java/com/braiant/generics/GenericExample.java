package com.braiant.generics;

public class GenericExample {
    public static void main(String[] args) {
        Printer p = new Printer();
        p.printer(10);
        p.print();


        PrinterString r = new PrinterString();
        r.printer("Testing");
        r.print();

        //Better to use this doc
        PrinterGeneric rd = new PrinterGeneric();
        rd.print("Testing12");
        rd.print(123);

    }
}
