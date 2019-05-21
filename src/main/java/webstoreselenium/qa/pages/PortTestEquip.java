package webstoreselenium.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webstoreselenium.qa.base.TestBase;
import webstoreselenium.qa.utils.TestUtil;

public class PortTestEquip extends TestBase {
	
	@FindBy(xpath= "//span[@class='product_two_line']") public WebElement rackMounted;
	
	@FindBy(xpath="	//img[contains(@src,'rack_mount_images/ZTM_Tile')]") WebElement ztmSeries;
	


	public PortTestEquip() {
		PageFactory.initElements(driver, this);
	}
	
	public WebStoreZTM clickRackMountTab(){
		return new WebStoreZTM();
	}
	
	public ProductsZTM clickZTMseries(){
		TestUtil.click(ztmSeries);
		return new ProductsZTM();
	}
	public String getLoginUrl(){
		return driver.getCurrentUrl();
		//https://www1.minicircuits.com/WebStore/PortableTestEquipment.html
	}


	
}
