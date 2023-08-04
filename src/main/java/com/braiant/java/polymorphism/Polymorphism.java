package com.braiant.java.polymorphism;

import com.braiant.java.polymorphism.coercion.TripleNumber;
import com.braiant.java.polymorphism.inheritance.*;
import com.braiant.java.polymorphism.overload.Robot;
import com.braiant.java.polymorphism.parametric.Persona;

import java.util.ArrayList;
import java.util.List;

public class Polymorphism {
    public static void main(String[] args) {

       // los ejemplos de abajo usan polymorfismo por sobrecarga(overload)
        Robot droide = new  Robot();
        droide.hello();
        droide.hello("Fernando");
        droide.hello("Pancho", 213);
//----------------------
        //Coercion sucede en la clase tripleNumber donde se forza que todos los numeros sean Double
        TripleNumber t = new TripleNumber();
        double num1 = 2.5;
        int num2 = 5;

        System.out.println(t.tripler(num1));
        System.out.println(t.tripler(num2));
        System.out.println(t.tripler(1.4f));

//----------------------
        // Aqui esta el uso de los valores parametricos ya que guardamos una clase que maneja las listas y
        // regresa resultados
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona("Luis", 32));
        personas.add(new Persona("Fercho",29));

        for(Persona persona:personas){
            persona.returnInformation();
        }
//----------------------
        test(new Vehicle());
        test(new Airplane());
        test(new ElectricBicycle());

        food(new Cutlery());
        food(new Spoon());
        food(new Fork());
        food(new Knife());
    }


    public static void test(Vehicle v){
        v.turnOn();
    }

    public static void food(Cutlery h){
        h.letsEat();
    }


}
