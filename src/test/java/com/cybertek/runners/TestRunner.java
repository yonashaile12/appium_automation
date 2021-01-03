package com.cybertek.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "com/cybertek/step_definitions",
        features = "src/test/resources/features",
        publish = true,
        dryRun = false
)
public class TestRunner {
}
