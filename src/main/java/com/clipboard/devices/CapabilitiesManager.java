package com.clipboard.devices;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

/**
 * @author jitendra.pisal
 */
public class CapabilitiesManager {
    public CapabilitiesManager() {
    }

    public static Capabilities getChromeCapabilities() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("disable-infobars", "--disable-extensions", "--disable-gpu", "--no-sandbox");
        return chromeOptions;
    }

    public static FirefoxOptions getFirefoxCapabilities() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        FirefoxProfile profile = new FirefoxProfile();
        profile.setAssumeUntrustedCertificateIssuer(true);
        firefoxOptions.setProfile(profile);
        firefoxOptions.setAcceptInsecureCerts(true);
        firefoxOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
        return firefoxOptions;
    }
}
