package com.braiant.appium.patronesdediseño.pf;

import com.braiant.baseuimobile.BaseScreen;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.remote.RemoteWebElement;

public class HomeScreen extends BaseScreen {
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='PRODUCTS']")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == 'PRODUCTOS'`][2]")
    private RemoteWebElement lblProducts;

    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"])[1]/android.widget.TextView")
    private RemoteWebElement addBackPack;

    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"])[2]/android.widget.TextView")
    private RemoteWebElement addBikeLight;

    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"])[1]")
    private RemoteWebElement addBlackTshirt;
    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"])[3]/android.widget.TextView")
    private RemoteWebElement addOmaise;
    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"])[4]/android.widget.TextView")
    private RemoteWebElement addRedTshirt;


    protected String getProductsTitle(){
        return lblProducts.getText();
    }

    public HomeScreen verifyProductsText(){
        assert getProductsTitle().contains("PRODUCT");
        //Assert.assertEquals(getProductsTitle(),"PRODUCTOS");
        return this;
    }

    public HomeScreen addBackPack() {
        addBackPack.click();
        return this;
    }
    public HomeScreen addBikeLight() {
        addBikeLight.click();
        return this;
    }
    public HomeScreen addBlackTShirt() {
        addBlackTshirt.click();
        return this;
    }
    public HomeScreen addOmaise() {
        addOmaise.click();
        return this;
    }
    public HomeScreen addRedTShirt() {
        addRedTshirt.click();
        return this;
    }
}
