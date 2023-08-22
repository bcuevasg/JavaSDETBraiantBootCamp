package com.braiant.restassured.testcases;

import com.braiant.restassured.dao.UserGoRest;
import org.testng.annotations.Test;

import static com.braiant.baseapi.RestAssuredUtils.*;

public class UserGorestTest extends BaseTestClass{
    @Test(priority = 1)
    void postExample(){
        response = postWithBody("users", postUserData);
        System.out.printf("The User created is %s", response.getBody().prettyPrint());
    }
    @Test(priority = 2)
    void getExample(){
        response = getElements("users");
        userGoRest = response.getBody().jsonPath().getList(".", UserGoRest.class);
        System.out.println("Test" + userGoRest.get(0).getName());
    }


    @Test(priority = 3)
    void putExample() {
        response = putWithBody("users/" + userGoRest.get(0).getId(), putUserData);
        response = getElements("users");
        userGoRest = response.getBody().jsonPath().getList(".", UserGoRest.class);
        System.out.printf("The User edited now has %s", response.getBody().prettyPrint());
    }
    @Test(priority = 4)
    void deleteExample() {
        System.out.printf("The User deleted is %s", response.getBody().prettyPrint());
        response = deleteElement("users/"+ userGoRest.get(0).getId());

    }
}
