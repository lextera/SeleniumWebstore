package webstoreselenium.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import webstoreselenium.qa.base.TestBase;
import webstoreselenium.qa.utils.TestUtil;

public class OrderSummary extends TestBase {
	WebDriverWait wait;

	public OrderSummary(){
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath= "//span[@class='summary_term_continue']") public WebElement continue1;
	@FindBy(id= "submit_mcl_order") public WebElement continue2;
	@FindBy(xpath= "//span[@class='summary_cancel_order']") public WebElement cancel;
	@FindBy(xpath= "//div[@class='card_drop_menu_head']") public WebElement selectCC;
	@FindBy(xpath= "//span[@class='existing_card']") public WebElement savedCC;
	
	@FindBy(xpath = "//div[@id='myModal']//div[@class='header']") private WebElement modalConfirm;
	By loadWindow = By.id("myModal");
	@FindBy(id= "sumbit_mcl_order_confirmed") public WebElement confirmPopUp;
	
	@FindBy(id="submit_tejas_order") WebElement submitOrder;
	@FindBy(xpath="//span[contains(text(),'Cancel Order')]") WebElement cancelOrder;
	
	public void clickSubmitOrderTejas(){
		TestUtil.click(submitOrder);
	}
	
	public void clickCancelOrderTejas(){
		TestUtil.click(cancelOrder);
	}
	

	
	public void selectExistingCard(){

		TestUtil.click(continue1);

		//select card
		//org.openqa.selenium.ElementNotVisibleException
		TestUtil.waitTillElementFound(selectCC);
		
		TestUtil.clickJS(selectCC);
		
		TestUtil.waitTillElementFound(savedCC);

		TestUtil.clickJS(savedCC);

		TestUtil.click(continue2); 
			
		
	}
	
	public OrderConfirmation clickPlaceOrder(){
		
		//TestUtil.waitTillElementFound(modalConfirm); // pop up
		TestUtil.waitTillElementFound(confirmPopUp); // new 1 - wait til placeorderOK button appears instead of the pop up
		//TestUtil.isElementPresent(driver, "//span[@id='sumbit_mcl_order_confirmed']", 20).click(); --> maybe this cause the delay
		TestUtil.clickJS(confirmPopUp); //new 2 - 
		/*
		 * circle will load now, needs to wait  to clear or waitURLContains
		 * 
		 * 
		 * **/
		

		//TestUtil.waitTillInvisibleBy(loadWindow); // if this is not run not getting the correct url
		TestUtil.waitTilURLContains("orderConfirmation.html?oid");
		
/*		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.);*/
		return new OrderConfirmation();
	}
	
	
	
}
