package com.braiant.CyclesArraysColl;

public class FORcycle {
    public static void main(String[] args) {
        for(int i = 0; i <= 10 ;i++){
            System.out.println(i);
        }

        int weeks = 2;
        int days = 7;

        for (int z = 1; z <= weeks;z++){
            System.out.println("Week: "+ z);
            for(int j = 1; j <= days;j++){
                System.out.println("      Day: "+ j);
            }
        }
    }
}
