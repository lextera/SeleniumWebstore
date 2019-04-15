package webstoreselenium.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import webstoreselenium.qa.base.TestBase;
import webstoreselenium.qa.utils.TestUtil;

public class Quote extends TestBase{
	WebDriverWait wait;

	public Quote(){
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="submit_shipping") WebElement continueButton;
	@FindBy(xpath="//span[contains(text(),'Produce Quote')]") WebElement produceQuote;
	@FindBy (xpath = "//input[@type='checkbox' and @name='quote.agreeTerm']")  WebElement iAccept;
	@FindBy(id="myModal") WebElement modalWindow;
	By loadWindow = By.id("myModal");
	
	public QuoteConfirmPage produceQuote(){		
		TestUtil.click(continueButton);
		TestUtil.scrollIntoViewJS(iAccept);
		try{
			TestUtil.click(iAccept);
			// this is updated, delete if not working
			//TestUtil.retryingFindClick("//input[@type='checkbox' and @name='quote.agreeTerm']");
		}catch(org.openqa.selenium.ElementNotVisibleException e){
			//updated from 10 to 20 sec
			TestUtil.isElementPresent(driver, "//input[@type='checkbox' and @name='quote.agreeTerm']", 20);
		}
		// put a wait 
		TestUtil.waitTillElementFound(iAccept);
		TestUtil.clickJS(produceQuote);
		
		
		//TestUtil.waitTillInvisibleBy(loadWindow);
		//wait til url is found
		TestUtil.waitTilURLContains("quoteorderconfirmation.html?oid");
		


		return new QuoteConfirmPage();
	}
}
