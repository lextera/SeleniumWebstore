package webstoreselenium.qa.testcases.quote;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import webstoreselenium.qa.base.TestBase;
import webstoreselenium.qa.pages.Cart;
import webstoreselenium.qa.pages.DashBoard;
import webstoreselenium.qa.pages.HomePage;
import webstoreselenium.qa.pages.IndexPage;
import webstoreselenium.qa.pages.LoginPage;
import webstoreselenium.qa.pages.Quote;
import webstoreselenium.qa.pages.QuoteConfirmPage;
import webstoreselenium.qa.pages.WebInbox;
import webstoreselenium.qa.pages.WebMail;

public class Test_Quote_UK extends TestBase{
	
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	DashBoard dashboard;
	Cart cart;
	Quote quote;
	QuoteConfirmPage quoteConfirm;
	WebMail webmail;
	WebInbox webinbox;
	
	String model = "ADE-10H";
	String qty = "8";
	String quoteGenerated = "";
	
	public Test_Quote_UK(){
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
		webmail = new WebMail();
		webinbox = new WebInbox();
	}
	
	@Test
	public void verify_MCL_quote(){
		loginPage = indexPage.signIn();
		indexPage = loginPage.clickLogin(prop.getProperty("username"), prop.getProperty("password"));
		dashboard = indexPage.searchModel(model);
		cart = dashboard.enterQtyAndAddToCart(qty);
		cart.changeShipCountry("GB");
		quote = cart.clickConvertToQuote();
		quoteConfirm = quote.produceQuote();
		quoteConfirm.printQuoteID();
		Assert.assertTrue(quoteConfirm.isQTYEquals(qty));
		quoteGenerated = quoteConfirm.getQuoteId();
		System.out.println("-------------------MCE Quote generated---------------------" +quoteConfirm.getQuoteId());
		
	}
	
	@Test (enabled = false) // (dependsOnMethods = "verify_MCL_quote")
	public void verify_MCL_quoteEmail_generated(){
		
		navigateToWebMail();
		webinbox = webmail.login(prop.getProperty("username"), prop.getProperty("webmailpwd"));
		System.out.println("------------------MCE Quote from EMAIL-----------------------------"+webinbox.getQuoteID());
		Assert.assertTrue(webinbox.getQuoteID().contains(quoteGenerated));
		
		
	}
	
	@AfterMethod //(enabled = false)
	public void tearDown(){
		driver.manage().deleteAllCookies();
		driver.close();
		driver.quit();
		driver = null;
	}
}
