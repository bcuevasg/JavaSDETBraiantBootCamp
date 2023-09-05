package com.braiant.appium.android.gestures;

import com.braiant.appium.android.AndroidBaseTest;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ScrollExample extends AndroidBaseTest {
    @BeforeMethod
    void goToView(){
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
    }

    // Funciona cuando el objeto esta reconocido y lo podamos manipular
    @Test(enabled = false)
    void ScrollUIAutomatorTest() throws InterruptedException {
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))"));
        Thread.sleep(1500);
    }

    // Funciona aunque no sepamos el objeto preferente usarlo como ultimo recurso
    @Test
    void scrollUsingGesturesTest(){

        boolean canScrollMore;
        do{
            canScrollMore = (Boolean) ((JavascriptExecutor)driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
               "left", 100, "top",100,"width",200,"height",200,
               "direction", "down",
               "percent",3.0
            ));
        }while (canScrollMore);


    }
}
