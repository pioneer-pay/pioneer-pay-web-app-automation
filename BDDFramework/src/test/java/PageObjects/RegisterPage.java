package PageObjects;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import CommonUtility.BaseClass;
import CommonUtility.ConfigFileReader;
import io.cucumber.java.Scenario;


public class RegisterPage{

	ConfigFileReader configFileReader;
	WebDriver driver ;

	public RegisterPage(WebDriver driver) {

		this.driver=driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[normalize-space()='Register']")
	WebElement linkRegister;

	@FindBy(xpath = "//input[contains(@id, 'email')]")
	WebElement emailId;

	@FindBy(xpath = "//input[contains(@id, 'password')]")
	WebElement password;

	@FindBy(xpath="//button[@type='submit']")
	WebElement registerButton;

	@FindBy(xpath = "//button[contains(@class, 'swal2-confirm swal2-styled')]")
	WebElement lblRegister;


	public void clickOnRegisterLink() {
		linkRegister.click();
	}
	public void enterUsersEmail() {
		configFileReader = new ConfigFileReader();
		emailId.sendKeys(configFileReader.getExpectedText("emailId"));

	}
	public void enterPassword() {
		password.sendKeys(configFileReader.getExpectedText("password"));

	}
	public void clickOnRegister() {
		registerButton.click();
	}
	public void isPopupDisplay(Scenario scenario){
		configFileReader = new ConfigFileReader();
		String xpath = String.format("//h2[@id='swal2-title']", configFileReader.getExpectedText("registerMessage"));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement registerMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		Assert.assertEquals(configFileReader.getExpectedText("registerMessage"), registerMessage.getText());
		BaseClass.captureScreenshot("register screenshot", scenario);
		System.out.println("Both actual and expected results are same, \n User is registered successfully");
	}
	public void clickOnOkButton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(lblRegister));
		lblRegister.click();




	}
}
