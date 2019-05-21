package webstoreselenium.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webstoreselenium.qa.base.TestBase;
import webstoreselenium.qa.utils.TestUtil;

public class CheckOutTejas extends TestBase	 {
	
	public CheckOutTejas(){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[contains(text(),'Cancel Order')]") WebElement cancelOrder;
	@FindBy(id="special_instructions_ship") WebElement instructionText;
	@FindBy(id="submit_shipping") WebElement continue1;
	@FindBy(xpath="//span[@class='load_save_address']") WebElement loadSaveAddr;
	
	//export form
	@FindBy(xpath="//input[@class='order_input export_customer_name'] ") WebElement exportCustName;
	@FindBy(xpath="//input[@class='order_input export_end_user_name']") WebElement exportEndName;
	@FindBy(xpath="//input[@class='order_input export_address']") WebElement addr;
	@FindBy(xpath="//input[@class='order_input export_city']") WebElement city;
	@FindBy(xpath="//input[@class='order_input export_state']") WebElement state;
	@FindBy(xpath="//input[@class='order_input export_zip']") WebElement zip;
	@FindBy(id="mcl_country_end_user") WebElement country;
	
	@FindBy(xpath="//section[@id='mcl_end_use_declaration']//p[1]//input[@type='radio']") WebElement aButton;
	@FindBy(xpath="//input[@name='checkout.exportEndUser.agreeTerm']") WebElement iAgree;
	@FindBy(xpath="//input[contains(@name,'signature')]") WebElement signature;
	@FindBy(xpath="//input[@name='checkout.agreeTerm']") WebElement tAndC;
	@FindBy(id="submit_end_user") WebElement continue2;
	@FindBy(xpath="//span[contains(@class,'final_continuing')]") WebElement continue3;
	@FindBy(xpath="//div[@id='myModal']//span[@id='ok']") WebElement okLoadAddr;
	
	String instruction = "This is an automated test transaction from Software Team /n Pls disregard ";
		


	/*
	 * click load save shipping add
	 * modal 
	 * assert getAttr = 'bangalore'
	 * 
	 * ***/
	public void clickLoadSavedAddress(){
		TestUtil.click(loadSaveAddr);
		TestUtil.clickJS(okLoadAddr);
		//special instruc and cont1
		TestUtil.clearAndSendKeys(instructionText, instruction);
		TestUtil.click(continue1);
	}
	
	//end user form --signature -iAgree- continue2
	public void enterEndUserForm(){
		
	}
	

}
