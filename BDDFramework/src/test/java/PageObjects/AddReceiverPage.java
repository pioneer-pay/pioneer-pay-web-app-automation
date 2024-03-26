package PageObjects;

import CommonUtility.BaseClass;
import CommonUtility.ConfigFileReader;
import io.cucumber.java.Scenario;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddReceiverPage {
    WebDriver driver ;

    public AddReceiverPage(WebDriver driver) {

        this.driver=driver;
        PageFactory.initElements(driver, this);
        fileReader = new ConfigFileReader();

    }

    ConfigFileReader fileReader;
    String actual, expected;

    @FindBy(xpath = "(//button[@class=\"btn btn-primary btn-lg btn-block button-login\"])[1]")
    WebElement btnAddReceiver;

    @FindBy(xpath = "//input[@id='bankName']")
    WebElement txtBankName;

    @FindBy(id = "holderName")
    WebElement txtReceiverName;

    @FindBy(id = "accountNo")
    WebElement txtAccountNo;

    @FindBy(id = "ifscCode")
    WebElement txtIfsc;

    @FindBy(id = "amount")
    WebElement txtAmount;

    @FindBy(css = "button[type='submit']")
    WebElement btnSave;

    @FindBy(xpath = "//h2[@id='swal2-title']")
    WebElement regMessage;

    @FindBy(xpath = "//button[normalize-space()='OK']")
    WebElement btnOk;

    public void clickOnAddReceiver(){
        btnAddReceiver.click();
    }

    public void enterDetails(String bankName,String receiverName,String accountNumber,String ifscCode,String amount,Scenario scenario){
        txtBankName.sendKeys(bankName);
        txtReceiverName.sendKeys(receiverName);
        txtAccountNo.sendKeys(accountNumber);
        txtIfsc.sendKeys(ifscCode);
        txtAmount.sendKeys(amount);
        BaseClass.captureScreenshot("Receiver Details",scenario);
        btnSave.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(regMessage));
    }

    public void verifySuccessfulMsg(Scenario scenario){
//        fileReader = new ConfigFileReader();
        actual = regMessage.getText();
        expected = fileReader.getText("receiverAddedMsg");
        Assert.assertEquals(expected,actual);
        BaseClass.captureScreenshot("Receiver Added Page",scenario);
        btnOk.click();
    }

    public void verifyErrorMsg(Scenario scenario){
//        fileReader = new ConfigFileReader();
        expected = fileReader.getText("invalidDetailsMsg");
        actual = regMessage.getText();
        BaseClass.captureScreenshot("Invalid Receiver Details",scenario);
        Assert.assertEquals(expected,actual);

    }
    public void verifyErrorMsgInvalidAmt(Scenario scenario){
//        fileReader = new ConfigFileReader();
        expected = fileReader.getText("invalidAmountMsg");
        actual = regMessage.getText();
        BaseClass.captureScreenshot("Invalid Receiver Details",scenario);
        Assert.assertEquals(expected,actual);

    }

}
