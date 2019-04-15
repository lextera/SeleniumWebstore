package webstoreselenium.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import webstoreselenium.qa.base.TestBase;
import webstoreselenium.qa.pages.HomePage;
import webstoreselenium.qa.pages.IndexPage;
import webstoreselenium.qa.pages.LoginPage;

public class HomePageTest extends TestBase {

	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	
	public HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialize();
		indexPage = new IndexPage();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.manage().deleteAllCookies();
		driver.close();
		driver.quit();
		driver = null;
	}
}
