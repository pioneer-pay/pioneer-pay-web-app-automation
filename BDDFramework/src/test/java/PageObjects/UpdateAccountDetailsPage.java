package PageObjects;

import CommonUtility.BaseClass;
import CommonUtility.ConfigFileReader;
import io.cucumber.java.Scenario;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateAccountDetailsPage {
    WebDriver driver;
    ConfigFileReader configFileReader;

    public UpdateAccountDetailsPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href='#!/dashboard/profile']")
    WebElement myProfile;


    @FindBy(xpath = "//a[@href='#!/dashboard/profile/account']")
    WebElement updateAccount;

    @FindBy(xpath = "//div[@class='container panel']//div[1]//input[1]")
    WebElement name;

    @FindBy(xpath = "//div[2]//input[1]")
    WebElement bank;

    @FindBy(xpath = "//input[@id='accountNo']")
    WebElement accountNo;

    @FindBy(xpath = "//input[@id='ifscCode']")
    WebElement ifsc;
    @FindBy(xpath = "//input[@id='amount']")
    WebElement amount;

    @FindBy(xpath = "//button[normalize-space()='Update']")
    WebElement submit;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/table[1]/tbody[1]/tr[1]/td[2]")
    WebElement accountHolderName;

    @FindBy(xpath = "//button[normalize-space()='OK']")
    WebElement okButton;

    public void goToUpdateAccountDetails() {
        myProfile.click();
        updateAccount.click();
    }
    
    public void enterAccountDetails(String accountHolderName, String bankName, String accountNumber, String ifscCode, String initialBalance) {
        name.clear();
        name.sendKeys(accountHolderName);
        bank.clear();;
        bank.sendKeys(bankName);
        accountNo.clear();
        accountNo.sendKeys(accountNumber);
        ifsc.clear();
        ifsc.sendKeys(ifscCode);
        amount.clear();
        amount.sendKeys(initialBalance);
    }

    public void clickOnSubmit(Scenario scenario) {
        submit.click();
        BaseClass.captureScreenshot("message", scenario);
        okButton.click();
    }

    public void verifyAccountDetails(Scenario scenario) {
        configFileReader= new ConfigFileReader();

        String actualText = accountHolderName.getText();
        String ExpectedText = configFileReader.getText("accountHolderName");
        Assert.assertEquals(ExpectedText,actualText);
        BaseClass.captureScreenshot("UpdatedAccountDetails", scenario);
    }


    public void verifyTooltipMessage(Scenario scenario) {
        BaseClass.captureScreenshot("UpdatedAccountDetails", scenario);
    }
}
