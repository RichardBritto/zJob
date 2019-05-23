package com.zJob.test.stepDefLibrary;


import static com.zJob.test.helperLibrary.testHooksHelper.WEB_DRIVER;

import org.openqa.selenium.support.ui.WebDriverWait;

import com.zJob.test.pageObjectLibrary.logInFunction;
import com.zJob.test.pageObjectLibrary.searchFunction;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class logInFunctionStepDefs {

	
	logInFunction appPage = new logInFunction(WEB_DRIVER);
	
    public static WebDriverWait waitForElement = null;
       
    @Given("^User is in DoneDeal website application and clicks LogIn Button$")
    public void user_is_in_DoneDeal_website_application_and_clicks_LogIn_Button() throws Throwable {
        
    	appPage.clickRegisterButton();
    	
        
    }

    @When("^User enters an existing users email and password$")
    public void user_enters_an_existing_users_email_and_password() throws Throwable {
    	
    	appPage.verifyAlertMessage();
    	
        
    }

    @Then("^user verify the error message$")
    public void user_verify_the_error_message() throws Throwable {
        
    	appPage.clickLoginAndLogout();
        
    }
    


}

