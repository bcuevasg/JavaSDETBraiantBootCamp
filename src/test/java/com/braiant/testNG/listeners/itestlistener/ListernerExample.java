package com.braiant.testNG.listeners.itestlistener;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(MyListener.class)
public class ListernerExample {
    @Test
    void testA(){
        System.out.println("TestA");
        Assert.fail();
    }
    @Test
    void testB(){
        System.out.println("TestB");
        Assert.assertTrue(true);
    }
    @Test
    void testC(){
        System.out.println("TestC");
        Assert.assertEquals("a", "a");
    }
    @Test
    void testD(){
        System.out.println("TestD");
        Assert.assertFalse("a".equals("a"));

    }
}
