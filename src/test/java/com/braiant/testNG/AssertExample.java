package com.braiant.testNG;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertExample {
    int num1 = 1;
    int num2 = 2;

    private int sum(int num1, int num2){
        return num1 + num2;
    }

    @Test
    void testCorrectSum(){
        Assert.assertEquals(sum(num1,num2), 3, "Sum is incorrect");
    }

    // Test case que usa hard assert (si falla no realiza los siguientes pasos)
    @Test
    void verifyWrongSum(){
        System.out.println("Step 1");
        Assert.assertEquals(sum(num1,num2), 10, "Sum is incorrect");
        System.out.println("Step 2");
        Assert.assertTrue(num1 == 1);
    }
// Test case que usara el soft assert
    @Test
    void verifyWrongSumSoftAssert(){
        SoftAssert softAssert = new SoftAssert();// Requiere crearse para poder realizar soft asserts (delcaracion objeto)
        System.out.println("Step 1");
        softAssert.assertEquals(sum(num1,num2), 10, "Sum is incorrect");
        System.out.println("Step 2");
        softAssert.fail("Second Failure");
        System.out.println("Step 3, I'm here, save me");
        softAssert.assertTrue(num1 == 1);
        softAssert.assertAll();
    }

}
