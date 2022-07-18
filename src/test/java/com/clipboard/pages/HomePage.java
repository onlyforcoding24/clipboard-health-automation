package com.clipboard.pages;

import com.clipboard.register.I;
import org.openqa.selenium.By;

public class HomePage {
    private By hambergerMenu = By.id("nav-hamburger-menu");


    public void selectHambergerMenu(){
        I.amPerforming().click().on(hambergerMenu);
    }

    public void selectOptionInLeftPanel(String subOption, String parentOption) {
        By leftPanelOptions = By.xpath("//*[contains(@class,'hmenu-title') and text()='"+parentOption+"']/../following-sibling::li//a//div[text()='"+subOption+"'] |" +
                " //*[contains(@class,'hmenu-title') and text()='"+parentOption+"']/../following-sibling::li//a[text()='"+subOption+"']");
        I.amPerforming().click().on(leftPanelOptions);
    }
}
