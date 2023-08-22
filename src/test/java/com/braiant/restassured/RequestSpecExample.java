package com.braiant.restassured;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.Map;

import static com.braiant.baseapi.ConfigFactory.getDefaultConfig;

public class RequestSpecExample {
    private static final String BASE_URL = "https://gorest.co.in/public/v2/";
    private static final String TOKEN = "0a08badb0df8d8ea551706a065ed4e13bc5f11b50608fc1017663dc2788039d1";

    Map<String,String> expectedHeaders = Map.of("Authorization","Bearer " + TOKEN,
            "Content-Type", "application/json",
            "Accept","*/*");

    @Test
    void usingLocalRequestSpec(){
        RestAssured
                .given()
                    .spec(getDefaultRequestSpec())
                .when()
                    .get()
                .then()
                    .statusCode(200);
    }
    private static RequestSpecification getDefaultRequestSpec(){
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URL+"users")
                .setConfig(getDefaultConfig())
                .build();
    }
}
