package com.clipboard.devices;


import com.clipboard.controller.Initializer;
import com.clipboard.register.EnvironmentFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;

/**
 * @author jitendra.pisal
 */
public final class FireFoxManager implements Initializer {
    private RemoteWebDriver driver;

    public FireFoxManager(){}

    @Override
    public WebDriver getDriver() {
        return this.driver;
    }

    @Override
    public void setUpController() {
        WebDriverManager.firefoxdriver().useBetaVersions().setup();
        if ("local".equalsIgnoreCase(EnvironmentFactory.getHub())) {
            this.driver = new FirefoxDriver(CapabilitiesManager.getFirefoxCapabilities());
            this.driver.manage().window().maximize();
            this.driver.manage().timeouts().pageLoadTimeout(300L, TimeUnit.SECONDS);
        }
    }
}
