package com.clipboard.controller;

import com.clipboard.devices.ChromeManager;
import com.clipboard.devices.FireFoxManager;
import com.clipboard.register.EnvironmentFactory;
import org.openqa.selenium.WebDriver;

public class DeviceBucket implements Initializer{
    private final Initializer delegate;

    public DeviceBucket() {
        String var1 = EnvironmentFactory.getDevice().toLowerCase();
        switch(var1){
            case "chrome":
                this.delegate = new ChromeManager();
                break;
            case "firefox":
                this.delegate = new FireFoxManager();
                break;
            default:
                this.delegate = new ChromeManager();
        }
    }

    @Override
    public WebDriver getDriver() {
        return this.delegate.getDriver();
    }

    @Override
    public void setUpController() {
        this.delegate.setUpController();
    }
}
