package webstoreselenium.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webstoreselenium.qa.base.TestBase;
import webstoreselenium.qa.utils.TestUtil;

public class CheckOut extends TestBase {
	JavascriptExecutor executor;
	String testNote = "This is an automated test transaction from Software Team \n Pls disregard";
	String email = "lex_acosta@yahoo.com";

	
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
	@FindBy (xpath = "//span[@class='ship_from_to']")  WebElement shipFrom;
	
	@FindBy (xpath = "//div[@class='modal-content']//span[@id='save']")  WebElement okShipFrom;
	@FindBy (id = "tCountry")  WebElement selectCountry;
	@FindBy(xpath="//span[@class='load_save_address']") WebElement loadSaveAddr;
	@FindBy(xpath="//div[@id='myModal']//span[@id='ok']") WebElement okLoadAddr;
	// for guest user
	@FindBy (id = "first_name_ship")  WebElement fname;
	@FindBy (id = "last_name_ship")  WebElement lname;
	@FindBy (id = "street_ad_ship")  WebElement streeAdd;
	@FindBy (id = "city_ship")  WebElement city;
	@FindBy (id = "state_ship")  WebElement state;
	@FindBy (xpath = "//input[@id='zip_ship' and @class='order_input zip']")  WebElement zip;
	@FindBy(xpath="//select[@id='shipping_method']/option[3]") WebElement courier;
	@FindBy (id = "email_address_bill")  WebElement emailBilling;
	
	
	
	
	
	public void clickContinue(){
		//scroll into
		try{
			TestUtil.click(continue1);
		}catch(org.openqa.selenium.StaleElementReferenceException e){
			TestUtil.clickJS(continue1);	
		}
		
	}
	
	public void selectShipOptions(String value){
		TestUtil.clearAndSendKeys(deliverPhone, "98*99*100");
		
		TestUtil.waitTillElementFound(shippingMethod);
		
		TestUtil.selectFromDropdownByValue(driver, shippingMethod, value);
	

		try{
			TestUtil.clearAndSendKeys(specInstrucText, testNote);
		}catch(org.openqa.selenium.StaleElementReferenceException e){
			TestUtil.clearAndSendKeys(specInstrucText, testNote);
		}
		
	}
	
	public void enterNameAndAddress(String first, String last, String streetAdd, String cty, String stte, 
			String zp, String phone){
		TestUtil.clearAndSendKeys(fname, first);
		TestUtil.clearAndSendKeys(lname, last);
		TestUtil.clearAndSendKeys(streeAdd, streetAdd);
		TestUtil.clearAndSendKeys(city, cty);
	
		TestUtil.clearAndSendKeys(deliverPhone, phone);
		TestUtil.selectFromDropdownByValue(driver, state, stte); //selecting NY
		TestUtil.clearAndSendKeys(zip, zp);
	
		TestUtil.scrollIntoViewJS(shippingMethod);
		//TestUtil.click(shippingMethod);
		TestUtil.moveToWebelement(shipFrom);
		TestUtil.click(courier);
	
		
		
	}
	
	public void billInforForGuest(){
		try{
			TestUtil.clickJS(billSameShip);

		}catch(org.openqa.selenium.ElementNotVisibleException e){
			TestUtil.clickJS(billSameShip);
		}
		TestUtil.waitTillElementFound(emailBilling);
		
		
		try{
			TestUtil.clearAndSendKeys(emailBilling, email);
		}catch(org.openqa.selenium.StaleElementReferenceException e){
			//TestUtil.retryingFindClick("//input[@id='email_address_bill' and @name='checkout.email']");
			TestUtil.clearAndSendKeys(emailBilling, email);
		}
		TestUtil.click(continue2);
		
	}
	

	public void clickBillInfoSame(){
		
		try{
			TestUtil.clickJS(billSameShip);

		}catch(org.openqa.selenium.ElementNotVisibleException e){
			TestUtil.clickJS(billSameShip);
		}
		//scroll down
		executor = (JavascriptExecutor)driver;
		executor.executeScript("window.scrollBy(0,400)");

		TestUtil.waitForElementToClick(continue2);
		
		try{
			TestUtil.click(continue2);
		}catch(org.openqa.selenium.ElementNotVisibleException e) {
			TestUtil.isElementPresent(driver, "//span[@id='submit_billing']", 20).click();
		}
		
	}
	
	
	public OrderSummary clickIAcceptTermsAndCo(){
		//scroll into or scrollby Up
		TestUtil.scrollIntoViewJS(terms);
		TestUtil.clickJS(terms);
		
		TestUtil.waitForElementToClick(continue3);
		TestUtil.clickJS(continue3);
		
		return new OrderSummary();
	}
	
	public void selectShipFromCountry(){
		TestUtil.click(shipFrom); // pops up
		TestUtil.selectFromDropdownByValue(driver, selectCountry, "IN"); // select india
		//thread.sleep
		TestUtil.waitTillElementFound(okShipFrom);

		try{	

			TestUtil.clickJS(okShipFrom);
		}catch(org.openqa.selenium.StaleElementReferenceException e){
			//another catch
			try{
				TestUtil.retryingFindClick("//div[@class='modal-content']//span[@id='save']");
				TestUtil.clickJS(okShipFrom);
			}catch(org.openqa.selenium.StaleElementReferenceException f){
				TestUtil.retryingFindClick("//div[@class='modal-content']//span[@id='save']");
				TestUtil.clickJS(okShipFrom);
			}

		}

	}
	
	public void clickLoadSavedAddr(){

		try{
			TestUtil.clickJS(loadSaveAddr);
		}catch(org.openqa.selenium.StaleElementReferenceException e){
			TestUtil.clickJS(loadSaveAddr);
		}
		
		//another try catch
		TestUtil.waitTillElementFound(okLoadAddr);
		TestUtil.click(okLoadAddr);

		// theard.sleep if no choice
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
/*		executor = (JavascriptExecutor) driver;
		executor.executeScript("scroll(0, 400);");*/
		TestUtil.scrollIntoViewJS(specInstrucText);
		TestUtil.waitTillElementFound(continue1);
		TestUtil.clearAndSendKeys(specInstrucText, testNote);
		TestUtil.click(continue1);
		
	} 
}
