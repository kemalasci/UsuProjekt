package stepdefs;

import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.LocatorsInterface;
import utils.BaseClass;

import java.awt.*;
import java.util.List;
import java.util.Set;

public class SocialMadiaPageStepdefs extends BaseClass implements LocatorsInterface {
    @When("click social media web pages  links and Page Control")
    public void clickSocialMediaWebPagesLinksAndPageControl() throws InterruptedException, AWTException {
        RobotClass(19);
        String homePageIds = driver.getWindowHandle();

        List<WebElement> links = driver.findElements(socialMediaList);

        for (WebElement link : links) {
scrollToElement(link);
            link.click();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        Set<String> windowIDs = driver.getWindowHandles();

        for (String ID : windowIDs) {
            if (ID.equals(homePageIds)) continue;


            driver.switchTo().window(ID);


            Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains("com"));


            driver.close();

        }
        driver.quit();
    }
}
