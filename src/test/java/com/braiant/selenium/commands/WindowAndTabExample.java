package com.braiant.selenium.commands;

import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

public class WindowAndTabExample extends BaseTestClass{
    String googleSite = "https://www.google.com";
    String wpSchoolURL = "https://wpschoolpress.com/";

    @Test
    void manageWindowsandTabs(){
        driver.navigate().to(demoSite);
        driver.manage().window().maximize();
        String originalTab = driver.getWindowHandle();
        System.out.println("WindowID: " + originalTab);
        wait(3);

        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to(wpSchoolURL);

        wait(3);

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.manage().window().maximize();
        driver. navigate().to(googleSite);

        wait(3);

        driver.switchTo().window(originalTab);
        driver.close();
        wait(3);

    }

}
