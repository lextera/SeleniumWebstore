package webstoreselenium.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import webstoreselenium.qa.base.TestBase;
import webstoreselenium.qa.utils.TestUtil;

public class Cart extends TestBase {
	WebDriverWait wait;
	public Cart(){
		PageFactory.initElements(driver, this);
	}
	

	@FindBy (linkText = "Convert To Quote") private WebElement toQuote;
	@FindBy (linkText = "Shipping From/To Options") private WebElement changeShipCountry;
	//@FindBy (xpath = "//a[text()='Shipping From/To Options']") private WebElement changeShipping;
	@FindBy (id = "tCountry")  WebElement toCountry;
	@FindBy (id = "fCountry")  WebElement fromCountry;
	//@FindBy (id = "save")  WebElement okPopUp;
	
	@FindBy (xpath = "//span[@id='save' and contains(text(),OK)]") private WebElement okPopUp;
	
	@FindBy (id = "checkout_button")  WebElement checkOut;
	@FindBy (id = "shopping_cart_items")  WebElement contShop;
	
	
	
	
	public Quote clickConvertToQuote(){
		//JSScrollIntoView
		try{
			TestUtil.isElementPresent(driver, "//a[text()='Convert To Quote']", 20).click(); // PROBLEM HERE
		}catch(org.openqa.selenium.StaleElementReferenceException e){
			TestUtil.click(toQuote);
		}
		
	
		return new Quote();
	}
	
	public void changeShipCountry(String value){
		TestUtil.click(changeShipCountry);
		Select country = new Select(toCountry);
		country.selectByValue(value);
		wait = new WebDriverWait(driver, 10);
		try{
		wait.until(ExpectedConditions.visibilityOf(okPopUp));
		
			TestUtil.isElementPresent(driver, "//span[@id='save' and contains(text(),OK)]", 20).click();
		}catch(org.openqa.selenium.StaleElementReferenceException e){
			TestUtil.click(okPopUp);
		}
		
	
		
	}
	
	public CheckOut checkOutNow(){
		TestUtil.click(checkOut);
		return new CheckOut();
	}
	
	public IndexPage continueShopping(){
		return new IndexPage();
	}
	
	
	/**
	 * 
	 * continue shopping
	 * 
	 * */
}
