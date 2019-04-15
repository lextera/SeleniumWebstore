package webstoreselenium.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import webstoreselenium.qa.base.TestBase;
import webstoreselenium.qa.pages.HomePage;
import webstoreselenium.qa.pages.IndexPage;
import webstoreselenium.qa.pages.LoginPage;
import webstoreselenium.qa.pages.UpdateProfile;
import webstoreselenium.qa.utils.TestUtil;

public class UpdateProfileTest extends TestBase {
	
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	UpdateProfile updateProf;
	String sheetName1 = "Add-address";
	
	public UpdateProfileTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialize();
		indexPage = new IndexPage();
		loginPage = new LoginPage();
		homePage = new HomePage();
		updateProf = new UpdateProfile();
/*		loginPage = indexPage.signIn();
		indexPage = loginPage.clickLogin(prop.getProperty("username"), prop.getProperty("password"));
		updateProf = indexPage.updateProfile();*/
		
		
	}
	
	@Test (enabled = false)
	public void verifyCurrentUrl(){
		loginPage = indexPage.signIn();
		indexPage = loginPage.clickLogin(prop.getProperty("username"), prop.getProperty("password"));
		updateProf = indexPage.updateProfile();
		

		String actual = updateProf.validateURL();
		System.out.println(updateProf.validateURL());
		Assert.assertEquals(actual, "https://www1.minicircuits.com/WebStore/updateProfile.html");
	}
	@DataProvider
	public Object[][] getData(){
		Object [][] data = TestUtil.getTestData(sheetName1);
		return data;
		
		
	}
	@Test (dataProvider = "getData")
	public void verifyCreatedNewAddress(String fname, String lname, String title, String comp, 
			String street, String country, String city, String state, String zip, String delivPhone){
		loginPage = indexPage.signIn();
		indexPage = loginPage.clickLogin(prop.getProperty("username"), prop.getProperty("password"));
		updateProf = indexPage.updateProfile();
		
		updateProf.createNewAddress(fname, lname, title, comp, street, country, 
				city, state, zip, delivPhone);
		
	}
	
	@AfterMethod (enabled = true)
	public void tearDown(){
		driver.manage().deleteAllCookies();
		driver.close();
		driver.quit();
		driver = null;
	}
	
}
