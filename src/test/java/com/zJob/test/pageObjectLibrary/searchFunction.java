package com.zJob.test.pageObjectLibrary;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;

//import static com.tillster.test.mca.mobile.helperLibrary.testHooksHelper.WEB_DRIVER_WAIT;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.zJob.pageObjectConstants.PageObjectConstant;

import cucumber.api.DataTable;
import gherkin.formatter.model.DataTableRow;


public class searchFunction extends basePage implements PageObjectConstant {
	
	public static WebDriver WEB_DRIVER;
	public searchFunction(WebDriver driver) {
		
		super(driver);
	}
		
	
	@FindBy(how = How.XPATH, using = TRAVELTAB)
	public WebElement travelTab;
	
	@FindBy(how = How.XPATH, using = HOTELTAB)
	public WebElement hotelTab;
	
	@FindBy(how = How.NAME, using = DESTINATION)
	public WebElement destination;
	
	@FindBy(how = How.XPATH, using = HOTELSEARCH)
	public WebElement hotelSearch;
	
	@FindBy(how = How.XPATH, using = RESULTS1)
	public WebElement results1;
	
	@FindBy(how = How.XPATH, using = RESULTS2)
	public WebElement results2;
	
	@FindBy(how = How.CSS, using = COOKIEACCEPT)
	public WebElement cookieAccept;
	
	public void scroll()throws Exception{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)", "");
	}
	
	public void clickTravelTab() throws Exception{
		travelTab.click();
		hotelTab.click();
	}
		
	public void clickAndSearch() throws Exception{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(DESTINATION)));
		cookieAccept.click();
		destination.click();
		destination.sendKeys(DESTINATIONTEXT);
		WebDriverWait wait1 = new WebDriverWait(driver, 80);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(HOTELSEARCH)));
		hotelSearch.click();
		
	}
	
	public void verifyResults() throws Exception{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RESULTS1)));
		String resultPrice1 = results1.getText();
		System.out.println(resultPrice1);
		String resultPrice2 = results2.getText();
		System.out.println(resultPrice2);
		assertFalse(resultPrice1 == resultPrice2);
	}
	
}
