package com.braiant.excercisePomDriverFact.saucePages;

import org.openqa.selenium.By;

public class CheckoutInfo extends MainPage {

    private By txtName = By.id("first-name");
    private By txtLastName = By.name("lastName");
    private By txtPostalCode = By.name("postalCode");
    private By btnContinue = By.id("continue");

    private void typeName(String firstName) {
        driver.findElement(txtName).clear();
        driver.findElement(txtName).sendKeys(firstName);
    }
    private void typeLastName(String lastName) {
        driver.findElement(txtLastName).clear();
        driver.findElement(txtLastName).sendKeys(lastName);
    }
    private void typePostalCode(String postalCode) {
        driver.findElement(txtPostalCode).clear();
        driver.findElement(txtPostalCode).sendKeys(postalCode);
    }
    public void clickContinue(){
        driver.findElement(btnContinue).click();
    }

    public void fillCheckoutInfo(String firstName,String lastName,String postalCode){
        typeName(firstName);
        typeLastName(lastName);
        typePostalCode(postalCode);
        clickContinue();
    }
}
