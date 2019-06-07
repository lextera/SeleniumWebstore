package webstoreselenium.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webstoreselenium.qa.base.TestBase;
import webstoreselenium.qa.utils.TestUtil;

public class UpdateProfile extends TestBase{
	
	public UpdateProfile(){
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//span[contains(text(),'Add New Address')]") @CacheLookup WebElement addNewAddr;
	@FindBy(id="first_name_bill") WebElement fName;
	@FindBy(id="last_name_bill") WebElement lName;
	@FindBy(id="title_bill") WebElement title;
	@FindBy(id="company_bill") WebElement company;
	@FindBy(id="street_ad_ship") WebElement streetAdd;
	
	@FindBy(id="room_ship") WebElement room_ship;
	@FindBy(id="country_ship") WebElement country_ship; //drop down
	@FindBy(id="city_ship") WebElement city_ship;
	@FindBy(id="state") WebElement state;
	@FindBy(id="zip_ship") WebElement zip_ship;
	@FindBy(id="phone_ship") WebElement phone_ship;
	@FindBy(id="save_shipping_address") WebElement save_shipping_address;

	public String validateURL(){
		return driver.getCurrentUrl();
	}

	
	public void createNewAddress(String f_name, String l_name, String ttle, String comp, String street, String country, 
			String city, String stte, String zip, String delivPhone){
		
		TestUtil.clickJS(addNewAddr);
		
		TestUtil.clearAndSendKeys(fName, f_name);
		TestUtil.clearAndSendKeys(lName, f_name);
		TestUtil.clearAndSendKeys(title, ttle);
		TestUtil.clearAndSendKeys(company,comp);
		TestUtil.clearAndSendKeys(streetAdd,street);
		TestUtil.selectFromDropdownByValue(driver, country_ship, country); //
		TestUtil.clearAndSendKeys(city_ship,city);
		TestUtil.clearAndSendKeys(state,stte);
		TestUtil.clearAndSendKeys(zip_ship,zip);
		TestUtil.clearAndSendKeys(phone_ship,delivPhone);
		TestUtil.click(save_shipping_address);
		
		
	}
	
	
}
