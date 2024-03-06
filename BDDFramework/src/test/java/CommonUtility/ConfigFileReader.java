package CommonUtility;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	
	private Properties properties;
	private final String propertyFilePath= System.getProperty("user.dir")+"/resources/TestData/Configuration.properties";
	 String baserurl ;
    String SenderCountryCode;
    String SenderLanguageCode;
    String ExtendedUrl;
    String driverPath;
    String browserName;
	
	public ConfigFileReader(){
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}		
	}
	

	

	public String getBaseUrl() {
		baserurl = properties.getProperty("baseUrl");
		if(baserurl != null) return baserurl;
		else throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	

	public String getSenderCountryCode() {
		SenderCountryCode = properties.getProperty("SenderCountryCode");
		if(SenderCountryCode != null) return SenderCountryCode;
		else throw new RuntimeException("SenderCountryCode not specified in the Configuration.properties file.");
	}
	public String getSenderLangaugeCode() {
		SenderLanguageCode = properties.getProperty("SenderLanguageCode");
		if(SenderLanguageCode != null) return SenderLanguageCode;
		else throw new RuntimeException("SenderLanguageCode not specified in the Configuration.properties file.");
	}
	public String getExtendedUrl(String url) {
	    ExtendedUrl = properties.getProperty(url);
		if(ExtendedUrl != null) return ExtendedUrl;
		else throw new RuntimeException("ExtendedUrl not specified in the Configuration.properties file.");
	}
	
	public String getApplicationHomePageURL(String baseUrl) {
		System.out.println("Url : -"+baseUrl);
		return baseUrl;
	}
	public String getBrowser() {
		browserName = properties.getProperty("browserName");
		if(browserName != null) return browserName;
		else throw new RuntimeException("browserName not specified in the Configuration.properties file.");
	}

}

	