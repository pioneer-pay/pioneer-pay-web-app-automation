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
	@Before
	public void browserSetup() throws Exception {
		setUp();
	}

	@Given("navigate to registration page URL {string}")
	public void NavigateToRegistrationPageUrl(String extendedUrl) throws Exception {
		navigateToUrl(extendedUrl);
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
	Scenario scenario;

	@Before
	public void beforeScenario(Scenario scenario) {
		this.scenario = scenario;
	}
	@Then("verify user registered successfully")
	public void verifyUserRegisteredSuccessfully() {
		registerPage.isPopupDisplay(scenario);
	}

	@And("click on ok button")
	public void clickOnOKButton() {
		registerPage.clickOnOkButton();
	}
//
//	@After
//	public void tearDown(){
//		System.out.println("Inside After Hook!");
//		driver.quit();
//	}




}
