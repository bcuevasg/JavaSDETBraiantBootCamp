package com.braiant.selenium.patronesdediseño.pagepom;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MenuPage extends MainPage{
    private By btnDashboardAccess = By.linkText("Dashboard");
    private By btnTeachersAccess = By.linkText("Teachers");
    private By btnStudentsAccess = By.linkText("Students");
    private By btnParentsAccess = By.linkText("Parents");
    private By btnClassesAccess = By.linkText("");
    private By btnAttendanceAccess = By.linkText("");
    private By btnEventsAccess = By.linkText("");
    private By btnNotifyAccess = By.linkText("Dashboard");
    private By btnTransportAccess = By.linkText("Dashboard");
    private By btnGeneralSettingsAccess = By.linkText("Dashboard");


    public void clickDashboardAccess(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(btnDashboardAccess)));
        driver.findElement(btnDashboardAccess).click();
    }
    public void clickTeacherAccess(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(btnTeachersAccess)));
        driver.findElement(btnTeachersAccess).click();
    }
    public void clickStudentsAccess(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(btnStudentsAccess)));
        driver.findElement(btnStudentsAccess).click();
    }
    public void clickParentsAccess(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(btnParentsAccess)));
        driver.findElement(btnParentsAccess).click();
    }
    public void clickClassesAccess(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(btnClassesAccess)));
        driver.findElement(btnClassesAccess).click();
    }
    public void clickAttendanceAccess(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(btnAttendanceAccess)));
        driver.findElement(btnAttendanceAccess).click();
    }
    public void clickEventsAccess(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(btnEventsAccess)));
        driver.findElement(btnEventsAccess).click();
    }
    public void clickNotifyAccess(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(btnNotifyAccess)));
        driver.findElement(btnNotifyAccess).click();
    }
    public void clickTransportAccess(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(btnTransportAccess)));
        driver.findElement(btnTransportAccess).click();
    }
    public void clickSettingssAccess(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(btnGeneralSettingsAccess)));
        driver.findElement(btnGeneralSettingsAccess).click();
    }



}
