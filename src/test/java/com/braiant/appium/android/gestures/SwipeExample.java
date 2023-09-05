package com.braiant.appium.android.gestures;

import com.braiant.appium.android.AndroidBaseTest;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class SwipeExample extends AndroidBaseTest {
    @Test
    void swipe(){
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        driver.findElement(AppiumBy.accessibilityId("//android.widget.TextView[@content-desc=\"1. Photos\"]")).click();

        RemoteWebElement firstImage = (RemoteWebElement) driver.findElement(AppiumBy.accessibilityId("(//android.widget.ImageView)[1]"));

        String firstTimeValue = firstImage.getAttribute("focusable");
        Assert.assertEquals(firstTimeValue, "true");
        driver.executeScript("gesture: swipe", Map.of("elementId", firstImage.getId(),
                "percentage", 50,
                "direction", "down"));
        String secondTimeValue = firstImage.getAttribute("focusable");
        Assert.assertEquals(secondTimeValue, "false");

    }
}
