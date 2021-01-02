package com_automation;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class testRunner {

    private AppiumDriver<MobileElement> driver;
    @Test
    public void test(){
        try {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
            desiredCapabilities.setCapability(MobileCapabilityType.VERSION,"7.0");
            desiredCapabilities.setCapability(MobileCapabilityType.APP,System.getProperty("user.dir")+"\\etsy.apk");
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel_2");
            desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,20000);
            driver = new AppiumDriver<>(new URL("http://0.0.0.0:4723/wd/hub"),desiredCapabilities);
            Thread.sleep(5000);
            driver.closeApp();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
