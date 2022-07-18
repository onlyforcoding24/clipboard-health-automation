package com.framework.automation.steps;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"com.clipboard.steps","com.clipboard.register"},
        features = {"target/parallel/features/[CUCABLE:FEATURE].feature"},
        plugin = {"json:target/cucumber-report/[CUCABLE:RUNNER].json",
                "html:target/cucumber-reports"},
        tags = {"not @wip"},
        monochrome = true,
        strict = true
)
public class CustomCreator {
    @BeforeClass
    public static void init(){
        BasicConfigurator.configure();
        Logger.getLogger("io.restassured.internal").setLevel(Level.OFF);
    }
}

