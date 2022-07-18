package com.clipboard.api;

import com.clipboard.controller.DeviceBucket;
import com.clipboard.objects.InstanceRecording;
import com.clipboard.register.EnvironmentFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author jitendra.pisal
 */
public class Wait {
    private final WebDriver driver = ((DeviceBucket) InstanceRecording.getInstance(DeviceBucket.class)).getDriver();
    private int standardWaitTime = 30;

    public Wait() {}

    public int getStandardWaitTime(){
        return standardWaitTime;
    }

    public WebDriverWait getWait() {
        return new WebDriverWait(this.driver,
                EnvironmentFactory.getWaitTime());
    }

    public void waitWithThread(int seconds){
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public <T> void waitForFrameToBeAvailableAndSwitchToIt(T frame){
        if(frame instanceof By){
            getWait().until(ExpectedConditions.frameToBeAvailableAndSwitchToIt((By)frame));
        } else if (frame instanceof WebElement){
            getWait().until(ExpectedConditions.frameToBeAvailableAndSwitchToIt((WebElement)frame));
        } else if (frame instanceof String){
            getWait().until(ExpectedConditions.frameToBeAvailableAndSwitchToIt((String)frame));
        } else if (frame instanceof Integer){
            getWait().until(ExpectedConditions.frameToBeAvailableAndSwitchToIt((int)frame));
        } else {
            throw new RuntimeException("Please pass valid frame type");
        }

    }

    public <T> void magicWait(T locator, String purpose){
        int counter = 0;
        if(locator instanceof WebElement) {
            if (purpose.equalsIgnoreCase("click")) {
                while (counter < EnvironmentFactory.getWaitTime()) {
                    try {
                         ((WebElement) locator).click();
                        break;
                    } catch (ElementClickInterceptedException ex1) {
                        this.waitWithThread(1);
                        counter++;
                    }
                }
            }
        }
        if(locator instanceof By){
            if(purpose.equalsIgnoreCase("iframe-detach")){
                while (counter < EnvironmentFactory.getWaitTime()) {
                    try {
                        this.driver.findElement((By)locator);
                        break;
                    } catch (WebDriverException we){
                        if(counter == EnvironmentFactory.getWaitTime()){
                            throw we;
                        } else {
                            waitWithThread(1);
                            waitForFrameToBeAvailableAndSwitchToIt(locator);
                        }
                    }
                }
            }
        }
    }
}
