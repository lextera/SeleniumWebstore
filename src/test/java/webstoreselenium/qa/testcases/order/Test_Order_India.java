package webstoreselenium.qa.testcases.order;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import webstoreselenium.qa.base.TestBase;
import webstoreselenium.qa.pages.Cart;
import webstoreselenium.qa.pages.CheckOut;
import webstoreselenium.qa.pages.DashBoard;
import webstoreselenium.qa.pages.HomePage;
import webstoreselenium.qa.pages.IndexPage;
import webstoreselenium.qa.pages.LoginPage;
import webstoreselenium.qa.pages.OrderSummary;


public class Test_Order_India extends TestBase {
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	DashBoard dashboard;
	Cart cart;

	CheckOut checkout;
	OrderSummary orderSummary;
	
	String model = "ADE-5";
	String qty ="1";

	public Test_Order_India(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialize();
		indexPage = new IndexPage();
		loginPage = new LoginPage();
		homePage = new HomePage();
		dashboard = new DashBoard();
		cart = new Cart();	
		orderSummary = new OrderSummary();
		
		
	}
	@Test
	public void verify_order_details() {
		loginPage = indexPage.signIn();
		indexPage = loginPage.clickLogin(prop.getProperty("username"), prop.getProperty("password"));
		dashboard = indexPage.searchModel(model);
		dashboard.enterQtyAndAddToCart(qty);
		checkout = cart.checkOutNow();
		checkout.selectShipFromCountry(); 
		checkout.clickLoadSavedAddr();
		checkout.clickBillInfoSame(); //good
		orderSummary = checkout.clickIAcceptTermsAndCo();
		orderSummary.clickCancelOrderTejas();
		//orderSummary.clickSubmitOrderTejas();
		
	}
	@AfterMethod //(enabled = false)
	public void tearDown(){
		driver.manage().deleteAllCookies();
		driver.close();
		driver.quit();
		driver = null;
	}
	
	
	
}
