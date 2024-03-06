package CommonUtility;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BaseClass {
	public static WebDriver driver;
	String browserName;
    Properties properties;
    ConfigFileReader fileReader; 
    String browser;

   public void navigateToUrl(String extendedURl) {
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
}
