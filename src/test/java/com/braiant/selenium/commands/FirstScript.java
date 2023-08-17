package com.braiant.selenium.commands;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FirstScript {
    WebDriver driver;
    String demoSiteUrl = "https://demosite.titaniuminstitute.com.mx/wp-admin/admin.php?page=sch-dashboard";
    String actualResult = "";
    String expectedResult = "TI Demo Site";
    @BeforeTest
    void setup(){
        WebDriverManager.chromedriver().setup();
        //La accion de abajo abre el navegador
        driver = new ChromeDriver();
    }

    @Test
    void retunValue(){
        //navegar al demo site
        //driver.get(demoSiteUrl); // igual abre el site como el comando de abajo pero el de abajo permite mas
        driver.navigate().to(demoSiteUrl);
        actualResult = driver.getTitle();
        Assert.assertTrue(actualResult.contains(expectedResult), "The tittle is not the same for the web");

    }
    @AfterClass
    void closeWeb(){
        driver.quit();
    }
}
