package com.braiant.CyclesArraysColl;

import java.util.*;

public class MapsExample {
    public static void main(String[] args) {
        Map<String,Integer> numsMap = new HashMap<>();

        numsMap.put("A", 100);
        numsMap.put("B", 200);
        numsMap.put("C", 300);
        numsMap.put("D", 400);

        System.out.println(numsMap.size());

        for(Map.Entry<String,Integer> subMapNum:numsMap.entrySet()){
            System.out.println(subMapNum.getKey() + ": " + subMapNum.getValue());
        }

        Map<String,String> user = new HashMap<>();
        user.put("Admin", "Señor Barriga");
        user.put("NormalUser", "El Chavo");
        user.put("SuperUser", "Kiko");
        user.put("Guest", "Donna florinda");

        System.out.println(user.size());

        for (Map.Entry<String,String> users: user.entrySet()) {
            if (users.getKey().equals("Admin")) {
                System.out.println("The Admin Value is: " + users.getValue());

            }
            System.out.println(users.getKey());
        }
        //Map with string and a list as values to accept
        /*Map<String, List<String>> dropDownInfo = new LinkedHashMap<>();
        List<String> lstFruit = new ArrayList<>();
        lstFruit.add("Pinnaple");
        lstFruit.add("Banana");
        lstFruit.add("Apple");
        lstFruit.add("Blueberry");

        dropDownInfo.put("Fruits", lstFruit);

        for(Map.Entry<String,List<String>> fruit: dropDownInfo.entrySet()){
            System.out.println("My "+ fruit.getKey() + " contains " + fruit.getValue());
            fruit.getValue().forEach(x->) {
                if(x.equals("Banana") {
                    System.out.println("I found the Banana");
                }
            }
        }*/




    }
}
