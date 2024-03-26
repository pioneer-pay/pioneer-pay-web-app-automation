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

public class TransactionHistoryPage {
	WebDriver driver ;
	ConfigFileReader configFileReader;

	public TransactionHistoryPage(WebDriver driver) {

		this.driver=driver;
		PageFactory.initElements(driver, this);

	}
	@FindBy(xpath = "//a[contains(text(), 'Histo')]")
	WebElement linkHistory;


	public void clickonHistoryLink() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(500));
		wait.until(ExpectedConditions.visibilityOf(linkHistory));
		linkHistory.click();
	}

	public void isTransactionHistoryDetailsDisplayed() {
		configFileReader = new ConfigFileReader();
		String expectedText = configFileReader.getText("transactionMessage");
		String xpath = String.format("//th[normalize-space(text())='%s']", expectedText);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		try {
			WebElement transactionMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
			Assert.assertEquals(expectedText, transactionMessage.getText());
			System.out.println("Both actual and expected results are same");
		} catch (Exception e) {
			// Handle exception appropriately (e.g., log error, take screenshot)
			System.out.println("Error occurred: " + e.getMessage());
		}

	}
	public boolean isListOfPreviousTransactionsDisplayed(Scenario scenario) {
		WebElement tableElement = driver.findElement(By.xpath("//table[@class='table table-striped']"));
		BaseClass.captureScreenshot("transaction screenshot", scenario);

		return tableElement.isDisplayed();
	}

}


