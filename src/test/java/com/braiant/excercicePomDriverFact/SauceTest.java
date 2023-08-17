package com.braiant.excercicePomDriverFact;

import com.braiant.base.BrowserType;
import com.braiant.base.DriverFactory;
import com.braiant.excercicePomDriverFact.saucePages.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class SauceTest{
    String baseUrl = "https://www.saucedemo.com/";
    LoginPage loginPage;
    CartPage cartPage;
    MainPage mainPage;
    CheckoutInfo checkoutInfo;
    CheckoutOverview checkoutOverview;
    String userName = "standard_user";
    String password = "secret_sauce";
    String firstName ="Braiant";
    String lastName = "Cuevas";
    String postalCode = "91000";

    @BeforeTest
    @Parameters("browser")
    void setup(String browser) {
        DriverFactory.getInstance().setDriver(BrowserType.valueOf(browser));
        DriverFactory.getInstance().getDriver().navigate().to(baseUrl);

        loginPage = new LoginPage();
        mainPage = new MainPage();
        cartPage = new CartPage();
        checkoutInfo = new CheckoutInfo();
        checkoutOverview = new CheckoutOverview();

        loginPage.login(userName,password);
    }
    @AfterTest
    void turnDown() {
        DriverFactory.getInstance().removeDriver();
    }
    @Test
    void selectMultipleItems() {
        mainPage.addBackpack();;
        mainPage.addTshirt();
        mainPage.openCart();
        cartPage.verifyRecordAdded();
        cartPage.clickCheckout();
        checkoutInfo.fillCheckoutInfo(firstName, lastName,postalCode);
        checkoutOverview.validateTotalPrice();
    }
}
