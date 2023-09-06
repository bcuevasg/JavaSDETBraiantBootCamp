package com.braiant.appium.patronesdediseño;

import com.braiant.appium.BaseTest;
import com.braiant.baseuimobile.MobileDriverFactory;
import org.testng.annotations.Test;

public class MobileDriverFactoryExample extends BaseTest {
    @Test
    void exampleTest() throws InterruptedException {
        MobileDriverFactory.getInstance().getMobileDriver();
        Thread.sleep(1500);
    }
}
