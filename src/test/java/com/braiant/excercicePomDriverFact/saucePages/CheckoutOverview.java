package com.braiant.excercicePomDriverFact.saucePages;

import log4j2.Main;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class CheckoutOverview extends MainPage {
    private By fldTotal = By.xpath("(//div[contains(text(),'Total')])[2]");
    public void validateTotalPrice(){
        WebElement dvTotal = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver -> driver.findElement(fldTotal));
        System.out.println("El Total deberia ser 49.66 y el valor obtenido es: " + dvTotal.getText());
        Assert.assertTrue(dvTotal.getText().contains("49.66"));
    }
}
