package com.braiant.excercicePomDriverFact.saucePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class CartPage extends MainPage{
    private By itmCartItem = By.className("shopping_cart_badge");
    private By btnCheckout = By.name("checkout");
    public void verifyRecordAdded(){
        WebElement spnShoppingCart = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver -> driver.findElement(itmCartItem));
        System.out.println("El valor esperado es 2 y el valor obtenido es: " + Integer.valueOf(spnShoppingCart.getText()));
        Assert.assertEquals(Integer.valueOf(spnShoppingCart.getText()), 2);
    }
    public void clickCheckout(){
        driver.findElement(btnCheckout).click();
    }

}
