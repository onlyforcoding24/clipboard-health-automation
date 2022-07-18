package com.clipboard.type;

import com.clipboard.controller.DeviceBucket;
import com.clipboard.objects.InstanceRecording;
import com.clipboard.register.I;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * @author jitendra.pisal
 */
public class Elements {
    private final WebDriver driver = ((DeviceBucket) InstanceRecording.getInstance(DeviceBucket.class)).getDriver();

    public Elements() {
    }

    public WebElement getElement(By by) {
        I.amPerforming().waitFor().getWait().until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
        return this.driver.findElement(by);
    }

    public String getText(By locator) {
        return this.getElement(locator).getText();
    }
}
