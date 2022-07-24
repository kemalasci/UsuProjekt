package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LocatorsInterface;
import utils.BaseClass;
import static pages.InformationClass.*;



public class LinkImageControlStepdefs extends BaseClass implements LocatorsInterface {
    @Given("User should be able to navigate to home Page")
    public void userShouldBeAbleToNavigateToHomePage() {
        open(url);
        if (cookiesButton != null)
            clickTo(cookiesButton);

    }@When("All links in the home page should be properly defined")
    public void allLinksInTheHomePageShouldBeProperlyDefined() {
        verifyLinks(linkKontrol);
    }

    @Then("All image in the home page should be properly defined")
    public void allImageInTheHomePageShouldBeProperlyDefined() {
        selenium_broken_images(url);
    }


}
