package com.cybertek.step_definitions;

import com.cybertek.utils.Driver;
import org.junit.After;

public class Hooks {


    @After
    public void tearDown(){
        Driver.closeDriver();
    }
}
