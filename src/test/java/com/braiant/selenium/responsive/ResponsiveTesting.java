package com.braiant.selenium.responsive;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.HashMap;
import java.util.Map;

public class ResponsiveTesting {
    protected WebDriver driver;
    protected String demoSiteUrl = "https://demosite.titaniuminstitute.com.mx/wp-admin/admin.php?page=sch-dashboard";
    Map<String, String> deviceMobEmu;
    String userName = "admin";
    String password = "G3-ySzY%";
    String actualResult = "";
    String expectedResult = "Titanium School";

    @BeforeTest
    void setup() {
        WebDriverManager.chromedriver().setup();
        deviceMobEmu = new HashMap<>();

    }

    @AfterMethod
    void turnDown() {
        driver.quit();
    }

    @AfterTest
    void cleanMap() {
        deviceMobEmu.clear();
    }
// Este metodo usa los tamanos definidos por goodle ne tamaños sin problemas
    @Test(enabled = false, dataProviderClass = MobileEmulations.class, dataProvider = "mobileEmulationsDimensions")
    void responsiveTest(String deviceEmulator) {
        deviceMobEmu.put("deviceName", deviceEmulator);
        //ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.setExperimentalOption("mobileEmulations",deviceMobEmu);

        driver = new ChromeDriver();
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
    }

    // En el test de abajo especificamos los valores de tamaño de la ventana
    //  esto definido en el Mobileumlation class
    @Test(dataProviderClass = MobileEmulations.class, dataProvider = "mobileEmulationsDimensions")
    void responsiveTestDimensions(String deviceEmulator, int width, int height) {
        driver = new ChromeDriver();

        Dimension dimension = new Dimension(width, height);
        driver.manage().window().setSize(dimension);
        driver.navigate().to(demoSiteUrl);

        //driver.manage().window().maximize();//agranda la instancia de chrome que se abrira

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
    }
}