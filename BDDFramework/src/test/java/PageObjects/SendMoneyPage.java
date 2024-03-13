package PageObjects;

import CommonUtility.ConfigFileReader;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CommonUtility.BaseClass;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SendMoneyPage {

    WebDriver driver ;

    public SendMoneyPage(WebDriver driver) {

        this.driver=driver;
        PageFactory.initElements(driver, this);
        fileReader = new ConfigFileReader();

    }

    ConfigFileReader fileReader;

    @FindBy(id = "countrySelectFrom")
    WebElement countryFromDrpdown;

    @FindBy(id = "countrySelectTo")
    WebElement countryToDrpdown;

    @FindBy(id = "amount")
    WebElement inputSendAmount;

    @FindBy(id = "convert-button")
    WebElement btnConvert;

    @FindBy(xpath = "//div[@class='card-content']")
    WebElement receiverPaymentMethod;

    @FindBy(xpath = "//div[@class='card-content1']")
    WebElement senderPaymentMethod;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement btnContinue;

    @FindBy(xpath = "//h3[normalize-space()='Select Receiver From here']")
    WebElement txtSelectRec;

    @FindBy(xpath = "(//button[normalize-space()='Select'])[1]")
    WebElement btnSelect;

    @FindBy(xpath = "//button[normalize-space()='Review and Confirm Transfer']")
    WebElement btnReview;

    @FindBy(xpath = "//h3[normalize-space()='Confirm the details']")
    WebElement txtConfirmDetails;

    @FindBy(xpath = "//button[@class='btn btn-lg']")
    WebElement btnSendMoney;

    @FindBy(xpath = "//h3[@class='text-left ng-binding']")
    WebElement txtTxnStatus;

    @FindBy(xpath = "//tbody/tr[1]/td[1]")
    WebElement exchangeRate;

    @FindBy(xpath = "//tbody/tr[2]/td[1]")
    WebElement Fee;

    @FindBy(xpath = "//tbody/tr[3]/td[1]")
    WebElement transferAmount;

    @FindBy(xpath = "//tbody/tr[4]/td[1]")
    WebElement amountToReceive;


    String expectedMsg;
    String actualMsg;

    public void waits(WebElement webelement){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(webelement));
    }


    public void selectCountry(String sendFromCountry, String sendToCountry){

        Select sendFrom = new Select(countryFromDrpdown);
        Select sendTo = new Select(countryToDrpdown);
        sendFrom.selectByVisibleText(sendFromCountry);
        sendTo.selectByVisibleText(sendToCountry);

    }

    public void enterTxnAmount(int txnAmount){
        inputSendAmount.sendKeys(String.valueOf(txnAmount));
        btnConvert.click();
    }

    public void selectPaymentMethods(){
        receiverPaymentMethod.click();
        senderPaymentMethod.click();
        btnContinue.click();
    }

    public void selectReceiver(){
        btnSelect.click();
        btnReview.click();
    }

    public void clickOnSendMoney(){
        txtConfirmDetails.isDisplayed();
        btnSendMoney.click();
    }

    public void verifyTxnSuccess(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.visibilityOf(txtTxnStatus));
        expectedMsg = fileReader.getData("txnSuccessMessage");
        actualMsg = txtTxnStatus.getText();
        Assert.assertEquals(expectedMsg,actualMsg);
    }

    public void verifyErrorInsufficientFunds(){
        waits(txtTxnStatus);
        expectedMsg = fileReader.getData("insufficientFundsMessage");
        actualMsg = txtTxnStatus.getText();
        Assert.assertEquals(expectedMsg,actualMsg);

    }

    public void verifyTxnDetails(){
        Assert.assertNotNull(exchangeRate.getText());
        Assert.assertNotNull(Fee.getText());
        Assert.assertNotNull(transferAmount.getText());
        Assert.assertNotNull(amountToReceive.getText());

    }


}
