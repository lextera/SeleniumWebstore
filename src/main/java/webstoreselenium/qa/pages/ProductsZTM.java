package webstoreselenium.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webstoreselenium.qa.base.TestBase;
import webstoreselenium.qa.utils.TestUtil;

public class ProductsZTM extends TestBase {

	public ProductsZTM(){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="	//img[contains(@src,'ztm/ZTM-Series')]") WebElement ztmSeries;
	//
	
	public WebStoreZTM clickZTMseries(){
		TestUtil.click(ztmSeries);
		return new WebStoreZTM();
	}
}
