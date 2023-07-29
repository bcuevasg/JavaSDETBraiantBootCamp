package com.braiant.selenium.responsive;

import org.testng.annotations.DataProvider;

public class MobileEmulations {
    @DataProvider
    public Object[][] mobileEmulations(){
        return new Object[][]{
                {"iPhone 12 Pro"},
                {"Pixel 5"},
                {"Samsung Galaxy S20 Ultra"},
                {"iPad Mini"},
                {"Surface Pro 7"}
        };

    }
    @DataProvider
    public Object[][] mobileEmulationsDimensions(){
        return new Object[][]{
                {"iPhone 12 Pro",290,844},
                {"Pixel 5",393,851},
                {"Samsung Galaxy S20 Ultra",412,915},
                {"iPad Mini",768,1024},
                {"Surface Pro 7",912,1368}
        };

    }

}
