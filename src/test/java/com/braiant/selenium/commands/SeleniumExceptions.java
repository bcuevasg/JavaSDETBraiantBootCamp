package com.braiant.selenium.commands;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumExceptions {

    //https://www.selenium.dev/selenium/docs/api/py/common/selenium.common.exceptions.html lista de exceptions
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

        try {
            driver.navigate().to(demoSiteUrl);
        }catch (InvalidArgumentException iae){
            driver.navigate().to("https://" + demoSiteUrl);

        }

        driver.manage().window().maximize();//agranda la instancia de chrome que se abrira

        try {
            driver.findElement(By.id("user_logi")).sendKeys(userName);
            Assert.assertTrue(true);
        }catch(NoSuchElementException nse){
            Assert.assertTrue(false);
        }




        //driver.findElement(By.id("user_login")).clear();



    }
    @AfterClass
    void closeWeb(){
        driver.quit();
    }
}
