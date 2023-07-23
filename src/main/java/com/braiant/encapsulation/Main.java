package com.braiant.encapsulation;


class Person{

    public String name;
    private int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
public class Main {
    public static void main(String[] args) {
        Person person = new Person();
        person.name = "Braiant";
        person.setName("Braiant");
        person.setAge(33);

    }
}