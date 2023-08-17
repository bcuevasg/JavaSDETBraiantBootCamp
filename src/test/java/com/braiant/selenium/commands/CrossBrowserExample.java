package com.braiant.selenium;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserExample extends BaseTestClass{
    @BeforeClass
    void navigateToDemoSite(){
        driver.navigate().to(demoSite);
    }

    @Test
    void verifyRegisterLinkIsNotBroken(){
        driver.findElement(By.linkText("Register")).click();
        Assert.assertTrue(driver.getTitle().contains("Registration Form"));
    }

    @Test
    void verifyLostPasswordLinkIsNotBroken(){
        driver.findElement(By.linkText("Lost your password?")).click();
        Assert.assertTrue(driver.getTitle().contains("Lost Password"));
    }

}
