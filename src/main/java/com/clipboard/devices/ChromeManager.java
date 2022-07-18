package com.clipboard.devices;

import com.clipboard.controller.Initializer;
import com.clipboard.register.EnvironmentFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author jitendra.pisal
 */
public final class ChromeManager implements Initializer {
    private RemoteWebDriver driver;
    private ChromeDriverService service;

    public ChromeManager() {
    }

    @Override
    public WebDriver getDriver() {
        return this.driver;
    }

    @Override
    public void setUpController() {
        WebDriverManager.chromedriver().useBetaVersions().setup();
        this.service = (ChromeDriverService)((ChromeDriverService.Builder)((ChromeDriverService.Builder)(new ChromeDriverService.Builder()).usingDriverExecutable(new File(WebDriverManager.chromedriver().getBinaryPath()))).usingAnyFreePort()).build();
        try {
            this.service.start();
        } catch (IOException var3) {
        }
        if ("local".equalsIgnoreCase(EnvironmentFactory.getHub())) {
            this.driver = new RemoteWebDriver(this.service.getUrl(), CapabilitiesManager.getChromeCapabilities());
            this.driver.manage().window().maximize();
            this.driver.manage().timeouts().pageLoadTimeout(300L, TimeUnit.SECONDS);
        }
    }
}
