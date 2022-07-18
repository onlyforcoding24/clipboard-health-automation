package com.clipboard.type;

import com.clipboard.controller.DeviceBucket;
import com.clipboard.objects.InstanceRecording;
import com.clipboard.register.I;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Set;

/**
 * @author jitendra.pisal
 */
public class Switch {
    private final WebDriver driver = ((DeviceBucket) InstanceRecording.getInstance(DeviceBucket.class)).getDriver();

    public Switch(){}

    public void switchToFrame(WebElement locator){
        I.amPerforming().waitFor().waitForFrameToBeAvailableAndSwitchToIt(locator);
    }

    public void switchToRecentOpenedWindow(){
        Set<String> availableWindows = this.driver.getWindowHandles();
        availableWindows.stream().iterator().forEachRemaining(s -> driver.switchTo().window(s));
    }

    public void switchToFrame(int id){
        this.driver.switchTo().frame(id);
    }

    public void switchToFrame(String str){
        I.amPerforming().waitFor().waitForFrameToBeAvailableAndSwitchToIt(str);
    }

    public void switchToParentFrame(){
        this.driver.switchTo().parentFrame();
    }

    public void switchToDefaultContent(){
        this.driver.switchTo().defaultContent();
    }
}
