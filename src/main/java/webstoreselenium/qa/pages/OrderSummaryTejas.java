package webstoreselenium.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webstoreselenium.qa.base.TestBase;

public class OrderSummaryTejas extends TestBase {

	public OrderSummaryTejas(){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[contains(text(),'Cancel Order')]") WebElement cancelOrder;
	@FindBy(id="submit_tejas_order") WebElement submitOrder;
	
	
}
