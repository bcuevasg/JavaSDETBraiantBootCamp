package com.braiant.selenium.commands;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class BaseTestClass {
    protected WebDriver driver;
    protected String demoSite = "https://demosite.titaniuminstitute.com.mx/wp-admin/admin.php?page=sch-dashboard";
    protected String userName ="admin";
    protected String password = "G3-ySzY%";

    @BeforeTest
    @Parameters("browser")
    void setup(String browser){
        switch (browser){
            case "Chrome"->{
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
            case "Edge"->{
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            }
            case "Firefox"->{
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
            default -> System.err.println("Browser is not listed");
        }
        driver.manage().window().maximize();

    }

    @AfterTest
    void closeWeb(){
        driver.quit();
    }

    // Solo para casos de pruebas (normalmente usariamos implicit or explicit waits
    void wait(int seg) {
        try {
            Thread.sleep(seg * 1000);
        } catch (InterruptedException ie) {
            System.err.println(ie.getMessage());
        }
    }

}
