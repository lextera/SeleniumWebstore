package webstoreselenium.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webstoreselenium.qa.base.TestBase;

public class OrderConfirmation extends TestBase {

	public OrderConfirmation(){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//div[@class= 'description_quality description_items_last_two']") private WebElement quantity;
	@FindBy (xpath = "//div[@class='summary_title']/p[2]/span") private WebElement quoteOrder;
	//div[@class='summary_title']/p[2]/span
	
	public boolean isQTYEquals(String qty){
		
		return quantity.getText().equals(qty);
		 
	}
	
	public String displayQuoteOrder(){
		return quoteOrder.getText();
	}
}
