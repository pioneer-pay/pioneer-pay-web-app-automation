package StepDefinition;
import CommonUtility.BaseClass;
import PageObjects.UpdateProfilePage;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class UpdateProfileSteps extends BaseClass {

    UpdateProfilePage updateProfilePage;

    @Given("login pioneer pay application and click on my profile")
    public void goToMyProfile() throws Exception {
        updateProfilePage = new UpdateProfilePage(BaseClass.driver);
        updateProfilePage.clickOnMyProfile();
    }

    @Given("fill all required details {string}")
    public void fillDetails(String firstName) {
        updateProfilePage.fillUpdateForm(firstName);
    }

    @Given("click on update")
    public void clickOnUpdate() {
        updateProfilePage.clickOnSubmit();
    }

    @Then("verify updated profile")
    public void verifyUpdatedProfile() {
        updateProfilePage.verify(Hooks.getScenario());
    }

    @Given("click on my profile")
    public void clickOnMyProfile() {
        updateProfilePage = new UpdateProfilePage(BaseClass.driver);
        updateProfilePage.clickOnMyProfile();
    }

    @And("fill all required details with invalid information")
    public void fillAllRequiredDetailsWithInvalidInformation() {
        updateProfilePage.updateInformation();

    }

    @And("click on update button")
    public void clickOnUpdateButton() {
        updateProfilePage.clickOnSubmit();
    }

    @Then("verify error messages.")
    public void verifyErrorMessages() {
        updateProfilePage.verifyMessages(Hooks.getScenario());
    }

    @Given("click on my profile button")
    public void clickOnMyProfileButton() {
        updateProfilePage = new UpdateProfilePage(BaseClass.driver);
        updateProfilePage.clickOnMyProfile();
    }

    @And("fill all details with long text information")
    public void fillAllDetailsWithLongTextInformation() {
        updateProfilePage.enterDetails();
    }

    @And("clicks on update")
    public void clicksOnUpdate() {
        updateProfilePage.clickOnSubmit();
    }

    @Then("verify error message.")
    public void verifyErrorMessage() {
        updateProfilePage.verifyErrorMessage(Hooks.getScenario());
    }
}
