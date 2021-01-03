package com.cybertek.pages;

import com.cybertek.utils.Driver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    // make sure logger imported from here: import org.apache.log4j.Logger;
    private static final Logger logger = Logger.getLogger(BasePage.class);

    public BasePage(){
        //  AppiumFieldDecorator  required for Appium
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()), this);
    }
}
