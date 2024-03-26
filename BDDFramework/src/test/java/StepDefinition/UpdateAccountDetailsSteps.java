package StepDefinition;

import CommonUtility.BaseClass;
import PageObjects.UpdateAccountDetailsPage;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class UpdateAccountDetailsSteps {
    UpdateAccountDetailsPage updateAccountDetailsPage;


    @Given("clicks on my profile and go to the account details update")
    public void clicksOnMyProfileAndGoToTheAccountDetailsUpdate() {
        updateAccountDetailsPage = new UpdateAccountDetailsPage(BaseClass.driver);
        updateAccountDetailsPage.goToUpdateAccountDetails();

    }

    @And("fill all required details with valid information {string} {string} {string} {string} {string}")
    public void fillAllRequiredDetailsWithValidInformation(String accountHolderName, String bankName, String accountNumber, String IFSCcode, String initialBalance) {
        updateAccountDetailsPage.enterAccountDetails(accountHolderName, bankName, accountNumber, IFSCcode, initialBalance);
    }

    @And("clicks on update button")
    public void clicksOnUpdateButton() {
        updateAccountDetailsPage.clickOnSubmit(Hooks.getScenario());
    }

    @Then("verify updated account details")
    public void verifyUpdatedAccountDetails() {
        updateAccountDetailsPage.verifyAccountDetails(Hooks.getScenario());
    }

    @Given("click on my profile and go to the account details update")
    public void clickOnMyProfileAndGoToTheAccountDetailsUpdate() {
        updateAccountDetailsPage = new UpdateAccountDetailsPage(BaseClass.driver);
        updateAccountDetailsPage.goToUpdateAccountDetails();
    }

    @And("fill all required details with invalid information {string} {string} {string} {string} {string}")
    public void fillAllRequiredDetailsWithInvalidInformation(String accountHolderName, String bankName, String accountNumber, String ifscCode, String initialBalance) {
        updateAccountDetailsPage.enterAccountDetails(accountHolderName, bankName, accountNumber, ifscCode, initialBalance);

    }

    @And("clicks on update button of account details")
    public void clicksOnUpdateButtonOfAccountDetails() {
        updateAccountDetailsPage.clickOnSubmit(Hooks.getScenario());
    }

    @Then("verify error messages")
    public void verifyErrorMessages() {
        updateAccountDetailsPage.verifyTooltipMessage(Hooks.getScenario());
    }
}
