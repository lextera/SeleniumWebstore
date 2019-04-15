package webstoreselenium.qa.testcases.ezsample;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import webstoreselenium.qa.base.TestBase;
import webstoreselenium.qa.pages.DashBoard;
import webstoreselenium.qa.pages.EZSamplePage;
import webstoreselenium.qa.pages.EZorderconfirmation;
import webstoreselenium.qa.pages.EZsamplecheckout;
import webstoreselenium.qa.pages.HomePage;
import webstoreselenium.qa.pages.IndexPage;
import webstoreselenium.qa.pages.LoginPage;
import webstoreselenium.qa.pages.WebInbox;
import webstoreselenium.qa.pages.WebMail;
/**
 * (1) success order
 * (2) exception 1 : max of 5 sample in 30 days
 * (3) exception 2 : in 30 days
 * 
 * data 
 * CMA-62+
 * ERA-3+
 * GALI-4+ 
 * LEE-19+
 * select order_type, customer_id, order_id, email from 
 * WEBORDER where order_type = 'S' and email = 'lextera@minicircuits.com'
 */
public class Test_ezSample_sucess extends TestBase {
	
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	DashBoard dashboard;
	EZSamplePage ezsample;
	EZsamplecheckout ezcheckout;
	EZorderconfirmation ezorderConfirm;

	WebMail webmail;
	WebInbox webinbox;
	
	String model = "GALI-4+";
	
	public Test_ezSample_sucess() {
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialize();
		indexPage = new IndexPage();
		loginPage = new LoginPage();
		homePage = new HomePage();
		dashboard = new DashBoard();
		ezsample = new EZSamplePage();
		ezcheckout = new EZsamplecheckout();
		ezorderConfirm = new EZorderconfirmation();
		

		webmail = new WebMail();
		webinbox = new WebInbox();
	}
	@Test
	public void verify_EZorder_success(){
		
		loginPage = indexPage.signIn();
		indexPage = loginPage.clickLogin(prop.getProperty("username"), prop.getProperty("password"));
		dashboard = indexPage.searchModel(model);
		ezsample = dashboard.clickRequestSample();
		ezcheckout = ezsample.enterRequireField();
		ezcheckout.clickContinue();
		ezorderConfirm = ezcheckout.acceptAndSubmit();
		Assert.assertTrue(ezorderConfirm.isModelSame(model));
		
	
		
		/*
		 * assert model. order num and generated email
		 * 
		 * 
		 * **/

		System.out.println("Current URL with order number :  " + driver.getCurrentUrl());

	
	}
	
	@Test
	public void verify_US_ezOrderEmail_generated(){
		navigateToWebMail();
		webinbox = webmail.login(prop.getProperty("username"), prop.getProperty("webmailpwd"));
		System.out.println("------------------email ezOrder confirmation-----------------------------"+webinbox.getOrderID());
		//ezorderConfirm.isOrderNumberSame(webinbox.getOrderID());
		//Assert.assertTrue(webinbox.getOrderID().contains(orderIDGenerated));
		
	}
	
	@AfterMethod (enabled = false)
	public void tearDown(){
		driver.manage().deleteAllCookies();
		driver.close();
		driver.quit();
		driver = null;
	}
	
}




