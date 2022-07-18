package com.clipboard.pages;

import com.clipboard.register.I;
import org.openqa.selenium.By;

public class AssertionPage {
    private By textLocator = By.xpath("//div[@id='feature-bullets']//h1");

    public void verifyTextPresent(String text) {
        I.amPerforming().switchTo().switchToRecentOpenedWindow();
        I.amPerforming().assertionsTo().assertThat(
                I.amPerforming().elements().getText(textLocator)
        ).contains(text);

    }
}
