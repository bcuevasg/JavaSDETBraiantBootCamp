package com.braiant.excercisePomDriverFact.saucePages;

import com.braiant.base.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    WebDriver driver = DriverFactory.getInstance().getDriver();

    private By btnAddBackpack = By.id("add-to-cart-sauce-labs-backpack");
    private By btnRemoveBackpack = By.id("remove-sauce-labs-backpack");
    private By btnAddTshirt = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    private By btnRemoveTshirt = By.id("remove-sauce-labs-bolt-t-shirt");
    private By btnCartAccess = By.id("shopping_cart_container");

    public void addBackpack(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(btnAddBackpack)));
        driver.findElement(btnAddBackpack).click();
    }

    public void addTshirt(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(btnAddTshirt)));
        driver.findElement(btnAddTshirt).click();
    }

    public void openCart(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(btnCartAccess)));
        driver.findElement(btnCartAccess).click();
    }


}
