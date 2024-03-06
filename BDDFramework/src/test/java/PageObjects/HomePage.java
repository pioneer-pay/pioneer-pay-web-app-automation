package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CommonUtility.BaseClass;

public class HomePage{
	
	WebDriver driver ;
	
	public HomePage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
//	@FindBy(xpath = "(//a[@amplitude-id='menu-signup'])[2]")
//	WebElement linkRegister;
	
//	public void clickOnRegisterLink() {
//		linkRegister.click();
//	}

}
