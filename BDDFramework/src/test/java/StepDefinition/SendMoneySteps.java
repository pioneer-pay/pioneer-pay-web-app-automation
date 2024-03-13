package StepDefinition;

import CommonUtility.BaseClass;
import PageObjects.SendMoneyPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class SendMoneySteps {

    WebDriver driver;

    SendMoneyPage sendMoneyPage;

    @When("user selects send from country {string} and selects to country as {string}.")
    public void selectCountryFromTo(String sendFromCountry, String sendToCountry) {
        sendMoneyPage = new SendMoneyPage(BaseClass.driver);
        sendMoneyPage.selectCountry(sendFromCountry,sendToCountry);

    }

    @And("^enter send amount as (\\d+) and clicks on convert button\\.$")
    public void enterAmount(int txnAmount) {
        sendMoneyPage.enterTxnAmount(txnAmount);
    }

    @And("select bank account payment method for payout and card method as payin and clicks On continue Button.")
    public void selectPaymentMethods() {
        sendMoneyPage.selectPaymentMethods();
    }

    @And("selects receiver from list and clicks on confirm transfer button.")
    public void selectReceiver() {
        sendMoneyPage.selectReceiver();
    }

    @And("clicks on Send Money button")
    public void clickOnSendMoney() {
        sendMoneyPage.clickOnSendMoney();
    }

    @Then("verify Transaction Successful message is displayed.")
    public void verifyTxnSuccessful() {
        sendMoneyPage.verifyTxnSuccess();
    }

    @Then("verify error message is displayed for insufficient funds and transaction is failed.")
    public void verifyMessageInsufficientFunds() {
        sendMoneyPage.verifyErrorInsufficientFunds();
    }


    @Then("verify transaction details are displayed in the summary")
    public void verifyTxnDetails() {
        sendMoneyPage.verifyTxnDetails();
    }
}
