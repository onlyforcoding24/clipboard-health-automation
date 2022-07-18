package com.clipboard.steps;

import com.clipboard.pages.AssertionPage;
import com.clipboard.pages.ElectronicsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ElectronicsSteps {

    ElectronicsPage electronicsPage;
    AssertionPage assertionPage;

    public ElectronicsSteps(ElectronicsPage electronicsPage,
                            AssertionPage assertionPage) {
        this.electronicsPage = electronicsPage;
        this.assertionPage = assertionPage;
    }

    @When("select tv brand {string} on electronics home page")
    public void selectTvBrandOnElectronicsHomePage(String brandName) {
        electronicsPage.selectBrandName(brandName);
    }

    @And("click on sort by option")
    public void clickOnSortByOption() {
        electronicsPage.clickSortByOption();
    }

    @And("select option {string} from sort by dropdown")
    public void selectOptionFromSortByDropdown(String sortOption) {
        electronicsPage.selectSortByOption(sortOption);
    }

    @And("click on second highest price option showing on the page")
    public void clickOnSecondHighestPriceOptionShowingOnThePage() {
        electronicsPage.clickOnSecondHighestPriceOption();
    }

    @Then("verify that the {string} text is present for the product")
    public void verifyThatTheTextIsPresentForTheProduct(String text) {
        assertionPage.verifyTextPresent(text);
        electronicsPage.printAboutThisItemInfo();
    }
}
