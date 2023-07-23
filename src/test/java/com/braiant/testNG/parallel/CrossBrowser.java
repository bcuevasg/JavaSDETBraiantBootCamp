package com.braiant.testNG.parallel;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowser {
    @Test
    @Parameters("browser")
    void executeCrossBrowser(String browser){
        String navigatorStarted;
        navigatorStarted = switch (browser.toLowerCase()){
            case "chrome" -> "Chrome Browser Started!" + Thread.currentThread().getId();
            case "firefox" -> "Firefox Browser Started!"  + Thread.currentThread().getId();
            case "edge" -> "Edge Browser Started!" + Thread.currentThread().getId();
            case "safari" -> "Safari Browser Started!"  + Thread.currentThread().getId();//latest version of java should use ThreadId() instead of getId()
            default -> "Value not identified" + Thread.currentThread().getId();
        };
        System.out.println(navigatorStarted);
    }

}
