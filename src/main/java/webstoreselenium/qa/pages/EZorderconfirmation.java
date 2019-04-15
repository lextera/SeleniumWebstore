package webstoreselenium.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webstoreselenium.qa.base.TestBase;

public class EZorderconfirmation extends TestBase {

	public EZorderconfirmation(){
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy (xpath = "//span[@style='font-weight: bold']") private WebElement ezOrderNum;
	@FindBy (xpath = "//a[contains(@href, 'dashboard.html?model')]") private WebElement ezOrderModel;
	
	public boolean isOrderNumberSame( String ezOrder){
		return ezOrderNum.getText().equals(ezOrder);
		
	}
	
	public boolean isModelSame(String model){
		return ezOrderModel.getText().equals(model);
		
	}
	
}
