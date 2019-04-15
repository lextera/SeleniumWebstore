package webstoreselenium.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import webstoreselenium.qa.base.TestBase;
import webstoreselenium.qa.utils.TestUtil;

public class HomePage extends TestBase {

	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath= "//p[contains(text(),'Your Account')]") public WebElement urAccount;
	
	public UpdateProfile updateProfile(){
		TestUtil.click(urAccount);
		TestUtil.click(updateProfile);
		return new UpdateProfile();
	}

}
