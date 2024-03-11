package StepDefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import CommonUtility.BaseClass;
import PageObjects.HomePage;
import io.cucumber.java.en.*;


public class HomePageSteps extends BaseClass {
	
 WebDriver driver;
 HomePage homePage;

    @Given("navigate to home page")
    public void navigateToHomePage() throws Exception {
        setUp();
        navigateToUrl();

        homePage = new HomePage(BaseClass.driver);

    }

    @When("Click on link for Log In")
    public void clickOnLinkForLogIn() {
        homePage.clickLogin();
    }

    @And("User enters email and password")
    public void userEntersEmailAndPassword() {
        homePage.enterEmailAndPassword();
    }

    @And("user clicks on continue")
    public void userClicksOnContinue() {
        homePage.clickContinue();
    }

    @Then("verify user logged in successfully modal is displayed.")
    public void verifyUserLoggedInSuccessfullyModalIsDisplayed() {
        homePage.isPopupDisplayed();
    }

}
