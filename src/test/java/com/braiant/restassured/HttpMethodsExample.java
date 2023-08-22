package com.braiant.restassured;

import com.braiant.restassured.dao.UserGoRest;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.containsString;

public class HttpMethodsExample {
    private static final String BASE_URL = "https://gorest.co.in/public/v2/";
    private static final String TOKEN = "0a08badb0df8d8ea551706a065ed4e13bc5f11b50608fc1017663dc2788039d1";

    Map<String,String> expectedHeaders = Map.of("Authorization","Bearer " + TOKEN,
            "Content-Type", "application/json",
            "Accept","*/*");
    List<UserGoRest> usesGoRest = new ArrayList<>();
    @Test(priority = 1)
    void postExample(){
        RestAssured
                .given()
                .headers(expectedHeaders)
                .body("{\n" +
                        "   \"name\":\"Braiant Cuevas\",\n" +
                        "   \"gender\":\"male\",\n" +
                        "   \"email\":\"braiant.cuevas@gmail.com\",\n" +
                        "   \"status\":\"inactive\" \n" +
                        "}")
                .when()
                    .post(BASE_URL + "users")
                .then()
                .statusCode(201);
    }

    @Test(priority = 2)
    void putExample(){
        RestAssured
                .given()
                .headers(expectedHeaders)
                .body("{\n" +
                        "   \"name\":\"Braiant Cuevas1\",\n" +
                        "   \"gender\":\"male\",\n" +
                        "   \"email\":\"braiant.cuevas@gmail.com\",\n" +
                        "   \"status\":\"inactive\" \n" +
                        "}")
                .when()
                .put(BASE_URL + "users/" + usesGoRest.get(0).getId())
                .then()
                .statusCode(200);
        System.out.println(usesGoRest.get(0).getName());
    }
    @Test(priority = 3)
    void deleteExample(){
        RestAssured
                .given()
                    .headers(expectedHeaders)
                .when()
                    .delete(BASE_URL + "users/" + usesGoRest.get(0).getId())
                .then()
                    .statusCode(204);

    }


    @Test(enabled = false)
    void getNoBDD() {
        /*RestAssured.request(Method.GET, BASE_URL+ "users")
                .then()
                .statusCode(200)
                .body("name[0]",containsString("Sher Singh"));*/

        RestAssured.request("GET", BASE_URL + "users")
                .then()
                .statusCode(200)
                .body("name[0]", containsString("Sher Singh"));
    }

    @Test(enabled = false)
    void traceExample() {
        RestAssured.request(Method.TRACE, BASE_URL)
                .then()
                .statusCode(405);
    }

    @AfterMethod
    void getExample(){
        usesGoRest = RestAssured.given()
                .headers(expectedHeaders)
                .when()
                .get(BASE_URL + "users")
                .then()
                .extract()
                .body()
                .jsonPath()
                .getList(".", UserGoRest.class);

        System.out.println(usesGoRest.get(0).getName());
    }

}
