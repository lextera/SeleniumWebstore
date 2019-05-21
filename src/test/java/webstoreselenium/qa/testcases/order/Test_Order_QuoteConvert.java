package webstoreselenium.qa.testcases.order;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import webstoreselenium.qa.base.TestBase;
import webstoreselenium.qa.pages.Cart;
import webstoreselenium.qa.pages.CheckOutQC;
import webstoreselenium.qa.pages.DashBoard;
import webstoreselenium.qa.pages.HomePage;
import webstoreselenium.qa.pages.IndexPage;
import webstoreselenium.qa.pages.LoginPage;
import webstoreselenium.qa.pages.OrderConfirmation;
import webstoreselenium.qa.pages.OrderSummaryQC;
import webstoreselenium.qa.pages.Quote;
import webstoreselenium.qa.pages.QuoteConfirmPage;


public class Test_Order_QuoteConvert extends TestBase{
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	DashBoard dashboard;
	Cart cart;
	Quote quote;
	QuoteConfirmPage quoteConfirm;
	CheckOutQC checkOutQC;
	OrderSummaryQC orderSumQC;
	OrderConfirmation orderConfirm;
	
	String model = "ADE-2";
	String qty = "8";

	
	public Test_Order_QuoteConvert(){
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
		quote = new Quote();
		quoteConfirm = new QuoteConfirmPage();
		checkOutQC = new CheckOutQC();
		orderSumQC = new OrderSummaryQC();
		orderConfirm = new OrderConfirmation();
		
		//
		/*click bill same as shipping
		 * continue2
		 * t&c + continue  --> order summaryQC > continue
		 * 	select card > continue
		 * 
		 * 
		 * */
		
		
	}
	
	@Test
	public void verify_convertQuoteToOrder() {
		
		loginPage = indexPage.signIn();
		indexPage = loginPage.clickLogin(prop.getProperty("username"), prop.getProperty("password"));
		dashboard = indexPage.searchModel(model);
		dashboard.enterQtyAndAddToCart(qty);
		quote = cart.clickConvertToQuote();
		quoteConfirm = quote.produceQuote();
		checkOutQC = quoteConfirm.clickConvertHere();
		checkOutQC.selectShipMethod();
		checkOutQC.clickBillInfoSame();
		
		orderSumQC = checkOutQC.clickIAcceptTermsAndCo();
		orderSumQC.selectExistingCard();
		orderConfirm = orderSumQC.clickPlaceOrder();
		System.out.println(orderConfirm.displayOrderNumber());
		
		Assert.assertTrue(orderConfirm.isQTYEquals(qty));
		Assert.assertTrue(orderConfirm.isModelCorrect(model));

		
	}
	
	@AfterMethod //(enabled = false)
	public void tearDown(){
		driver.manage().deleteAllCookies();
		driver.close();
		driver.quit();
		driver = null;
	}
}
