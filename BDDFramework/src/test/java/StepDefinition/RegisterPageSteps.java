package StepDefinition;


import org.openqa.selenium.WebDriver;

import CommonUtility.BaseClass;
import PageObjects.RegisterPage;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;


public class RegisterPageSteps extends BaseClass {

	WebDriver driver;
	RegisterPage registerPage;
	Scenario scenario;


	//	@Before
	//	public void browserSetup(Scenario scenario) throws Exception {
	//		setUp();
	//		this.scenario = scenario;
	//
	//	}

	@Given("navigate to registration page URL")
	public void NavigateToRegistrationPageUrl() throws Exception {
		navigateToUrl();
	}
	@When("user click on register tab")
	public void userClickOnRegisterTab() {
		registerPage=new RegisterPage(BaseClass.driver);
		registerPage.clickOnRegisterLink();

	}

	@And("user enters email")
	public void userEntersEmail() {
		registerPage.enterUsersEmail();
	}

	@And("user mention password")
	public void userMentionPassword() {
		registerPage.enterPassword();


	}

	@Then("user clicks on register button")
	public void userClicksOnRegisterButton() {
		registerPage.clickOnRegister();

	}

	@Then("verify user registered successfully")
	public void verifyUserRegisteredSuccessfully() {
		registerPage.isPopupDisplay(Hooks.getScenario());
	}

	@And("click on ok button")
	public void clickOnOKButton() {
		registerPage.clickOnOkButton();
	}
}
