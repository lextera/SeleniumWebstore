package webstoreselenium.qa.pages;

import org.openqa.selenium.support.PageFactory;

import webstoreselenium.qa.base.TestBase;

public class OrderConfirmationTejas extends TestBase {

	public OrderConfirmationTejas(){
		PageFactory.initElements(driver, this);
	}
	
	// url contains --> minicircuits.com/WebStore/orderConfirmation_tejas.htm
	//a[contains(@href,'model')] getText();
	//span[contains(@class,'unit')].getText() --> ₨739.05
	////div[@class='description_quality description_items_last_two']//span --> quantity
	//span[contains(@style,'font-weight')] - ORDER ID
}
