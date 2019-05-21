package webstoreselenium.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webstoreselenium.qa.base.TestBase;
import webstoreselenium.qa.utils.TestUtil;

public class IndexPage extends TestBase {

	//initialize page objects
	public IndexPage(){
		/**
		 * driver inherited from TestBase
		 *  this -> refers to current instance, class
		 * */
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//label[contains(text(),'RF Test Solutions')]") WebElement rfTestSol;
	
	//actions
	public String validatePageTitle(){
		return driver.getTitle();
	}
	
	public LoginPage signIn() {
		TestUtil.click(homeSignIn);
		
		//TestUtil.waitTillElementFound(signIn);
		try{
			TestUtil.clickJS(signIn);	
		}catch(org.openqa.selenium.StaleElementReferenceException ex){
			TestUtil.isElementPresent(driver, "//a[text()='Sign in']", 10);
			TestUtil.click(signIn);
		}
		
		

		

		return new LoginPage();
	}
	
	public DashBoard searchModel(String model){
		//TestUtil.waitTillElementFound(blockHeader, 30);
		cookieId.click();
		modelSearchTextBox.sendKeys(model);
		//TestUtil.waitTillElementFound(modelSearchIcon, 10);
		modelSearchIcon.click();

		
		
		return new DashBoard();
	}
	
	
	
	public UpdateProfile updateProfile(){
		// 
		TestUtil.waitForElementToClick(urAccount);
		TestUtil.click(urAccount);
		//wait
		TestUtil.waitTillElementFound(updateProfile);
		TestUtil.click(updateProfile);
		return new UpdateProfile();
	}
	
	public PortTestEquip clickRFTestSolutions(){
		TestUtil.click(rfTestSol);
		return new PortTestEquip();
	}
	
	
	
	
	

}
