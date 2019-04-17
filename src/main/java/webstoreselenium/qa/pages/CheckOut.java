package webstoreselenium.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webstoreselenium.qa.base.TestBase;
import webstoreselenium.qa.utils.TestUtil;

public class CheckOut extends TestBase {
	JavascriptExecutor executor;
	String testNote = "Test Transaction from Software Dept, Please Disregard";
	
	public CheckOut(){
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy (id = "submit_shipping")  WebElement continue1;
	@FindBy (id = "special_instructions_ship")  WebElement specInstrucText; 
	@FindBy (id = "phone_ship")  WebElement deliverPhone;
	@FindBy (id = "shipping_method")  WebElement shippingMethod;
	@FindBy (xpath = "//input[@class='same_as_ship' and @type ='checkbox']")  WebElement billSameShip;
	@FindBy (xpath = "//span[@id='submit_billing' and @class='billing_ship_next']")  WebElement continue2;
	@FindBy (xpath = "//input[@type='checkbox' and @name ='checkout.agreeTerm']")  WebElement terms;
	@FindBy (xpath = "//span[@class='final_continuing']")  WebElement continue3;
	
	
	
	
	public void clickContinue(){
		//scroll into
		TestUtil.clickJS(continue1);
	}
	
	public void selectShipOptions(String value){
		TestUtil.clearAndSendKeys(deliverPhone, "98*99*100");
		
		TestUtil.selectFromDropdownByValue(driver, shippingMethod, value);
		// try and catch
		try{
			TestUtil.clearAndSendKeys(specInstrucText, testNote);
		}catch(org.openqa.selenium.StaleElementReferenceException e){
			TestUtil.clearAndSendKeys(specInstrucText, testNote);
		}
		
	}
	

	public void clickBillInfoSame(){
		
		try{
			TestUtil.clickJS(billSameShip);

		}catch(org.openqa.selenium.ElementNotVisibleException e){
			TestUtil.clickJS(billSameShip);
		}
		//scroll down
		executor = (JavascriptExecutor)driver;
		executor.executeScript("window.scrollBy(0,500)");

		TestUtil.waitForElementToClick(continue2);
		
		try{
			TestUtil.click(continue2);
		}catch(org.openqa.selenium.ElementNotVisibleException e) {
			TestUtil.isElementPresent(driver, "//span[@id='submit_billing']", 20).click();
		}
		
	}
	
	public OrderSummary clickIAcceptTermsAndCo(){
		TestUtil.clickJS(terms);
		
		TestUtil.waitForElementToClick(continue3);
		TestUtil.clickJS(continue3);
		
		return new OrderSummary();
	}
}
