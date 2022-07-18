package com.clipboard.controller;

import com.clipboard.objects.InstanceRecording;
import com.clipboard.register.EnvironmentFactory;
import com.clipboard.register.I;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/**
 * @author jitendra.pisal
 */
public final class TestSetUpController {
    private DeviceBucket device;

    public TestSetUpController(DeviceBucket device) {
        this.device = device;
    }

    public void initializer(Scenario scenario) {
        ScenarioController.setScenario(scenario);
        this.runBrowser();
        ScenarioController.printInitialLogs();
    }

    private void runBrowser() {
        this.device.setUpController();
        this.device.getDriver().get(EnvironmentFactory.getEnvironmentUrl().toUpperCase());
    }

    public void theEnd() {
        I.amPerforming().assertionsTo().assertAll();
        ScenarioController.printFinalLogs();
        this.captureScreenshot(ScenarioController.getScenario());
        this.browserWrapUp();
        InstanceRecording.flushInstance();
    }

    private void browserWrapUp() {
        this.device.getDriver().manage().deleteAllCookies();
        this.device.getDriver().close();
        this.device.getDriver().quit();
    }

    private void captureScreenshot(Scenario scenario) {
        if (scenario.isFailed()){
            scenario.embed((byte[])((TakesScreenshot)this.device.getDriver()).getScreenshotAs(OutputType.BYTES),"image/png");
        }
    }
}
