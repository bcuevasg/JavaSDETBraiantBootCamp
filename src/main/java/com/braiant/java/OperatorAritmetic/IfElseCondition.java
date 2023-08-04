package com.braiant.java.OperatorAritmetic;

import java.util.Scanner;

public class IfElseCondition
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your Hero: ");
        String hero = sc.nextLine();

        String badPerson = "";
        System.out.println(hero);


        //Este es el ejemplo if-else
        /*if (hero.equals("Iron-Man")){
            badPerson = "Mandarin";
        } else {
            badPerson = "Loki";
        }*/

        badPerson = (hero.equals("Iron-Man") ? "Mandarin":"Loki");

        System.out.println(badPerson);



        //Este es el ejemplo if-elseif
        /*if (hero.equals("Iron-Man")){
            badPerson = "Mandarin";
        } else if (hero.equals("Spider-Man")){
            badPerson = "Venom";
        } else if (hero.equals("Thor")){
            badPerson = "Loki";
        } else if (hero.equals("Capitan America")){
            badPerson = "Red Skull";
        }
        System.out.println(badPerson);*/


    }
}
