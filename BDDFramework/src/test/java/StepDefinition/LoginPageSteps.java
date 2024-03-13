package StepDefinition;


import org.openqa.selenium.WebDriver;
import CommonUtility.BaseClass;
import PageObjects.LoginPage;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;


public class LoginPageSteps extends BaseClass {

	WebDriver driver;
	LoginPage loginPage;

	@Before
	public void browserSetup() throws Exception {
		setUp();
	}
	@Given("navigate to login page URL {string}")
	public void navigateToLoginPageUrl(String extendedUrl) {
		navigateToUrl(extendedUrl);
		loginPage = new LoginPage(BaseClass.driver);

	}
	@When("Click on link for Log In")
	public void clickOnLinkForLogIn() {
		loginPage.clickLogin();
	}

	@And("User enters email and password")
	public void userEntersEmailAndPassword() {
		loginPage.enterEmailAndPassword();
	}

	@And("user clicks on continue")
	public void userClicksOnContinue() {
		loginPage.clickContinue();
	}
	Scenario scenario;

	@Before
	public void beforeScenarios(Scenario scenario) {
		this.scenario = scenario;
	}
	@Then("verify user logged in successfully")
	public void verifyUserLoggedInSuccessfully() {
		loginPage.isPopupDisplayed(scenario);
	}
	@And("user click on ok button")
	public void userClickOnOkButton() {
		loginPage.clickOnOkButton();
	}

}