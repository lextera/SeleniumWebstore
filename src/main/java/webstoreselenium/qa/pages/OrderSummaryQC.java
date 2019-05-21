package webstoreselenium.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webstoreselenium.qa.base.TestBase;
import webstoreselenium.qa.utils.TestUtil;

public class OrderSummaryQC extends TestBase {

	public OrderSummaryQC(){
		PageFactory.initElements(driver, this);
	}
	
	/*
	 * verify order table
	 * verify currentURL
	 * 
	 * */
	
	
	@FindBy (xpath = "//span[@class='summary_term_continue']")  WebElement continue1;
	@FindBy (xpath = "//span[@class='summary_cancel_order']")  WebElement cancel;
	
	@FindBy (xpath = "//label[@id='replace_text']")  WebElement creditCard;
	//span[contains(text(),'Card Ending 5326')]
	@FindBy (xpath = "//span[contains(text(),'Card Ending 5326')]")  WebElement selectExisting;
	@FindBy (id = "submit_mcl_order")  WebElement continue2;
	@FindBy(id= "sumbit_mcl_order_confirmed") public WebElement confirmPopUp;
	

	
	public void selectExistingCard(){

		TestUtil.click(continue1);
		TestUtil.waitTillElementFound(creditCard);
		TestUtil.clickJS(creditCard);
		TestUtil.waitTillElementFound(selectExisting);
		TestUtil.clickJS(selectExisting);
		TestUtil.click(continue2); 
		

	}
	
	public OrderConfirmation clickPlaceOrder(){

		TestUtil.waitTillElementFound(confirmPopUp); 
		TestUtil.clickJS(confirmPopUp); 

		TestUtil.waitTilURLContains("orderConfirmation.html?oid");
		return new OrderConfirmation();
	}
	
	
}
