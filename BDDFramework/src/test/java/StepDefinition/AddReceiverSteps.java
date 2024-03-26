package StepDefinition;

import CommonUtility.BaseClass;
import PageObjects.AddReceiverPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.messages.types.Hook;

import java.util.List;
import java.util.Map;

public class AddReceiverSteps {

    AddReceiverPage addReceiverPage;
    String bankName,receiverName,accountNumber,ifscCode,amount;


    @And("clicks on Add new receiver button")
    public void clickOnAddReceiverBtn() {
        addReceiverPage = new AddReceiverPage(BaseClass.driver);
        addReceiverPage.clickOnAddReceiver();
    }

    @And("^enters the following receiver details and Clicks on Save button:$")
    public void enterReceiverDetails(DataTable dataTable) {
        List<Map<String,String>> receiverDetails = dataTable.asMaps(String.class,String.class);
        for(Map<String, String> details: receiverDetails){
             bankName = details.get("bankName");
             receiverName = details.get("receiverName");
             accountNumber = details.get("accountNumber");
             ifscCode = details.get("ifscCode");
             amount = details.get("amount");
        }
        addReceiverPage.enterDetails(bankName,receiverName, accountNumber,ifscCode, amount, Hooks.getScenario());


    }

    @Then("verify message for receiver registered successfully.")
    public void verifyMessage() {
        addReceiverPage.verifySuccessfulMsg(Hooks.getScenario());
    }

    @Then("verify error message displayed for invalid Details.")
    public void verifyErrorMessage() {
        addReceiverPage.verifyErrorMsg(Hooks.getScenario());
    }

    @Then("verify error message displayed for user entered invalid amount.")
    public void verifyErrorMsgInvalidAmount() {
        addReceiverPage.verifyErrorMsgInvalidAmt(Hooks.getScenario());
    }
}
