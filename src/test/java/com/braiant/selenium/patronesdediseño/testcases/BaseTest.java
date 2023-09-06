package com.braiant.selenium.patronesdediseño.testcases;

import com.braiant.baseuiweb.BrowserType;
import com.braiant.baseuiweb.DriverFactory;
import com.braiant.selenium.patronesdediseño.pf.LoginPage;
import com.braiant.selenium.patronesdediseño.pf.MenuPage;
import com.braiant.selenium.patronesdediseño.pf.StudentPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.HashMap;
import java.util.Map;

public class BaseTest {
    String baseUrl = "https://demosite.titaniuminstitute.com.mx/wp-admin/admin.php?page=sch-dashboard";
    Map<String, String> userCredentials = new HashMap<>();


    LoginPage loginPage;
    StudentPage studentPage;
    MenuPage menuPage;

    @BeforeTest
    @Parameters("browser")
    void setup(String browser) {
        DriverFactory.getInstance().setDriver(BrowserType.valueOf(browser));
        DriverFactory.getInstance().getDriver().navigate().to(baseUrl);

        userCredentials.put("username", "admin");
        userCredentials.put("password", "G3-ySzY%");

        loginPage = new LoginPage();
        menuPage = new MenuPage();
        studentPage = new StudentPage();

        loginPage.login(userCredentials.get("username"), userCredentials.get("password"));


    }

    @AfterTest
        void turnDown() {
        studentPage.deleteStudent();
        DriverFactory.getInstance().removeDriver();
    }

}