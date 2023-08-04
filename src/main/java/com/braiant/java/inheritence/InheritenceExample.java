package com.braiant.java.inheritence;

public class InheritenceExample {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.eat();
        animal.walk();

        Cat garfiel = new Cat();
        garfiel.eat();
        garfiel.walk();
        garfiel.hateMondays();

        Dog perro = new Dog();
        perro.eat();
        perro.walk();
        perro.loveDogChou();

        Bird piolin = new Bird();
        piolin.eat();
        piolin.walk();
        piolin.drinkWater();
    }
}
