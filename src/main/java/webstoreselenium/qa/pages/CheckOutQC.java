package webstoreselenium.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webstoreselenium.qa.base.TestBase;
import webstoreselenium.qa.utils.TestUtil;

public class CheckOutQC extends TestBase{
	JavascriptExecutor executor;
	String testNote = "This is an automated test transaction \n "
			+ "\"Convert Quote to Order\" \n Pls disregard";

	public CheckOutQC(){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (id = "special_instructions_ship")  WebElement specInstrucText; 
	@FindBy (id = "phone_ship")  WebElement phone;
	@FindBy (id = "shipping_method")  WebElement shipMethod;
	@FindBy (id = "submit_shipping")  WebElement continue1;
	@FindBy (id = "submit_billing")  WebElement continue2;
	@FindBy (xpath = "//input[@type='checkbox' and @name ='qc.agreeTerm']")  WebElement iAgree;

	
	@FindBy (xpath = "//span[@class='final_continuing']")  WebElement continue3;
	@FindBy (xpath = "//input[@class='same_as_ship' and @type ='checkbox']")  WebElement billSameShip;
	
	public void selectShipMethod(){
		TestUtil.clearAndSendKeys(phone, "98--99--100");
		TestUtil.selectFromDropdownByValue(driver, shipMethod, "29");

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TestUtil.clearAndSendKeys(specInstrucText, testNote);
		TestUtil.waitTillElementFound(continue1);
		TestUtil.click(continue1);
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
	
	public OrderSummaryQC clickIAcceptTermsAndCo(){

		
		TestUtil.waitTillElementFound(iAgree);
		//TestUtil.scrollIntoViewJS(iAgree);
		try{
			TestUtil.click(iAgree);	
		}catch(org.openqa.selenium.ElementNotVisibleException e){
			TestUtil.retryingFindClick("//input[@type='checkbox' and @name ='qc.agreeTerm']");
			TestUtil.click(iAgree);	
		}
		
		
		TestUtil.waitForElementToClick(continue3);
		TestUtil.clickJS(continue3);
		
		return new OrderSummaryQC();
	}
	
	
}
