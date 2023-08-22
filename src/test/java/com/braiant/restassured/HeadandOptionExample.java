package com.braiant.restassured;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.util.Collections;

import static org.hamcrest.Matchers.*;

public class HeadandOptionExample {
    private static final String BASE_URL = "https://api.github.com";

    @Test
    void headTest(){
        RestAssured.head(BASE_URL)
                .then()
                .statusCode(200)
                .body(emptyOrNullString());
    }
    @Test
    void optionTest(){
        RestAssured.options(BASE_URL)
                .then()
                .statusCode(204)
                .headers("access-control-allow-methods", equalTo("GET, POST, PATCH, PUT, DELETE"))
                .body(emptyOrNullString());
    }

}
