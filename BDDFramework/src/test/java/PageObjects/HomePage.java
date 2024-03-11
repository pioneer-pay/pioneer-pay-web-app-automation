package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CommonUtility.BaseClass;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage{

	WebDriver driver ;

	@FindBy(xpath = "//a[normalize-space()='Log in']")
	WebElement btnLogin;

	@FindBy(id = "email")
	WebElement txtEmail;

	@FindBy(id = "password")
	WebElement txtPassword;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement btnContinue;

	@FindBy(xpath = "//div[@role='dialog']")
	WebElement lblLogin;

	public HomePage(WebDriver driver) {

		this.driver=driver;
		PageFactory.initElements(driver, this);

	}
	public void clickLogin(){
		btnLogin.click();
	};

	public void enterEmailAndPassword(){
		txtEmail.sendKeys("Testemail@gmail.com");
		txtPassword.sendKeys("Test@123");
	}

	public void clickContinue(){
		btnContinue.click();
	}

	public void isPopupDisplayed(){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(lblLogin));
		lblLogin.isDisplayed();
	}

}
