package com.zJob.test.helperLibrary;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import org.assertj.core.api.BDDSoftAssertions;
import org.junit.Assert;
import org.junit.Rule;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumber.listener.Reporter;
import com.google.common.io.Files;

import static com.zJob.test.helperLibrary.browserHelper.setBrowserProp;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class testHooksHelper {
	
	public static WebDriver WEB_DRIVER;
    public static WebDriverWait WEB_DRIVER_WAIT;
    
    
    @Before
    public void beforeScenario(Scenario scenario) throws InterruptedException {
   	
    	setBrowserProp("chrome");    	
    	WEB_DRIVER_WAIT = new WebDriverWait(WEB_DRIVER,45);
    	WEB_DRIVER.manage().deleteAllCookies();
        WEB_DRIVER.manage().window().maximize();    	


        WEB_DRIVER.get("https://www.check24.de/");
    }

    @After
    public void afterScenario(Scenario scenario) throws InterruptedException, Exception {

       
        Thread.sleep(3000);
        WEB_DRIVER.quit();
        
        DateFormat trunDate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date todayrun = new Date();
		
    }
}