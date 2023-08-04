package com.braiant.java.polymorphism.overload;

public class Robot {
    public void hello (){
        System.out.println("Hello, I'm a Republic Robot");
    }

    public void hello (String name){
        System.out.println("Hello, my robot name is " + name);
    }

    public void hello (String name, int age){
        System.out.println("Hello, my robot name is "+ name + " y tengo los siguientes años " + age);
    }


}
