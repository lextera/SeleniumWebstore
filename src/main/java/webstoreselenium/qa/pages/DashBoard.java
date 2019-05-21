package webstoreselenium.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webstoreselenium.qa.base.TestBase;
import webstoreselenium.qa.utils.TestUtil;

public class DashBoard extends TestBase {
	
	public DashBoard(){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id= "qty_number") WebElement qty;
	@FindBy(id = "add_to_cart") WebElement addToCart; 
	@FindBy(id = "qty_list") WebElement qty2;
	@FindBy(id = "add_to_cart2") WebElement addToCart2;
	@FindBy(id = "order_ez_sample_model") WebElement ezSample;
	@FindBy(xpath = "//div[contains(text(), 'EZ-Sample Limit Exceeded')]") WebElement exceptionMessage1;
	
	
	
	
	public Cart enterQtyAndAddToCart(String quantity){
		try{
			TestUtil.clearAndSendKeys(qty, quantity);
		}catch(org.openqa.selenium.NoSuchElementException e){
			TestUtil.clearAndSendKeys(qty, quantity);
		}
		
		TestUtil.click(addToCart);
		return new Cart();
		
	}
	
	//eval board
	public Cart enterBoardQtyAndAddToCart(String quantity){
		TestUtil.clearAndSendKeys(qty2, quantity);
		TestUtil.click(addToCart2);
		return new Cart();
	}
	
	public EZSamplePage clickRequestSample(){
		TestUtil.click(ezSample);
		return new EZSamplePage();
	}
	public boolean isExceptionMessage1Displayed(){
		TestUtil.click(ezSample);
		//return exceptionMessage1.isDisplayed();
		return exceptionMessage1.isEnabled();
		
	}
	
	public boolean isExceptionMessage2Displayed(){
		TestUtil.click(ezSample);
		//return exceptionMessage1.isDisplayed();
		return exceptionMessage1.isEnabled();
		
	}
	

}
