package com.cybertek.tests;

import com.cybertek.utils.MobileUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class ChewyTests {

    AppiumDriver<AndroidElement> driver;
    @Before
    public void setup() throws Exception {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.0");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_2");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.APP,"https://cybertek-appium.s3.amazonaws.com/chewy.apk");
        // app will automatically installed on your devicebefore test execution
        URL url = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver<>(url, desiredCapabilities);
    }
    @Test
    public void test1() throws InterruptedException {
        Thread.sleep(3000);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        By doneBy = MobileBy.id("com.chewy.android:id/doneButton");
        wait.until(ExpectedConditions.presenceOfElementLocated(doneBy));
        AndroidElement doneBtn = driver.findElement(doneBy);
        wait.until(ExpectedConditions.elementToBeClickable(doneBtn));
        doneBtn.click();
        Thread.sleep(5000);
        //scroll
//        MobileUtils.swipeScreen(MobileUtils.Direction.UP, driver);//if possible, will scroll all the way down
        MobileUtils.swipeScreenSmall(MobileUtils.Direction.UP, driver);//scrolls just a little bit
        Thread.sleep(3000);
        MobileUtils.swipeScreenSmall(MobileUtils.Direction.UP, driver);//scrolls just a little bit
        Thread.sleep(3000);
        //I create By object
        By dogIconBy = MobileBy.xpath("//android.widget.FrameLayout[@content-desc=\"Dog Category\"]/android.widget.ImageView");
        //wait for presence of the element, doesn't work with WebElement, only with By
        wait.until(ExpectedConditions.presenceOfElementLocated(dogIconBy));
        //once element present, find it
        AndroidElement dogsIcon = driver.findElement(dogIconBy);
        //wait for until webdriver can click on element
        wait.until(ExpectedConditions.elementToBeClickable(dogsIcon));
        //click on element
        dogsIcon.click();
        Thread.sleep(6000);
    }


    @After
    public void tearDown(){
        driver.closeApp();
    }
}
