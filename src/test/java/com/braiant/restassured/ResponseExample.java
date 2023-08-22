package com.braiant.restassured;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ResponseExample {
    private static final String BASE_URL = "https://gorest.co.in/public/v2/";
    private static final String TOKEN = "0a08badb0df8d8ea551706a065ed4e13bc5f11b50608fc1017663dc2788039d1";


    ResponseSpecification commonResponseSpec = new ResponseSpecBuilder()
            .expectStatusCode(404)
            .expectContentType("text/html; charset=utf-8")
            .build();


    /*@BeforeClass
    void setup(){
        RestAssured.responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(404)
                .expectContentType("text/html; charset=utf-8")
                .build();
    }*/


    @Test
    void testWithSpecOne(){
        RestAssured.get(BASE_URL +"non/exist/url")
                .then()
                .statusCode(404)
                .contentType("text/html; charset=utf-8");
    }
    @Test
    void testWithSpecTwo(){
        RestAssured.get(BASE_URL +"non/exist/url")
                .then()
                .statusCode(404)
                .contentType("text/html; charset=utf-8");
    }
}
