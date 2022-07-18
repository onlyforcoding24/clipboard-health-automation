package com.clipboard.type;

import com.clipboard.controller.DeviceBucket;
import com.clipboard.objects.InstanceRecording;
import com.clipboard.register.I;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author jitendra.pisal
 */
public class Click {
    Logger logger = Logger.getLogger(Click.class);
    private final WebDriver driver = ((DeviceBucket) InstanceRecording.getInstance(DeviceBucket.class)).getDriver();

    public Click() {
    }

    public void on(WebElement locator) {
        WebDriverWait wait = I.amPerforming().waitFor().getWait();
        I.amPerforming().getLogger().logInfo(logger, "Waiting for element to be clickable : " + locator.toString());
        try {
            wait.until(ExpectedConditions.elementToBeClickable(locator));
        } catch (NoSuchElementException t) {
            I.amPerforming().getLogger().logError(logger, t.getMessage());
            throw new RuntimeException(t.getMessage());
        }
        I.amPerforming().getLogger().logInfo(logger, "Element clickable check successful : " + locator.toString());
        try {
            locator.click();
        } catch (ElementClickInterceptedException ee) {
            I.amPerforming().waitFor().magicWait(locator, "click");
        }
        I.amPerforming().getLogger().logInfo(logger, "Successfully clicked on element : " + locator.toString());
    }

    public void on(By locator) {
        WebDriverWait wait = I.amPerforming().waitFor().getWait();
        I.amPerforming().getLogger().logInfo(logger, "Waiting for element to be present : " + locator.toString());
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (TimeoutException t) {
            I.amPerforming().getLogger().logInfo(logger, "Failed to find the element on page : " + locator.toString());
            throw new RuntimeException(t.getMessage());
        }
        I.amPerforming().getLogger().logInfo(logger, "Element presence check successful : " + locator.toString());
        this.on(this.driver.findElement(locator));
    }
}
