package com.braiant.selenium;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CrossBrowserExample extends BaseTestClass{
    @BeforeTest
    void navigateToDemoSite(){
        driver.navigate().to(demoSite);
    }

    @Test
    void verifyRegisterLinkIsNotBroken(){

    }

    @Test
    void verifyLostPasswordLinkIsNotBroken(){

    }

}
