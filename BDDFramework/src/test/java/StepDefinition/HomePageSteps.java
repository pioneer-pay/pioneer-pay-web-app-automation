package StepDefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import CommonUtility.BaseClass;
import PageObjects.HomePage;
import io.cucumber.java.en.*;


public class HomePageSteps extends BaseClass {
	
//  WebDriver driver;
  HomePage homePage;
  
  @Given("navigate to home page URL {string}")
  public void navigate_to_home_page_url(String extendedUrl) throws Exception {
	  setUp();
      navigateToUrl(extendedUrl);
  }


@When("Click on Register user")
public void click_on_register_user() {
	homePage=new HomePage(BaseClass.driver);
	//homePage.clickOnRegisterLink();
    
}

@Then("verify Register page Title")
public void verify_register_page_title() {
	System.out.println("verify title");
    
}







}
