package com.braiant.selenium.commands;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NavigationAndGetsExample {
    WebDriver driver;
    String demoSite = "https://demosite.titaniuminstitute.com.mx/wp-login.php?loggedout=true&wp_lang=en_US";
    String googleSite = "https://www.google.com";

    @BeforeTest
    void setup(){
        WebDriverManager.chromedriver().setup();
        //La accion de abajo abre el navegador
        driver = new ChromeDriver();
    }

    @Test
    void validateNavigationAndGetCommands(){
        driver.navigate().to(googleSite);
        System.out.println(String.format("The web page title is %s", driver.getTitle()));
        System.out.println(String.format("The URL is %s",driver.getCurrentUrl()));

        wait(2);

        driver.get(demoSite);

        System.out.println("*********************************************");
        System.out.println(String.format("The web page title is %s", driver.getTitle()));
        System.out.println(String.format("The URL is %s",driver.getCurrentUrl()));
        System.out.println(String.format("The Source Code is %s",driver.getPageSource()));

        wait(2);

        driver.navigate().back();

        wait(2);

        driver.navigate().forward();

        wait(2);

    }


    void wait(int seg) {
        try {
            Thread.sleep(seg * 1000);
        } catch (InterruptedException ie) {
            System.err.println(ie.getMessage());
        }
    }


    @AfterClass
    void closeWeb(){
        driver.quit();
    }
}
