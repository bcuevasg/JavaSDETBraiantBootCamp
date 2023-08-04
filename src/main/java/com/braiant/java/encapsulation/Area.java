package com.braiant.java.encapsulation;

public class Area {
    int lenght;
    int breadth;

    public Area(int lenght, int breadth) {
        this.lenght = lenght;
        this.breadth = breadth;
    }

    public void getArea(){
        int area = lenght * breadth;
        System.out.println("Area is: " + area);
    }


}
