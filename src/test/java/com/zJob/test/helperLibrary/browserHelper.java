package com.zJob.test.helperLibrary;

import static com.zJob.test.helperLibrary.testHooksHelper.WEB_DRIVER;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class browserHelper {
        
    public static void setBrowserProp(String browserName)
    {
    	System.out.println("browserName: "+browserName);
    	
    	if (browserName.equalsIgnoreCase("chrome"))
    	{
        	System.setProperty("webdriver.chrome.driver", ".//src/test/resources/com/zJob/test/application/driverFiles/chromedriver_74.exe");
        	System.setProperty("webdriver.chrome.logfile", ".//target//bk-ph/chromedriver.log");
        	System.setProperty("webdriver.chrome.verboseLogging", "true");
        	ChromeOptions chrOptions = new ChromeOptions();
			chrOptions.addArguments("--window-size=1366,768", "--start-maximized"); //,"--no-sandbox"
        	WEB_DRIVER = new ChromeDriver(chrOptions);
    	}
    	else if (browserName.equalsIgnoreCase("IE"))
    	{
        	System.setProperty("webdriver.ie.driver", ".//src/test/resources/com/zJob/test/application/driverFiles/IEDriverServer.exe");
        	WEB_DRIVER = new InternetExplorerDriver();
    	}
    	else if (browserName.equalsIgnoreCase("firefox"))
    	{
        System.setProperty("webdriver.gecko.driver", ".//src/test/resources/com/zJob/test/application/driverFiles/geckodriver_v0.14.0.exe");
        	FirefoxOptions ffOptions = new FirefoxOptions();
        	ffOptions.addArguments("--window-size=1366,768", "--start-maximized");
    		WEB_DRIVER = new FirefoxDriver(ffOptions);
    	}
    	else if (browserName.equalsIgnoreCase("chrome-headless"))
		{
			System.setProperty("webdriver.chrome.driver", ".//src/test/resources/zJob/test/application/driverFiles/chromedriver_2.35.exe");
			ChromeOptions chrOptions = new ChromeOptions();
			chrOptions.addArguments("--headless", "--window-size=1366,768", "--start-maximized");
			WEB_DRIVER = new ChromeDriver(chrOptions);
		}
    	
    }

}
