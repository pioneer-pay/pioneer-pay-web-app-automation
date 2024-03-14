package CommonUtility;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.cucumber.java.Scenario;

public class BaseClass {
	public static WebDriver driver;
	String browserName;
	Properties properties;
	ConfigFileReader fileReader;
	String browser;

   public void navigateToUrl() {
	  String url=fileReader.getApplicationHomePageURL(fileReader.getBaseUrl());
	  driver.get(url);
	
    }
   
   public void setUp() throws Exception {
	   try {
			fileReader =new ConfigFileReader();
			browser = fileReader.getBrowser();
			System.out.println("browser name: "+browser);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "/resources/drivers/chromedriver.exe");
			ChromeOptions options=new ChromeOptions();
			driver=new ChromeDriver(options);
			driver.manage().window().maximize();
		}else {
			throw new Exception("incorrect browser");
		}



	}

	public static void captureScreenshot(String screenshotName, Scenario scenario) {

		try{
			if(scenario!= null){
				TakesScreenshot ts = (TakesScreenshot) driver;
				byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
				scenario.attach(screenshot, "image/png", screenshotName);
			}
			else
				System.out.println("Scenario Is Not Initialized!");

		}catch (Exception e){
			System.out.println("Failed to Capture ScreenSHot! Check Scenario Object");
		}
	}

}
