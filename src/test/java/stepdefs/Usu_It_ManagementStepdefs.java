package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import pages.LocatorsInterface;
import utils.BaseClass;

import java.awt.*;

import static pages.InformationClass.*;

public class Usu_It_ManagementStepdefs extends BaseClass implements LocatorsInterface {
    @Given("User should be able to navigate to homePage")
    public void userShouldBeAbleToNavigateToHomePage() {

        open(url);
        if (cookiesButton != null)
            clickTo(cookiesButton);

    }

    @When("Usu It Service Management should be clickable")
    public void usuItServiceManagementShouldBeClickable() {
        hower(scroolTop__nav);
        clickTo(lösungenMenuItem);
        clickTo(usuItService);
    }

    @Then("User should be able to go to Usu It Service Management web page")
    public void userShouldBeAbleToGoToUsuItServiceManagementWebPage() throws InterruptedException, AWTException {
        verifyElementContainsText(itServiceTitle, usuItServiceTitle);
        RobotClass(18);
    }

    @And("The user should be able to fill the web presentation form")
    public void theUserShouldBeAbleToFillTheWebPresentationForm() {

        clickTo(vornameInput);
        sendKeysTo(vornameInput, "Ich Bin ");
        clickTo(nachnameInput);
        sendKeysTo(nachnameInput, "wirklich ");
        clickTo(unternehmenInput);
        sendKeysTo(unternehmenInput, "gut in ");
        clickTo(emailInput);
        sendKeysTo(emailInput, "SDET@USU.de ");


        select(selectPosition, "Manager");
        select(selectDepartman, "IT - Software Asset Management");

        select(selectCountry, "Germany");
        clickTo(bemerkungInput);
        sendKeysTo(bemerkungInput, "SDET@USU.de ");
        clickTo(telefonInput);
        sendKeysTo(telefonInput, "555555");


    }

    @Then("the user should be able to click the Submit button")
    public void theUserShouldBeAbleToClickTheSubmitButton() {
        clickTo(submitButton);
    }

    @And("The user should be able to see the Error text")
    public void theUserShouldBeAbleToSeeTheErrorText() {
        verifyElementContainsText(errorMessage, errormsjString);
    }
}
