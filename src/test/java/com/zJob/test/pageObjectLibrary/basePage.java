package com.zJob.test.pageObjectLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class basePage {
	
	final WebDriver driver;
	final WebDriverWait driverwait;
	@FindBy(how = How.XPATH, using = "//div[@id='spinnerDiv']")
 	private WebElement pageLoader;
		
	 public basePage(WebDriver driver) {
	        this.driver = driver;
	        this.driverwait = new WebDriverWait(driver,45);
	        PageFactory.initElements(driver, this);
	    }
	
	 public WebElement findElementbyClassxPath(String xPath) {
		driverwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));
		WebElement elmnt = driver.findElement(By.xpath(xPath)); 
		return elmnt;
	 }
	 
    public void clickElementbyJS(WebElement wElmnt) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", wElmnt);
    }

    public void clickElementXpathbyJS(String elmtXpath) {
        WebElement wElmnt = driver.findElement(By.xpath(elmtXpath));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", wElmnt);
    }
    
    public void waitUntilnGFinishHttpCalls() throws InterruptedException { 
        ExpectedCondition<Boolean> pendingHttpCallsCondition = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return Boolean.valueOf(((JavascriptExecutor) driver).executeScript("return (window.angular !== undefined) && (angular.element(document).injector() !== undefined) && (angular.element(document).injector().get('$http').pendingRequests.length === 0)").toString());
            }
        };
        
        driverwait.until(pendingHttpCallsCondition);
    }
    
    public void waitForLoad() 
    {
      ExpectedCondition<Boolean> pageLoads = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
              return Boolean.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
            }
        };
        
        driverwait.until(pageLoads);
    }
    
    public void TypeInField(WebElement wElmnt, String valuetoEnter) throws InterruptedException {
        String textToEnter = valuetoEnter; 
        wElmnt.clear();
        Thread.sleep(100);
        for (int i = 0; i < textToEnter.length(); i++){
            char c = textToEnter.charAt(i);
            String s = new StringBuilder().append(c).toString();
            wElmnt.sendKeys(s);
            Thread.sleep(100);
        }       
    }
    
    public void highlightElement(WebElement element) throws InterruptedException {
        for (int i = 0; i < 2; i++) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].setAttribute('style', arguments[1]);",
                    element, "color: blue; border: 4px solid blue;");
            Thread.sleep(100);
            js.executeScript("arguments[0].setAttribute('style', arguments[1]);",
                    element, "");
            js.executeScript("arguments[0].setAttribute('style', arguments[1]);",
                    element, "color: blue; border: 4px solid blue;");
            Thread.sleep(100);
            js.executeScript("arguments[0].setAttribute('style', arguments[1]);",
                    element, "");
        }
    }

    public void waitOnElementInvisibility(WebElement element) throws InterruptedException {
    	driverwait.until(ExpectedConditions.not(ExpectedConditions.visibilityOf(element)));
    	Thread.sleep(2000);
	}
    
    public void waitOnSpinner() throws InterruptedException {
    	driverwait.until(ExpectedConditions.not(ExpectedConditions.visibilityOf(pageLoader)));
    	Thread.sleep(100);
	}
}