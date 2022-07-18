package com.clipboard.pages;

import com.clipboard.register.I;
import org.openqa.selenium.By;

public class ElectronicsPage {
    private By sortBy = By.xpath("//*[contains(text(),'Sort by') and @class='a-dropdown-label']");
    private String sortOptionLocator = "//a[text()='args0']";
    private By secondHighestPriceOption = By.xpath("//div[@id='search']//div[contains(@class,'s-result-list')]//div[@data-index='2']");
    private By textLocator = By.xpath("//div[@id='feature-bullets']//ul");


    public void selectBrandName(String name) {
       By brandName = By.xpath("//div[contains(@class,'checkbox')]/following-sibling::span[text()='"+name+"']");
        I.amPerforming().click().on(brandName);
    }

    public void clickSortByOption(){
        I.amPerforming().waitFor().waitWithThread(5);
        I.amPerforming().click().on(sortBy);
    }

    public void selectSortByOption(String sortOption) {
        I.amPerforming().click().on(By.xpath(sortOptionLocator.replace("args0",sortOption)));
    }

    public void clickOnSecondHighestPriceOption(){
        I.amPerforming().click().on(secondHighestPriceOption);
    }

    public void printAboutThisItemInfo(){
        System.out.println(I.amPerforming().elements().getText(textLocator));
    }


}
