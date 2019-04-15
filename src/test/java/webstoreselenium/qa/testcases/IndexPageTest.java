package webstoreselenium.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import webstoreselenium.qa.base.TestBase;
import webstoreselenium.qa.pages.IndexPage;

public class IndexPageTest extends TestBase {
	//declare pom
	IndexPage indexPage;
	
	public IndexPageTest(){
		super(); // call constructor of TestBase to initialize config
	}
	
	
	@BeforeMethod
	public void setUp(){
		initialize();
		indexPage = new IndexPage();
	}
	
	@Test
	public void verifyIndexPageTitle(){
		//
		String actualTitle = indexPage.validatePageTitle();
		Assert.assertEquals(actualTitle, "Mini Circuits - Global Leader of RF and Microwave Components", "Home Page Title does not matched");
		
	}
	
	@AfterMethod
	public void tearDown(){
		driver.manage().deleteAllCookies();
		driver.close();
		driver.quit();
		driver = null;
	}
	

}
