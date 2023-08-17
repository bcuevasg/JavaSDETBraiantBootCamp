package com.braiant.excercicePomDriverFact.saucePages;

import org.openqa.selenium.By;

public class LoginPage extends MainPage{
    private By txtUserName = By.id("user-name");
    private By txtPassword = By.id("password");
    private By btnLogin = By.id("login-button");

    private void typeUsername(String username) {
        driver.findElement(txtUserName).clear();
        driver.findElement(txtUserName).sendKeys(username);
    }

    private void typePassword(String password) {
        driver.findElement(txtPassword).clear();
        driver.findElement(txtPassword).sendKeys(password);
    }

    private void clickLogin() {
        driver.findElement(btnLogin).click();
    }

    public void login(String username,String password){
        typeUsername(username);
        typePassword(password);
        clickLogin();

    }




}
