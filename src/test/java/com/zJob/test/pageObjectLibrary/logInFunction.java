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


public class logInFunction extends basePage implements PageObjectConstant {
	
	@FindBy(how = How.XPATH, using = "//div[@id='spinnerDiv']")
 	private WebElement pageLoader;
	
	public logInFunction(WebDriver driver) {
		
		super(driver);
	}

	@FindBy(how = How.CSS, using = LOGINURL)
	public WebElement loginURL;
	
	@FindBy(how = How.ID, using = REGISTERPAGE)
	public WebElement registerPage;
	
	@FindBy(how = How.ID, using = EMAIL)
	public WebElement email;
	
	@FindBy(how = How.ID, using = PASSWORD)
	public WebElement password;
	
	@FindBy(how = How.ID, using = REPASSWORD)
	public WebElement rePassword;
	
	@FindBy(how = How.NAME, using = REGISTERBUTTON)
	public WebElement registerButton;
	
	@FindBy(how = How.CSS, using = REGISTERALERT)
	public WebElement registerAlert;
	
	@FindBy(how = How.XPATH, using = ALERTCLOSE)
	public WebElement alertClose;
	
	@FindBy(how = How.CSS, using = ALERTACCEPT)
	public WebElement alertAccept;
	
	
	@FindBy(how = How.XPATH, using = LOGIN)
	public WebElement login;
	
	@FindBy(how = How.ID, using = EMAIL1)
	public WebElement email1;
	
	@FindBy(how = How.ID, using = PASSWORD1)
	public WebElement password1;
	
	@FindBy(how = How.ID, using = LOGINBUTTON)
	public WebElement loginButton;
	
	@FindBy(how = How.CSS, using = REGISTERPOINTS)
	public WebElement registerPoints;
	
	@FindBy(how = How.ID, using = DROPDOWN)
	public WebElement dropDown;
	
	@FindBy(how = How.XPATH, using = LOGOUT)
	public WebElement logOut;
	
	public void scroll()throws Exception{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,500)", "");
	}
	
	public void clickRegisterButton()throws Exception{
		Thread.sleep(20000);
		loginURL.click();
		scroll();
		registerPage.click();
		email.click();
		email.sendKeys(EMAILTEXT);
		password.click();
		password.sendKeys(PASSWORDTEXT);
		scroll();
		rePassword.click();
		rePassword.sendKeys(PASSWORDTEXT);
		registerButton.click();
	}
	
	public void verifyAlertMessage()throws Exception{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(REGISTERALERT)));
		String alertMessage = registerAlert.getText();
		System.out.println(alertMessage);
		assertTrue(ALERTTEXT, alertMessage.contains(ALERTTEXT));
		alertAccept.click();
	}
	
	public void clickLoginAndLogout()throws Exception{
		scroll();
		login.click();
		email1.click();
		email1.clear();
		email1.sendKeys(EMAILTEXT);
		password1.click();
		password1.sendKeys(PASSWORDTEXT);
		loginButton.click();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(REGISTERPOINTS)));
		registerPoints.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ALERTCLOSE)));
		alertClose.click();
		dropDown.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LOGOUT)));
		logOut.click();
	}
	
}
