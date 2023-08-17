package com.braiant.selenium.commands;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class locatorsExample {
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
        driver.findElement(By.id("user_login")).clear();
        driver.findElement(By.id("user_login")).sendKeys(userName);
        driver.findElement(By.name("pwd")).clear();
        driver.findElement(By.name("pwd")).sendKeys(password);
        driver.findElement(By.cssSelector("#rememberme")).click();
        driver.findElement(By.xpath("//input[contains(@value,'Log')]")).click();

        actualResult = driver.findElement(By.className("wpsp-schoolname")).getText();
        Assert.assertEquals(actualResult,expectedResult, "El texto no es igual");
        //Thread.sleep(2000);

    }
    @AfterClass
    void closeWeb(){
        driver.quit();
    }
}
