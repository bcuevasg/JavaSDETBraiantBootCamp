package com.braiant.CyclesArraysColl;

public class Arrays {
    public static void main(String[] args) {
        int[] arr;
        arr = new int[5]; // Delara Array con 5 posiciones en este caso

        arr[0] = 10;
        arr[1] = 20;
        arr[2] = 30;
        arr[3] = 40;
        arr[4] = 50;

       /* for(int i=0; i < arr.length; i++){
            System.out.println("Array is: "+ arr[i]);
        }*/

        int[][] arr1 = {
                {1,2,3},
                {4,5,6},
                {7,8,9},
                {0,10,11}
        };

        for (int l=0; l< arr1.length; l++){
            for(int j=0; j<3;j++){
                System.out.println(arr1[l][j]);
            }
        }


    }
}
