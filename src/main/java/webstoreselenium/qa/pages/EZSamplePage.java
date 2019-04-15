package webstoreselenium.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webstoreselenium.qa.base.TestBase;
import webstoreselenium.qa.utils.TestUtil;

public class EZSamplePage extends TestBase {

	public EZSamplePage(){
		PageFactory.initElements(driver, this);
		
	}
	
	
	String freQTo= "100";
	String freQFrom= "150";
	String objective = "Automated Test. Pls disregard";
	String date = "12/12/2020";
	
	
	
	
	@FindBy (id = "projectName") private WebElement projectName;
	@FindBy (id = "title_ship") private WebElement fromRange;
	@FindBy (id = "company_ship") private WebElement toRange;
	@FindBy (id = "objective") private WebElement objct;
	@FindBy (id = "nextStep") private WebElement nextStep;
	@FindBy (id = "potentialQuestion2") private WebElement potentialQuestion2;
	@FindBy (id = "applicationDescription") private WebElement applicationDescription;
	@FindBy (id = "timing") private WebElement timing;
	@FindBy (id = "submit_question") private WebElement submit_question;
	
	public EZsamplecheckout enterRequireField(){
		TestUtil.clearAndSendKeys(projectName, objective);
		TestUtil.clearAndSendKeys(fromRange, freQTo);
		TestUtil.clearAndSendKeys(toRange, freQFrom); 
		TestUtil.clearAndSendKeys(objct, objective);
		TestUtil.clearAndSendKeys(nextStep, objective);
		TestUtil.clearAndSendKeys(potentialQuestion2, objective);
		TestUtil.clearAndSendKeys(applicationDescription, objective);
	
		timing.sendKeys(date);
		//TestUtil.clearAndSendKeys(timing, date);
		TestUtil.click(submit_question);
		
		return new EZsamplecheckout();
		
		
	}
	
}

