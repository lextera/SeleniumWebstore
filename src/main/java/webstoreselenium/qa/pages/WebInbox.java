package webstoreselenium.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webstoreselenium.qa.base.TestBase;
import webstoreselenium.qa.utils.TestUtil;

public class WebInbox extends TestBase {

	public WebInbox (){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//p[contains(text(),'Number')]") WebElement quoteText;
	@FindBy(xpath="//span[@autoid='_lv_b' and contains(text(),'Quote Confirmation')] ") WebElement quoteEmail;
	@FindBy(xpath="//span[@autoid='_lv_b' and contains(text(),'Online Order')]") WebElement orderEmail;
	@FindBy(xpath="//p[contains(text(),'Secure Order Number is')]") WebElement orderText;
	
	
	
	
	public String getQuoteID(){
		quoteEmail.click();
		TestUtil.waitTillElementFound(quoteText);
		return quoteText.getText();
	}
	
	public String getOrderID(){
		orderEmail.click();
		TestUtil.waitTillElementFound(orderText);
		return orderText.getText();
	}
}
