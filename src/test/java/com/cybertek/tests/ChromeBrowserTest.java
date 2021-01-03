package com.cybertek.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class ChromeBrowserTest {

    WebDriver driver;
    @Before
    public void setup() throws Exception {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.0");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_2");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
       desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"Chrome");

        URL url = new URL("http://localhost:4723/wd/hub");
        driver = new RemoteWebDriver(url, desiredCapabilities);
    }


    @Test
    public void mobileChromeTest() throws InterruptedException {
    driver.get("http://qa1.vytrack.com");

    driver.findElement(By.id("prependedInput")).sendKeys("storemanager85");
    driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123", Keys.ENTER);
    Thread.sleep(3000);


    }

    public void tearDown(){
        driver.quit();
    }


}
