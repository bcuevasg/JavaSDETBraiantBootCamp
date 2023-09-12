package com.braiant.appium.patronesdediseño.testcases;

import com.braiant.appium.BaseTest;
import com.braiant.appium.patronesdediseño.pf.HomeScreen;
import org.testng.annotations.Test;

public class SauceLabLoginTest extends BaseTest {
    @Test
    void verifyLoginSuccessWithRightCredentials(){
        actualScreen.as(HomeScreen.class).verifyProductsText();
        System.out.println();
    }
}
