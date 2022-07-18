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
public class TextInput {
    private final WebDriver driver = ((DeviceBucket) InstanceRecording.getInstance(DeviceBucket.class)).getDriver();

    private void in(WebElement locator, String input){
        I.amPerforming().waitFor().getWait().until(ExpectedConditions.elementToBeClickable(locator));
        locator.sendKeys(input);
    }

    public void in(By locator,String input){
        I.amPerforming().waitFor().getWait().until(ExpectedConditions.presenceOfElementLocated(locator));
        in(this.driver.findElement(locator),input);
    }

    public void toClear(By locator){
        I.amPerforming().waitFor().getWait().until(ExpectedConditions.presenceOfElementLocated(locator));
        toClear(this.driver.findElement(locator));
    }

    private void toClear(WebElement locator){
        I.amPerforming().waitFor().getWait().until(ExpectedConditions.elementToBeClickable(locator));
        locator.clear();
    }

}
