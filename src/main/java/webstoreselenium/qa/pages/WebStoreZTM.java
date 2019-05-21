package webstoreselenium.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webstoreselenium.qa.base.TestBase;
import webstoreselenium.qa.utils.TestUtil;

public class WebStoreZTM extends TestBase{
	
	@FindBy(xpath= "//img[@src ='../images/rack_mount_images/ZTM_Tile.png']") public WebElement ztm;
	@FindBy(xpath= "//input[@id ='len_size' and @value = 'Window 1']") public WebElement window1;
	@FindBy(xpath= "//input[@id ='len_size' and @value = 'Window 2']") public WebElement window2;
	@FindBy(xpath= "//input[@id ='len_size' and @value = 'Window 3']") public WebElement window3;
	@FindBy(xpath= "//input[@id ='len_size' and @value = 'Window 4']") public WebElement window4;
	@FindBy(xpath= "//input[@id ='len_size' and @value = 'Window 5']") public WebElement window5;
	@FindBy(xpath= "//input[@id ='len_size' and @value = 'Window 6']") public WebElement window6;
	@FindBy(xpath= "//img[@src='ztm/images/build.jpg']") public WebElement build1;
	@FindBy(id= "build_system") public WebElement build2;
	
	@FindBy(xpath= "//li[@class='win1']//span[text()='Programmable Attenuators']") public WebElement w1ProgAtten;
	@FindBy(xpath= "//li[@class='win1']//span[(text()='Two Attenuator: 120 and 120 dB')]") public WebElement w1TwoAtten;
	
	//input[contains(@name,'atsOrderRequest.name')]
	@FindBy(xpath= "//input[contains(@name,'atsOrderRequest.name')]") public WebElement name;
	@FindBy(xpath= "//input[contains(@name,'companyName')]") public WebElement company;
	@FindBy(xpath= "//input[contains(@name,'phone')]") public WebElement phone;
	@FindBy(xpath= "//input[contains(@name,'quantity')]") public WebElement qty;
	@FindBy(xpath= "//input[contains(@name,'email')]") public WebElement email;
	
	@FindBy(xpath= "//input[contains(@name,'email')]") public WebElement contentWindow;
	@FindBy(xpath= "//section[@id='ztm_quote_request']//table[@id='table_data']/tbody/tr[2]/td[2]") public WebElement contentSubType;
	

	
	public WebStoreZTM(){
		PageFactory.initElements(driver, this);
	}
	
	// select window
	public void selectConfig(){
		TestUtil.moveToWebelement(window1);
		TestUtil.moveToWebelement(w1ProgAtten);
		TestUtil.moveToWebelement(w1TwoAtten);
		TestUtil.click(build1);
	}
	
	public void enterContactDetails(){
		TestUtil.clearAndSendKeys(name, "Test Automation");
		TestUtil.clearAndSendKeys(company, "Test Automation");
		TestUtil.clearAndSendKeys(phone, "98**99*");
		TestUtil.clearAndSendKeys(qty, "3");
		TestUtil.clearAndSendKeys(email, "test@mcl.com");
		TestUtil.click(build2);
	}
	
	
	
	public boolean isConfigDisplayedCorrect(){
		String expected = contentSubType.getText();
		System.out.println("--------------------->>>" +expected);
		return expected.equals("Two Attenuators: 120 and 120 dB");
		  
	}
	
	
}
