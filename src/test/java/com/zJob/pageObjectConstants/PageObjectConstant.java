
package com.zJob.pageObjectConstants;


public interface PageObjectConstant {

	String BROWSER_NAME="chromedriver_2.45";
	String BROWSER_NAME_PROPERTY = "browsername";
	String BROWSER_NAME_CHROME = "chrome";
	String BROWSER_NAME1 = "IE";
	String BROWSER_NAME2= "firefox";
	String SITE_URL = "https://www.check24.de/";
	String LOGINURL = ".c24-meinkonto-reflink";
	String REGISTERPAGE = "new_customer";
	String EMAIL = "email";
	String PASSWORD = "password";
	String REPASSWORD = "passwordrepetition";
	String EMAILTEXT = "richytesting@gmail.com";
	String PASSWORDTEXT = "123comeandgo";
	String REGISTERBUTTON = "register";
	String REGISTERALERT = ".c24-dialog-box";
	String ALERTTEXT = "E-Mail-Adresse wird bereits verwendet.";
	String ALERTACCEPT = ".button-right.button-ok";
	String ALERTCLOSE = "//*[@id='c24-dialog-points-modal']/div/header/button";
	String LOGIN = "//*[@id='register']/div[6]/div[1]/a";
	String EMAIL1 = "cl_email_prefill";
	String PASSWORD1 = "cl_pw_prefill";
	String LOGINBUTTON = "c24-cl-user-prefill-btn";
	
	String REGISTERPOINTS = ".points_register";
	String DROPDOWN = "c24-meinkonto";
	String LOGOUT = "//*[@id='c24-meinkonto']/div/div[2]/a";
	
	String TRAVELTAB = "//*[@id='c24-header-bottom']/div/nav/div/div/ul/li[5]/a/span";
	String HOTELTAB = "//*[@id='c24-travel-js-traveltype-hotelonly-tab-wrapper']/a";
	String DESTINATION = "destinationQueryInput";
	String DESTINATIONTEXT = "Berlin";
	String HOTELSEARCH = "//*[@id='searchFormContainer']/section/form/div[2]/div/div[1]/div[2]/div/div[2]/div/div/button";
	String RESULTS1 = "//*[@id='hotelResultsContainer']/div/div[2]/div[2]/section/div/div[1]/section/div[1]/div[2]/div[5]/div[3]/div/div[2]/div[2]/a[2]";
	String RESULTS2 = "//*[@id='hotelResultsContainer']/div/div[2]/div[2]/section/div/div[2]/section/div[1]/div[2]/div[5]/div[3]/div/div[2]/div[2]/a[2]";
	String COOKIEACCEPT = ".c24-cookie-button";
}
