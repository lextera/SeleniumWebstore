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
 * Test Data : 
 * 		GALI-4+
 *     CMA-62+
 *     ERA-3+
 *     EQY-0-63+ 
 *     LEE-19+
 * 
 * Pre -Condition: 
 * 
 *   DELETE  from 
 	WEBORDER where order_type = 'S' and email = 'lextera@minicircuits.com'
 	
 	
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
	String model2 = "CMA-62+";
	String model3 = "ERA-3+";
	String model4 = "EQY-0-63+";
	String model5 = "LEE-19+";
	String modelx = "BFCG-162W+";
	
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
		loginPage = indexPage.signIn();
		indexPage = loginPage.clickLogin(prop.getProperty("username"), prop.getProperty("password"));
		

		//webmail = new WebMail();
		//webinbox = new WebInbox();
	}
	@Test (priority = 0)
	public void verify_EZorder_success(){
		

		dashboard = indexPage.searchModel(model);
		ezsample = dashboard.clickRequestSample();
		ezcheckout = ezsample.enterRequireField();
		ezcheckout.clickContinue();
		ezorderConfirm = ezcheckout.acceptAndSubmit();
		Assert.assertTrue(ezorderConfirm.isModelSame(model));
			
	}
	
	@Test (priority = 1) // cannot order same order within 30 days
	public void verify_Exception_noSameOrder1Month(){
		dashboard = indexPage.searchModel(model);
		Assert.assertTrue(dashboard.isExceptionMessage1Displayed());
			
	}
	

		
	
	
	@Test(enabled = false)
	public void verify_US_ezOrderEmail_generated(){
		navigateToWebMail();
		webinbox = webmail.login(prop.getProperty("username"), prop.getProperty("webmailpwd"));
		System.out.println("------------------email ezOrder confirmation-----------------------------"+webinbox.getOrderID());
		//ezorderConfirm.isOrderNumberSame(webinbox.getOrderID());
		//Assert.assertTrue(webinbox.getOrderID().contains(orderIDGenerated));
		
	}
	
	@AfterMethod //(enabled = false)
	public void tearDown(){
		driver.manage().deleteAllCookies();
		driver.close();
		driver.quit();
		driver = null;
	}
	
}




