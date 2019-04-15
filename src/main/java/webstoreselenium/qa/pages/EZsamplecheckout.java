package webstoreselenium.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webstoreselenium.qa.base.TestBase;
import webstoreselenium.qa.utils.TestUtil;

public class EZsamplecheckout extends TestBase{
	/*
	 * pre -condition:
	 *  delete data in backend
	 *  
		delete from WEBORDER where order_type = 'S' and email = 'lextera@minicircuits.com'
	 * 
	 * ***/
	public EZsamplecheckout(){
		PageFactory.initElements(driver, this);
	}

	//https://www1.minicircuits.com/WebStore/ezsamplecheckout.html
	String notes = "Automated Test. Please disregard";
	@FindBy (id = "submit_shipping") private WebElement submit_shipping;
	@FindBy (id = "special_instructions_ship") private WebElement specialNotes;
	@FindBy (id = "phone_ship") private WebElement phone_ship;
	@FindBy (xpath = "//input[@type='checkbox' and @name='ezsamplecheckout.agreeTerm']") private WebElement iAccept;
	@FindBy (xpath = "//span[@class='final_continuing']") private WebElement submitFinal;
	@FindBy (xpath = "//span[@class='load_save_address']") private WebElement loadShipAddr;
	@FindBy (xpath = "//div[@class='modal-content']") private WebElement myModal;
	@FindBy (id = "ok") private WebElement ok;
	
	public void enterRequiredFields(){
		
	}
	
	public void loadSaveAddress(){
		TestUtil.click(loadShipAddr);
		//wait till element found
		TestUtil.waitTillElementFound(ok);
		TestUtil.click(ok);
	}
	
	public void clickContinue(){
		TestUtil.clearAndSendKeys(phone_ship, "98**99**");
		TestUtil.clearAndSendKeys(specialNotes, notes);
		TestUtil.clickJS(submit_shipping);
	}
	


	public EZorderconfirmation acceptAndSubmit() {
		try{
			TestUtil.clickJS(iAccept);
		}catch(org.openqa.selenium.ElementNotVisibleException e){
			TestUtil.waitTillElementFound(iAccept);
		}

		TestUtil.clickJS(submitFinal);
		TestUtil.waitTilURLContains("ezorderconfirmation.html?oid");
		return new EZorderconfirmation();
	}
}
