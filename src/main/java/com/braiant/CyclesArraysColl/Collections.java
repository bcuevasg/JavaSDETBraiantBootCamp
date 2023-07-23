package com.braiant.CyclesArraysColl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Collections {
    public static void main(String[] args) {


        Set<String> country = new HashSet<>();

        country.add("Mexico");
        country.add("UK");
        country.add("Australia");

        //Collections do not allow duplicates the record bellow will not be added.
        country.add("Mexico");

        System.out.println(country);
        System.out.println(country.size());

        //Removing a record from the collection
        country.remove("Australia");
        System.out.println("El set despues de remover australia es: "+ country);
        System.out.println(country.size());

        //Iterando dentro de la lista restante de country necesitamos crear el iterador de la lista y despues loopear.
        Iterator<String> i = country.iterator();
        while(i.hasNext()){
            System.out.println(i.next());
        }

    }
}
