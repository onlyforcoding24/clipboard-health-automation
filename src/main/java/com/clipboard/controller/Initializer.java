package com.clipboard.controller;

import org.openqa.selenium.WebDriver;

public interface Initializer {
    WebDriver getDriver();
    void setUpController();
}
