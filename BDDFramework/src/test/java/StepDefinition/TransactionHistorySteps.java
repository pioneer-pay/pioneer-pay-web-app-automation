package StepDefinition;



import org.openqa.selenium.WebDriver;

import CommonUtility.BaseClass;
import PageObjects.TransactionHistoryPage;
//import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;


public class TransactionHistorySteps extends BaseClass {

	WebDriver driver;
	TransactionHistoryPage transactionHistoryPage;
	Scenario scenario;

	@Before
	public void browserSetup(Scenario scenario) throws Exception {
		setUp();
		this.scenario = scenario;


	}
	@Given("the user is logged in to the transaction history module")
	public void theUserIsLoggedInToTheTransactionHistoryModule() {
		transactionHistoryPage = new TransactionHistoryPage(BaseClass.driver);


	}
	@When("the user navigates to the transaction history section")
	public void theUserNavigatesToTheTransactionHistorySection() {
		transactionHistoryPage.clickonHistoryLink();

	}
	@And("verify the transaction history should include details such as id,From account,To account,Date&Time,Transaction Amount,Commission,Recieved amount  and status")
	public void verifyTheTransactionHistoryShouldIncludeDetailsSuchAsIdFromAccountToAccountDateTimeTransactionAmountCommissionRecievedAmountAndStatus() {
		transactionHistoryPage.isTransactionHistoryDetailsDisplayed();
	}
	@Then("the user should see list of previous transaction")
	public void theUserShouldSeeListOfPreviousTransaction() {
		transactionHistoryPage.isListOfPreviousTransactionsDisplayed(scenario);
	}



}




