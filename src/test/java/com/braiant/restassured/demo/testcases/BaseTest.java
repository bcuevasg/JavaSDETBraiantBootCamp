package com.braiant.restassured.demo.testcases;

import com.braiant.baseapi.BaseModel;
import com.braiant.baseapi.RestAssuredUtils;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import org.testng.annotations.BeforeTest;

import java.util.Map;

public class BaseTest extends BaseModel{
    protected Map<String, String> expectedHeaders = Map.of("Content-Type", "application/json");
    protected ResponseOptions<Response> response;

    @BeforeTest
    public void setup() {
        new RestAssuredUtils(BaseModel.BASE_URL, expectedHeaders);
    }
}
