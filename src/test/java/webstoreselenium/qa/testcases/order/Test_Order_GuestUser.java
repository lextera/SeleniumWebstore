package webstoreselenium.qa.testcases.order;


import org.testng.Assert;
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
import webstoreselenium.qa.pages.PayTracePage;

public class Test_Order_GuestUser extends TestBase{

	public Test_Order_GuestUser(){
		super();
		
	}
	
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	DashBoard dashboard;
	CheckOut checkout;
	Cart cart;
	OrderSummary ordersummary;
	PayTracePage payTrace;
	
	String model = "ADE-2";
	String qty = "8";
	String guestEmail = "lex_acosta@yahoo.com";
	String fedExpress = "19";
	String fname = "Guest FirstName";
	String lname = "Guest LastName";
	String addr = "13 Neptune Ave";
	String city = "Brooklyn";
	String state = "NY";
	String zip = "11235";
	
	@BeforeMethod
	public void setUp(){
		initialize();
		indexPage = new IndexPage();
		loginPage = new LoginPage();
		homePage = new HomePage();
		checkout = new CheckOut();
		ordersummary =  new OrderSummary();
		payTrace = new PayTracePage(); 
		
	}
	
	@Test
	public void verify_Order_GuestUser(){
		dashboard = indexPage.searchModel(model);
		cart = dashboard.enterQtyAndAddToCart(qty);
		loginPage = cart.checkOutGuestUser();
		checkout = loginPage.enterGuestUserEmail(guestEmail);
		checkout.enterNameAndAddress(fname, lname, addr, city, state, zip, "98*99*100");
		checkout.clickContinue();
		checkout.billInforForGuest();
		
		ordersummary = checkout.clickIAcceptTermsAndCo();
		ordersummary.payByCreditCard();
		payTrace = ordersummary.clickPlaceOrderGuestUser();
		payTrace.enterCardDetails();
		System.out.println(driver.getCurrentUrl());
		Assert.assertTrue(driver.getCurrentUrl().contains("minicircuits.com/WebStore/orderConfirmation.htm"));
	}
	
	@AfterMethod //(enabled = false)
	public void tearDown(){
		driver.manage().deleteAllCookies();
		driver.close();
		driver.quit();
		driver = null;
	}
	
	
	
}
