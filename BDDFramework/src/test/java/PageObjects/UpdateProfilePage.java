package PageObjects;

import CommonUtility.ConfigFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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


    public void clickOnMyProfile() {
        updateButton.click();
    }

    public void fillUpdateForm(String name) {
        configFileReader= new ConfigFileReader();
        firstName.sendKeys(name);
        lastName.sendKeys(configFileReader.getText("lastName"));
        mobileNumber.sendKeys(configFileReader.getText("mobileNumber"));
        address1.sendKeys(configFileReader.getText("address1"));
        address2.sendKeys(configFileReader.getText("address2"));
        city.sendKeys(configFileReader.getText("city"));
        pincode.sendKeys(configFileReader.getText("pincode"));
        state.sendKeys(configFileReader.getText("state"));
        country.sendKeys(configFileReader.getText("country"));

    }

    public void clickOnSubmit() {
        submit.click();
    }

    public void verify() {

    }
}
