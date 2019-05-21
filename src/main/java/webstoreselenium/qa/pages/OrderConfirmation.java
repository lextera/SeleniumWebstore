package webstoreselenium.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webstoreselenium.qa.base.TestBase;

public class OrderConfirmation extends TestBase {

	public OrderConfirmation(){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//div[@class= 'description_quality description_items_last_two']/span") private WebElement quantity;
	@FindBy (xpath = "//a[contains(@href,'dashboard.html')]") private WebElement model;
	@FindBy (xpath = "//div[@class='summary_title']/p[2]/span") private WebElement quoteOrder;
	//a[contains(@href,'dashboard.html')]
	
	public boolean isQTYEquals(String qty){
		
		//return quantity.getText().equals(qty);
		System.out.println("Actual Quantity is : " + quantity.getText().trim());
		return quantity.getText().trim().equals(qty);
		 
	}
	
	public boolean isModelCorrect(String model1){
		System.out.println("Actual Model is : " + model.getText().trim());
		return model.getText().trim().equals(model1);
	}
	
	public String displayOrderNumber(){
		return quoteOrder.getText();
	}
}
