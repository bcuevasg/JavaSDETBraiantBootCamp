package com.braiant.testNG.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ItestContextExample {

    //Estos son los datos y pueden estar en la clase pero igual se pueden mandar a otra como en TestData class
    /*@DataProvider(name = "SchoolProvider")
    Object[][] getSchoolData(){
        return new Object[][]{
                {"Gil", "Braiant", "Luis", "Daniel"},
                {"Jimena", "Jennifer", "Luisa", "Maria"},
                {"User1", "User2", "User3", "User4"}
        };
    }*/

    @Test(enabled = false, dataProvider = "SchoolProvider", dataProviderClass = TestData.class)
    void datProviderITest(String name1, String name2, String name3, String name4) {
        System.out.println(name1);
        System.out.println(name2);
        System.out.println(name3);
        System.out.println(name4);

    }


    // los siguientes 2 test requieren correr xml ItestContext
    @Test(enabled = false, dataProvider = "getBookData", dataProviderClass = TestData.class, groups = "Smoke")
    void datProviderITestSomoke(String title, String author, String year, String type) {
        System.out.println(title);
        System.out.println(author);
        System.out.println(year);
        System.out.println(type);
    }

    @Test(enabled = false, dataProvider = "getBookData", dataProviderClass = TestData.class, groups = "Regression")
    void datProviderITestRegression(String title, String author) {
        System.out.println(title);
        System.out.println(author);

    }

    @Test(dataProvider = "getBookMethodData", dataProviderClass = TestData.class, groups = "Regression")
    void verifyBookCompleteInfo(String title, String author, String year, String type) {
        System.out.println(title);
        System.out.println(author);
        System.out.println(year);
        System.out.println(type);
    }

    @Test(dataProvider = "getBookMethodData", dataProviderClass = TestData.class, groups = "Regression")
    void verifyBookNameAndAuthor(String title, String author) {
        System.out.println(title);
        System.out.println(author);
    }
}