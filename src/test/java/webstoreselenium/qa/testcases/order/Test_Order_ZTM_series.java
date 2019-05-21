package webstoreselenium.qa.testcases.order;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import webstoreselenium.qa.base.TestBase;
import webstoreselenium.qa.pages.HomePage;
import webstoreselenium.qa.pages.IndexPage;
import webstoreselenium.qa.pages.LoginPage;
import webstoreselenium.qa.pages.PortTestEquip;
import webstoreselenium.qa.pages.ProductsZTM;
import webstoreselenium.qa.pages.WebStoreZTM;


public class Test_Order_ZTM_series extends TestBase {
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	
	PortTestEquip pte;
	ProductsZTM prodZTM;
	WebStoreZTM webZTM;

	public Test_Order_ZTM_series() {
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialize();
		indexPage = new IndexPage();
		loginPage = new LoginPage();
		homePage = new HomePage();
	
		pte = new PortTestEquip();
		prodZTM = new ProductsZTM();
		webZTM = new WebStoreZTM();
		
			
	}
	
	@Test
	public void verify_ZTM_order(){
		loginPage = indexPage.signIn();
		indexPage = loginPage.clickLogin(prop.getProperty("username"), prop.getProperty("password"));
		pte = indexPage.clickRFTestSolutions();
		prodZTM = pte.clickZTMseries();
		webZTM = prodZTM.clickZTMseries();
		webZTM.selectConfig();
		webZTM.enterContactDetails();
		Assert.assertTrue(webZTM.isConfigDisplayedCorrect());

	}
	
	@AfterMethod //(enabled = false)
	public void tearDown(){
		driver.manage().deleteAllCookies();
		driver.close();
		driver.quit();
		driver = null;
	}
	
}
