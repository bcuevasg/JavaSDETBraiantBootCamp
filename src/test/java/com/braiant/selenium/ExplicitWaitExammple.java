package com.braiant.selenium;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ExplicitWaitExammple extends BaseTestClass {
    String actResult = "";
    String expResult = "Titanium School";

    WebDriverWait wait;

    @Test
    void explicitTest() throws InterruptedException {
        driver.navigate().to(demoSite);
        driver.manage().window().maximize();
        // Create object
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        //Expected Conditions
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("user_login"))));
        WebElement txtUsername = driver.findElement(By.id("user_login"));
        txtUsername.clear();
        txtUsername.sendKeys(userName);

        WebElement txtPassword = driver.findElement(By.name("pwd"));
        txtPassword.clear();
        txtPassword.sendKeys(password);

        WebElement chkRememberMe = driver.findElement(By.cssSelector("#rememberme"));
        chkRememberMe.click();

        WebElement btnLogin = driver.findElement(By.xpath("//input[contains(@value,'Log')]"));
        btnLogin.click();

        // WebElement exist and assign explicit wait with lambda expressions
        WebElement lblTitaniumTitle = new WebDriverWait(driver,Duration.ofSeconds(8))
                .until(driver -> driver.findElement(By.className("wpsp-schoolname")));
        actResult = lblTitaniumTitle.getText();
        System.out.println(actResult);

        Assert.assertEquals(actResult, expResult, "El texto no es igual");
    }
}

