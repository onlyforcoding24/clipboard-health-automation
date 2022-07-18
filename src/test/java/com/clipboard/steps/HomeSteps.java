package com.clipboard.steps;

import com.clipboard.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class HomeSteps {

    HomePage homePage;

    public HomeSteps(HomePage homePage) {
        this.homePage = homePage;
    }

    @When("select hamburger menu")
    public void selectHambergerMenu(){
        homePage.selectHambergerMenu();
    }

    @And("select {string} from {string} present in left section")
    public void selectFromPresentInLeftSection(String subOption, String parentOption) {
        homePage.selectOptionInLeftPanel(subOption,parentOption);
    }
}
