package com.braiant.frameworks.datadriven.testcases.mobileui;

import com.braiant.baseuimobile.BaseScreen;
import com.braiant.baseuimobile.DeviceOSType;
import com.braiant.baseuimobile.MobileDriverFactory;
import com.braiant.baseuimobile.model.DriverOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.*;

public class BaseMobileTest extends BaseScreen {
    AppiumDriverLocalService service;
    @BeforeSuite
    public void startService(){
        try {
            service = new AppiumServiceBuilder()
                    .withArgument(() -> "--use-plugins", "element-wait@2.0.3,gestures@3.0.0")
                    .withIPAddress("127.0.0.1")
                    .usingPort(4723)
                    .build();

            service.start();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    @BeforeTest
    @Parameters({"deviceOsType","appName","ipAddress","deviceName"})
    public void setup(String deviceOsType, String appName, String ipAddress, String deviceName){
        DriverOptions options = new DriverOptions();
        options.setAppName(appName).setDeviceName(deviceName).setAppActivity("com.swaglabsmobileapp.MainActivity");

        MobileDriverFactory.getInstance().setMobileDriver(DeviceOSType.valueOf(deviceOsType),options);
    }

    @AfterTest
    public void turndown(){
        MobileDriverFactory.getInstance().removeMobileDriver();
    }

    @AfterSuite
    public void stopServer(){
        if(service!=null){
            service.stop();
        }
    }
}
