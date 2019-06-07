package webstoreselenium.qa.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webstoreselenium.qa.base.TestBase;
import webstoreselenium.qa.utils.TestUtil;

public class PayTracePage extends TestBase {

	public PayTracePage(){
		PageFactory.initElements(driver, this);
	File src = new File("/Users/lexterA/workspace2/webstoreselenium/src/main/java/webstoreselenium/qa/config/config.properties");
		
		try{
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
						
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	@FindBy(xpath= "//input[@name='CC']") public WebElement ccNum;
	@FindBy(id= "EXPMNTH") public WebElement exMonth;
	@FindBy(id= "EXPYR") public WebElement exYear;
	@FindBy(xpath= "//input[@name='CSC']") public WebElement csc;
	
	@FindBy(xpath= "//input[@value = 'Process Transaction' and @name = 'cmdBILL']") public WebElement processTxn;
	
	public static Properties prop;
	
	
	public void enterCardDetails(){
		
		String cc = prop.getProperty("ccnum");
		TestUtil.clearAndSendKeys(ccNum, cc);
		
		TestUtil.selectFromDropdownByValue(driver, exMonth, prop.getProperty("exmonth"));
		TestUtil.selectFromDropdownByValue(driver, exYear, prop.getProperty("exyear"));
		TestUtil.clearAndSendKeys(csc, prop.getProperty("csc"));
		TestUtil.click(processTxn);
		TestUtil.checkAlert_Accept();
		
		
	}
}
