package StepDefinition;
import CommonUtility.BaseClass;
import PageObjects.UpdateProfilePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class UpdateProfileSteps extends BaseClass {

    UpdateProfilePage updateProfilePage;
    @Given("login pioneer pay application and click on my profile")
    public void goToMyProfile() throws Exception {
        setUp();
        navigateToUrl();
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
        updateProfilePage.verify();
    }
}
