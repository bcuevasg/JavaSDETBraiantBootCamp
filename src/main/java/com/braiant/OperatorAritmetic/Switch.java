package com.braiant.OperatorAritmetic;

import java.util.Scanner;

public class Switch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingresa tu heroe: ");
        String hero = sc.nextLine();
        String villain = "";

        //CASO SWITCH
        /*
        switch (hero) {
            case "Spider-Man":
                villain = "Venom";
                break;
            case "Iron-Man":
                villain = "Mandarin";
                break;
            case "Thor":
                villain = "Loki";
                break;
            case "Capitan-America":
                villain = "RedSkull";
                break;
            default:
                villain = "Venom";
        }
         */

        //Mismo caso de arriba mas simplificado no usando break ya que la estructura lo permite
        /*switch (hero) {
            case "Spider-Man" -> {villain = "Venom";}            }
            case "Thor" -> {villain = "Loki";}
            case "Iron-Man" -> {villain = "Mandarin";}
            case "Capitan-America" -> {villain = "RedSckull";}
            default -> {villain = "El heroe no tiene enemigo";}
        }*/

        //Aun mas reducido ya que al final usamos la misma variable
        villain = switch (hero){
            case "Spider-man" -> "Venom";
            case "Iron-man" -> "Mandarin";
            case "Hulk" -> "Abominacion";
            case "Thor" -> "Loki";
            default -> "El heroe no tiene enemigo congrats";
        };



        System.out.println("Tu enemigo es " + villain);




    }
}
