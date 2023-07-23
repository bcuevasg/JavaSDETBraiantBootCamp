package com.braiant.lambdas;


public class Cat implements Printable{
    public String name;
    public int age;

    @Override
    public void print() {
        System.out.println("Cat does Meowww");
    }
}
