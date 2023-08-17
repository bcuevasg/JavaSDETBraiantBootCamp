package com.braiant.selenium.commands;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebElementExample {
    WebDriver driver;
    String demoSiteUrl = "https://demosite.titaniuminstitute.com.mx/wp-admin/admin.php?page=sch-dashboard";
    String actualResult = "";
    String expectedResult = "Titanium School";
    String userName ="admin";
    String password = "G3-ySzY%";
    @BeforeTest
    void setup(){
        WebDriverManager.chromedriver().setup();
        //La accion de abajo abre el navegador
        driver = new ChromeDriver();
    }

    @Test
    void retunValue() throws InterruptedException {
        //navegar al demo site
        //driver.get(demoSiteUrl); // igual abre el site como el comando de abajo pero el de abajo permite mas
        driver.navigate().to(demoSiteUrl);
        driver.manage().window().maximize();//agranda la instancia de chrome que se abrira

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

        WebElement lblTitaniumTitle = driver.findElement(By.className("wpsp-schoolname"));
        actualResult = lblTitaniumTitle.getText();

        Assert.assertEquals(actualResult,expectedResult, "El texto no es igual");
        Thread.sleep(2000);

    }
    @AfterClass
    void closeWeb(){
        driver.quit();
    }
}
