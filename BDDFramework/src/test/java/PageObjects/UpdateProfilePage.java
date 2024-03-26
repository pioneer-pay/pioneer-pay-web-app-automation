package PageObjects;

import CommonUtility.BaseClass;
import CommonUtility.ConfigFileReader;
import io.cucumber.java.Scenario;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class UpdateProfilePage {
    WebDriver driver ;
    ConfigFileReader configFileReader;

    public UpdateProfilePage(WebDriver driver) {

        this.driver=driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//a[@role='button']")
    WebElement updateButton;
    @FindBy(xpath = "//input[@ng-model='user.firstName']")
    WebElement firstName;

    @FindBy(xpath = "//input[@ng-model='user.lastName']")
    WebElement lastName;

    @FindBy(xpath = "//input[@ng-model='user.mobileNumber']")
    WebElement mobileNumber;

    @FindBy(xpath = "//input[@ng-model='user.dob']")
    WebElement dob;

    @FindBy(xpath = "//input[@ng-model='user.address1']")
    WebElement address1;

    @FindBy(xpath = "//input[@ng-model='user.address2']")
    WebElement address2;

    @FindBy(xpath = "//input[@ng-model='user.city']")
    WebElement city;

    @FindBy(xpath = "//input[@ng-model='user.zip']")
    WebElement pincode;

    @FindBy(xpath = "//input[@ng-model='user.state']")
    WebElement state;

    @FindBy(xpath = "//input[@ng-model='user.country']")
    WebElement country;
    
    @FindBy(xpath = "//button[@type='submit']")
    WebElement submit;


    @FindBy(xpath = "//a[@href='#!/dashboard/profile']")
    WebElement myProfile;


    @FindBy(xpath = "//h2[@id='swal2-title']")
    WebElement successfulMessage;

    @FindBy(xpath = "//h2[@id='swal2-title']")
    WebElement errorMessage;

    @FindBy(xpath = "//button[@class='swal2-confirm swal2-styled']")
    WebElement okButton;


    public void clickOnMyProfile() {
        myProfile.click();
        updateButton.click();
    }

    public void fillUpdateForm(String name) {
        configFileReader= new ConfigFileReader();
        firstName.clear();
        firstName.sendKeys(name);
        lastName.clear();
        lastName.sendKeys(configFileReader.getText("lastName"));
        mobileNumber.clear();
        mobileNumber.sendKeys(configFileReader.getText("mobileNumber"));
        dob.clear();
        dob.sendKeys("06072000");
        address1.clear();
        address1.sendKeys(configFileReader.getText("address1"));
        address2.clear();
        address2.sendKeys(configFileReader.getText("address2"));
        city.clear();
        city.sendKeys(configFileReader.getText("city"));
        pincode.clear();
        pincode.sendKeys(configFileReader.getText("pincode"));
        state.clear();
        state.sendKeys(configFileReader.getText("state"));
        country.clear();
        country.sendKeys(configFileReader.getText("country"));

    }

    public void clickOnSubmit() {
        submit.click();
    }

    public void verify(Scenario scenario) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@id='swal2-title']")));
        String actualText = successfulMessage.getText();
        String expectedText = configFileReader.getText("expectedMessage");

        Assert.assertEquals(expectedText,actualText);
        BaseClass.captureScreenshot("updated", scenario);
        okButton.click();

    }

    public void updateInformation() {
        configFileReader= new ConfigFileReader();
        firstName.clear();
        lastName.clear();
        mobileNumber.clear();
        dob.clear();
        dob.sendKeys("06072000");
        address1.clear();
        address1.sendKeys(configFileReader.getText("address1"));
        address2.clear();
        address2.sendKeys(configFileReader.getText("address2"));
        city.clear();
        city.sendKeys(configFileReader.getText("city"));
        pincode.clear();
        pincode.sendKeys(configFileReader.getText("pincode"));
        state.clear();
        state.sendKeys(configFileReader.getText("state"));
        country.clear();
        country.sendKeys(configFileReader.getText("country"));

    }

    public void verifyMessages(Scenario scenario) {
        WebElement elementWithToolTip = driver.findElement(By.xpath("//input[@ng-model='user.firstName']"));
        Actions action = new Actions(driver);
        action.moveToElement(elementWithToolTip).perform();
        String tooltip_text = elementWithToolTip.getAttribute("title");
        BaseClass.captureScreenshot("updated", scenario);


    }

    public void enterDetails() {
        configFileReader= new ConfigFileReader();
        firstName.clear();
        firstName.sendKeys(configFileReader.getText("longTextFirstname"));
        lastName.clear();
        lastName.sendKeys(configFileReader.getText("longTextLastname"));
        mobileNumber.clear();
        mobileNumber.sendKeys(configFileReader.getText("mobileNumber"));
        dob.clear();
        dob.sendKeys("09022006");
        address1.clear();
        address1.sendKeys(configFileReader.getText("address1"));
        address2.clear();
        address2.sendKeys(configFileReader.getText("address2"));
        city.clear();
        city.sendKeys(configFileReader.getText("city"));
        pincode.clear();
        pincode.sendKeys(configFileReader.getText("pincode"));
        state.clear();
        state.sendKeys(configFileReader.getText("state"));
        country.clear();
        country.sendKeys(configFileReader.getText("country"));
    }

    public void verifyErrorMessage(Scenario scenario) {
        BaseClass.captureScreenshot("ErrorMessage", scenario);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@id='swal2-title']")));
        String actualText = errorMessage.getText();
        String expectedText = configFileReader.getText("errorMessage");

        Assert.assertEquals(expectedText,actualText);
        okButton.click();


    }


}
