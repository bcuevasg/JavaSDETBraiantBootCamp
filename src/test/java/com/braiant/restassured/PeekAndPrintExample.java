package com.braiant.restassured;

import com.braiant.selenium.patronesdediseño.testcases.BaseTest;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class PeekAndPrintExample {
    private static final String BASE_URL = "https://api.github.com/users";

    @Test
    void peekTest(){
        RestAssured.get(BASE_URL)
                .peek();
    }
    @Test
    void prettypeekTest(){
        RestAssured.get(BASE_URL)// si cambiamos get a options imprimira otros headers para manipulacion
                    .prettyPeek();
    }

    @Test
    void printTest(){
        RestAssured.get(BASE_URL)
                .print();
    }
    @Test
    void prettyPrintTest(){
        RestAssured.get(BASE_URL)
                .prettyPrint();
    }
}
