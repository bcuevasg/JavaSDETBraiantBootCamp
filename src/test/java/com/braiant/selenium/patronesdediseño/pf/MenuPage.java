package com.braiant.selenium.patronesdediseño.pf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MenuPage extends MainPage {
    @FindBy(linkText = "Dashboard")
    private WebElement btnDashboardAccess;
    @FindBy(linkText = "Teachers")
    private WebElement btnTeachersAccess;
    @FindBy(linkText = "Students")
    private WebElement btnStudentsAccess;
    @FindBy(linkText = "Parents")
    private WebElement btnParentsAccess;


    public void clickDashboardAccess(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(btnDashboardAccess));
        btnDashboardAccess.click();
    }
    public void clickTeacherAccess(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(btnTeachersAccess));
        btnTeachersAccess.click();
    }
    public void clickStudentsAccess(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(btnStudentsAccess));
        btnStudentsAccess.click();
    }
    public void clickParentsAccess(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(btnParentsAccess));
        btnParentsAccess.click();
    }




}
