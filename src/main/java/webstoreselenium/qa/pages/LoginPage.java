package webstoreselenium.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webstoreselenium.qa.base.TestBase;
import webstoreselenium.qa.utils.TestUtil;

public class LoginPage extends TestBase {
	
	@FindBy(id= "login_name") WebElement uname;
	@FindBy(id= "account_password") WebElement pswd; 
	@FindBy(id= "login") WebElement sigIn;
	@FindBy(id= "ok") WebElement ok;
	@FindBy(xpath= "//div[@class='modal-content']/div[2]") public WebElement popUp;
	String textPopUp;
	

	public LoginPage(){
		
		PageFactory.initElements(driver, this);
	}
	
	public IndexPage clickLogin(String username, String passwd){
		TestUtil.clearAndSendKeys(uname, username);
		TestUtil.clearAndSendKeys(pswd, passwd);
		TestUtil.click(sigIn);
		return new IndexPage();
		
	}
	
	public String getLoginUrl(){
		return driver.getCurrentUrl();
	}
	
	public String enterIncorrectLogin(String inval1, String inval2){		
		TestUtil.clearAndSendKeys(uname, inval1);
		TestUtil.clearAndSendKeys(pswd, inval2);
		TestUtil.click(sigIn);
		TestUtil.waitTillElementFound(popUp);
		TestUtil.waitTillTextPresent(popUp, 10, "Invalid login name.");
		textPopUp = popUp.getText();	
		TestUtil.click(ok);
		return textPopUp;

	}
	
}
