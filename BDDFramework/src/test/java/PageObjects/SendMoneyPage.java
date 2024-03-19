package PageObjects;

import CommonUtility.ConfigFileReader;
import io.cucumber.java.Scenario;
import org.jsoup.Connection;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CommonUtility.BaseClass;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.xpath.XPath;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

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

    @FindBy(xpath = "//div[@class = 'head-left']//img")
    WebElement txnDetails;

    @FindBy(xpath = "//tbody[1]//tr[1]//td[8]")
    WebElement txnStatus;

    @FindBy(xpath = "//tbody[1]//tr[1]//td[5]")
    WebElement txnAmount;

    @FindBy(xpath = "//a[normalize-space()='History']")
    WebElement btnHistory;


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
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-200)");
        btnSelect.click();
        btnReview.click();
    }

    public void clickOnSendMoney(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-200)");
        txtConfirmDetails.isDisplayed();
        btnSendMoney.click();
    }

    public void clickOnReviewBtn(){
        System.out.println("Button isSelected: "+btnSelect.isSelected());
        btnReview.click();
    }


    public void verifyTxnSuccess(Scenario scenario){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.textToBePresentInElement(txtTxnStatus,"Your transaction was successful!"));
        expectedMsg = fileReader.getText("txnSuccessMessage");
        actualMsg = txtTxnStatus.getText();
        Assert.assertEquals(expectedMsg,actualMsg);
        BaseClass.captureScreenshot("Transaction Successful Page",scenario);
    }

    public void verifyErrorInsufficientFunds(Scenario scenario){
        waits(txtTxnStatus);
        expectedMsg = fileReader.getText("insufficientFundsMessage");
        actualMsg = txtTxnStatus.getText();
        BaseClass.captureScreenshot("Transaction Attempt with Insufficient Funds",scenario);
        Assert.assertEquals(expectedMsg,actualMsg);

    }

    public void verifyTxnDetails(Scenario scenario){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElement(transferAmount,"5000"));
        Assert.assertNotNull(exchangeRate.getText());
        Assert.assertNotNull(Fee.getText());
        Assert.assertNotNull(transferAmount.getText());
        Assert.assertNotNull(amountToReceive.getText());
        BaseClass.captureScreenshot("Transaction Summary", scenario);

    }

    public void verifyErrorSelectReceiver(Scenario scenario){

        expectedMsg = fileReader.getText("selectReceiverMessage");
        actualMsg = txtConfirmDetails.getText();
        BaseClass.captureScreenshot("Transaction Attempt without Receiver Selected",scenario);
        Assert.assertEquals(expectedMsg,actualMsg);

    }

    public void verifyTxnHistory(Scenario scenario){
        btnHistory.click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElement(txnStatus,"SUCCESS"));
        expectedMsg = fileReader.getText("txnStatus");
        actualMsg = txnStatus.getText();
        Assert.assertEquals(expectedMsg,actualMsg);
        BaseClass.captureScreenshot("Transaction History",scenario);

    }


}
