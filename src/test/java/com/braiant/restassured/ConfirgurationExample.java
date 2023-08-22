package com.braiant.restassured;

import com.braiant.restassured.dao.AnotherUser;
import io.restassured.RestAssured;
import io.restassured.config.FailureConfig;
import io.restassured.config.RedirectConfig;
import io.restassured.listener.ResponseValidationFailureListener;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.braiant.baseapi.ConfigFactory.getDefaultConfig;
import static org.hamcrest.Matchers.*;

public class ConfirgurationExample {
    private static final String BASE_URL = "https://api.github.com/";

    @Test(enabled = false)
    void maxRedirect(){
        RestAssured.config =RestAssured.config()
                .redirect(RedirectConfig.redirectConfig().followRedirects(true).maxRedirects(1));

        RestAssured.get(BASE_URL + "repos/twitter/bootstrap")
                .then()
                .statusCode(200);

    }

    @Test(enabled = false)
    void failureConfig(){
        ResponseValidationFailureListener failureListener = (reqSpec, resSpec, response)->
            System.err.printf("API Failure: response status %s and the body contains: %s",
                    response.getStatusCode(), response.getBody().asPrettyString());

            RestAssured.config = RestAssured.config()
                    .failureConfig(FailureConfig.failureConfig().failureListeners(failureListener));

            RestAssured.get(BASE_URL + "users/kevinclark")
                    .then()
                    .body("body.path", equalTo("some"));//cause to fail since we are expecthing other than "some"
    }
    @BeforeClass
    void setup() {
        RestAssured.config = getDefaultConfig();
    }

    @Test
    void cleanTestWithHiddingConfig() {
        AnotherUser user = RestAssured.get(BASE_URL + "users/kevinclark")
                .as(AnotherUser.class);
        Assert.assertEquals(user.getLogin(), "kevinclark");
    }

}
