package webstoreselenium.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webstoreselenium.qa.base.TestBase;
import webstoreselenium.qa.utils.TestUtil;

public class WebMail extends TestBase {

	public WebMail(){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (id = "username") private WebElement userName;
	@FindBy (id = "password") private WebElement password;
	@FindBy (xpath = "//div[@id='lgnDiv']//span[text()='sign in']") private WebElement signIn;
	
	
	
	public WebInbox login(String username, String passwd){
		TestUtil.clearAndSendKeys(userName, username);
		TestUtil.clearAndSendKeys(password, passwd);
		TestUtil.click(signIn);
		return new WebInbox();
	}
	
	
}
