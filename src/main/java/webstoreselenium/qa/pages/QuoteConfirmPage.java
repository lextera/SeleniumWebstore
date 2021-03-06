package webstoreselenium.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webstoreselenium.qa.base.TestBase;
import webstoreselenium.qa.utils.TestUtil;

public class QuoteConfirmPage extends TestBase{

	String quoteFromWeb = "";
	public QuoteConfirmPage(){
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@style='font-weight: bold']") WebElement quoteID;
	@FindBy(xpath = "//div[@class='description_quality description_items_last_two']") WebElement qty;
	@FindBy(xpath = "//a[contains(@href,'checkoutQC.html')]") WebElement hereButton;
	
	//a[contains(@href,'checkoutQC.html')]
	
	public void printQuoteID (){
 
		System.out.println(quoteID.getText());
	}

	public boolean isQTYEquals( String quantity){
		
		System.out.println(qty.getText());
		return qty.getText().equals(quantity); 
		
	}
	
	public boolean quoteNumberCorrect(){
		String url = driver.getCurrentUrl();
		url.substring(url.length()-12, url.length());
		System.out.println(quoteID.getText());
		
		return false;
	}
	
	public String getQuoteId(){
		return quoteID.getText();
	}
	
	/**
	 * continue convert quote
	 * verify Qnumber, qty unit price
	 * click home
	 * @return 
	 * 
	 * */
	public CheckOutQC clickConvertHere(){
		TestUtil.click(hereButton);
		return new CheckOutQC();
		
	}
	
	
	
	
	
	/**
	 * click 'here' --> "checkOUtQC.html"
	 * 		>select shipping method
	 * 		>enter special instructions
	 * 		> click continnue1
	 * 		> click same as billing
	 * 		>cick contnue 2
	 * 		>i accept
	 * 		>continue2 --> "orderSummaryQC"
	 * 			>continue
	 * 			>select credit card
	 * 
	 * 
	 * 
	 * */
	
	
	
	
	
}
