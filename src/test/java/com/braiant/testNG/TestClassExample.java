package com.braiant.testNG;

import org.testng.annotations.*;

@Test(description = "Test class for banking accounts")
public class TestClassExample {
    @BeforeSuite
    void beforeSuite() {
        System.out.println("Esto se ejecuta ANTES de la suite");
    }

    @BeforeTest
    void beforeTes() {
        System.out.println("Esto se ejecuta ANTES de la primer prueba que encuentre");
    }

    @BeforeClass
    void beforeClass() {
        System.out.println("Esto se ejecuta ANTES de las clases de prueba");
    }

    @BeforeMethod
    void beforeMethod() {
        System.out.println("Esto se ejecuta ANTES de cada MÉTODO de prueba en mi clase");
    }

    @AfterMethod
    void afterMethod() {
        System.out.println("Esto se ejecuta DESPUÉS de cada MÉTODO de prueba en mi clase");
    }

    @AfterClass
    void AfterClass() {
        System.out.println("Esto se ejecuta DESPUÉS de las clases de prueba");
    }

    @AfterTest
    void afterTes() {
        System.out.println("Esto se ejecuta DESPUÉS de la primer prueba que encuentre");
    }

    @AfterSuite
    void afterSuite() {
        System.out.println("Esto se ejecuta DESPUÉS de la suite");
    }

    public void testA() {
        System.out.println("Test A");
    }

    public void testB() {
        System.out.println("Test B");
    }

    public void testC() {
        System.out.println("Test C");
    }
}
