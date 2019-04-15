package webstoreselenium.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import webstoreselenium.qa.base.TestBase;
import webstoreselenium.qa.pages.IndexPage;
import webstoreselenium.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {

	IndexPage indexPage;
	LoginPage loginPage;
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialize();
		indexPage = new IndexPage();
		
	}
	
	@Test 
	public void verifyCurrentUrl(){
		loginPage = indexPage.signIn();
		String actual = loginPage.getLoginUrl();
		System.out.println(actual);
		Assert.assertEquals(actual, "https://www1.minicircuits.com/WebStore/login.html");
		//System.out.println(driver.getCurrentUrl());
	}
	
	@Test
	public void verifyErrorMsgForInvalidLogin(){
		loginPage = indexPage.signIn();
		String actual = loginPage.enterIncorrectLogin("inval", "invalid");
		Assert.assertEquals(actual, "Invalid login name.");

		
	}
	
	
	@AfterMethod 
	public void tearDown(){
		driver.manage().deleteAllCookies();
		driver.close();
		driver.quit();
		driver = null;
	}
	
	
	
}
