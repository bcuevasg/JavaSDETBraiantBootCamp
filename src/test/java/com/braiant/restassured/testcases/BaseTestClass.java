package com.braiant.restassured.testcases;

import com.braiant.baseapi.RestAssuredUtils;
import com.braiant.restassured.dao.UserGoRest;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import org.testng.annotations.BeforeTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BaseTestClass {
    public static final String BASE_URL = "https://gorest.co.in/public/v2/";
    private static final String TOKEN = "0a08badb0df8d8ea551706a065ed4e13bc5f11b50608fc1017663dc2788039d1";

    Map<String,String> expectedHeaders = Map.of("Authorization","Bearer " + TOKEN,
            "Content-Type", "application/json",
            "Accept","*/*");
    List<UserGoRest> userGoRest = new ArrayList<>();
    protected Map<String, String> postUserData = Map.of("name", "Braiant Cuevas",
                    "gender","male",
                    "email","braiant.cuevas@gmail.com",
                    "status","inactive");

    protected Map<String, String> putUserData = Map.of("name", "Bcuevass",
                    "email","braiant@gmail.com",
                    "status","active"
                    );
    protected ResponseOptions<Response> response;

    @BeforeTest
    public void setup(){
        new RestAssuredUtils(BASE_URL,expectedHeaders);
    }
}
