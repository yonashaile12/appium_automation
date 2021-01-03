package com.cybertek.tests;

import com.cybertek.utils.MobileUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class EtsyTests {

    AppiumDriver<AndroidElement> driver;
    @Before
    public void setup() throws Exception {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.0");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_2");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.APP,"https://cybertek-appium.s3.amazonaws.com/etsy.apk");
        URL url = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver<>(url, desiredCapabilities);
    }

    @Test
    public void loginTestEtsy()  {
        MobileUtils.waitFor(4000);
        //click on get started button
        driver.findElementById("com.etsy.android:id/btn_link").click();
        //enter email
        MobileUtils.waitFor(2000);
        driver.findElementById("com.etsy.android:id/edit_username").sendKeys("areatha@uspeakw.com");
        //enter password
        driver.findElementById("com.etsy.android:id/edit_password").sendKeys("Cybertek2020");
        //click on sign in button
        driver.findElementById("com.etsy.android:id/button_signin").click();
        MobileUtils.waitFor(4000);
    }


    @After
    public void tearDown(){
        driver.closeApp();
    }
}
