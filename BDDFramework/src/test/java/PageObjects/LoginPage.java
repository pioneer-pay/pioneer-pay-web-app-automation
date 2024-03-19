package PageObjects;

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

import java.time.Duration;

public class LoginPage{

	WebDriver driver ;
	ConfigFileReader configFileReader;

	public LoginPage(WebDriver driver) {

		this.driver=driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[normalize-space()='Log in']")
	WebElement btnLogin;

	@FindBy(id = "email")
	WebElement txtEmail;

	@FindBy(id = "password")
	WebElement txtPassword;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement btnContinue;

	@FindBy(xpath = "//button[@class='swal2-confirm swal2-styled' and text()='OK']")
	WebElement lblLogin;


	public void clickLogin(){
		btnLogin.click();
	};

	public void enterEmailAndPassword(){
		configFileReader = new ConfigFileReader();
		txtEmail.sendKeys(configFileReader.getText("emailId"));
		txtPassword.sendKeys(configFileReader.getText("password"));
	}

	public void clickContinue(){
		btnContinue.click();
	}

	public void isPopupDisplayed(Scenario scenario){
		configFileReader = new ConfigFileReader();
		String xpath = String.format("//h2[@id='swal2-title']", configFileReader.getText("loginMessage"));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3000));
		WebElement loginMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		Assert.assertEquals(configFileReader.getText("loginMessage"), loginMessage.getText());
		BaseClass.captureScreenshot("login screenshot", scenario);
		System.out.println("Both actual and expected results are same, \n User is logged in successfully");

	}
	public void clickOnOkButton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(lblLogin));
		lblLogin.click();
	}

}