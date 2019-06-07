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
import webstoreselenium.qa.pages.OrderConfirmation;
import webstoreselenium.qa.pages.OrderSummary;
import webstoreselenium.qa.pages.WebInbox;
import webstoreselenium.qa.pages.WebMail;

public class Test_Order_UK extends TestBase {
	
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	DashBoard dashboard;
	Cart cart;
	CheckOut checkout;
	OrderSummary ordersummary;
	OrderConfirmation orderconfirmation;
	WebMail webmail;
	WebInbox webinbox;
	
	String model = "MAC-80LH+";
	String qty ="10";
	String fedExGround = "29";
	String pageTitle = "Mini-Circuits Order Confirmation";
	String orderIDGenerated = "";
	
	public Test_Order_UK(){
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
		ordersummary =  new OrderSummary();
		orderconfirmation = new OrderConfirmation();
		webmail = new WebMail();
		webinbox = new WebInbox();
	}
	
	@Test
	public void verify_UK_order(){
		
		loginPage = indexPage.signIn();
		indexPage = loginPage.clickLogin(prop.getProperty("username"), prop.getProperty("password"));
		dashboard = indexPage.searchModel(model);
		dashboard.enterQtyAndAddToCart(qty);
		checkout = cart.checkOutNow();
		/*
		 * clickLoadSavedShipping()
		 * clickShipOptions("501");
		 * clickBillSameAsAddress();
		 * .fillExportEnduserFormForMCE
		 * 	order = checkout.agreeTermsAndCondition(); //click continue of checkout opage
		order.selectExistingCardMCE();
		orderconfirmation = order.clickPlaceOrderMCE();
		 * 
		 * **/
		checkout.selectShipOptions(fedExGround);
		checkout.clickContinue();
		checkout.clickBillInfoSame();
		ordersummary = checkout.clickIAcceptTermsAndCo();
		ordersummary.selectExistingCard();
		orderconfirmation = ordersummary.clickPlaceOrder();
		System.out.println("--------------ORDER# generated-----------------" + orderconfirmation.displayOrderNumber());
		
		// assert quantity is equals
		Assert.assertTrue(orderconfirmation.isQTYEquals(qty));
		
		
		System.out.println("Page Title is :  " + driver.getTitle());
		Assert.assertEquals(driver.getTitle(), pageTitle);
		System.out.println("Current URL with order number :  " + driver.getCurrentUrl());

	
	}
	@AfterMethod //(enabled = false)
	public void tearDown(){
		driver.manage().deleteAllCookies();
		driver.close();
		driver.quit();
		driver = null;
	}
	
	
}
