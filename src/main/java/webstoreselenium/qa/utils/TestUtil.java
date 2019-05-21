package webstoreselenium.qa.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import webstoreselenium.qa.base.TestBase;

public class TestUtil extends TestBase{

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 30;
	public static int WAIT_TIME_OUT = 20;
	static WebDriverWait wait;
	static JavascriptExecutor js;
	public static String SHEET_PATH = "/Users/lexterA/workspace2/webstoreselenium/src/main/java/webstoreselenium/"
			+ "qa/testdata/AppData.xlsx"; 
	

	static Workbook book;
	static Sheet sheet;
	
	public static Object [][] getTestData(String sheetName){
		FileInputStream file = null;
		
		try{
			file = new FileInputStream(SHEET_PATH);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
		
		try{
			book = WorkbookFactory.create(file);
			
		}catch(InvalidFormatException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0; i<sheet.getLastRowNum();i++){
			for(int k=0; k < sheet.getRow(0).getLastCellNum();k++){
				data[i][k] = sheet.getRow(i+1).getCell(k).toString();
			}
		}
		
		return data;
	}
	
/*	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");

		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));

		}*/

	
	public static void click(WebElement element){
		try{
			element.click();
		}catch(NoSuchElementException e){
			System.out.println("Unable to locate element " + element);
		}
	}
	
	public static void waitForElementToClick(WebElement element){
		wait = new WebDriverWait(driver, WAIT_TIME_OUT);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static void waitTillElementFound(WebElement ElementTobeFound) {
		wait = new WebDriverWait(driver, WAIT_TIME_OUT);
		wait.until(ExpectedConditions.visibilityOf(ElementTobeFound));
	}
	
	public static void waitStaleElement(WebElement element){
		wait = new WebDriverWait(driver, WAIT_TIME_OUT);
		wait.until(ExpectedConditions.stalenessOf(element));
	}
	
	public static void waitTillTextPresent(WebElement ElementTobeFound,
			int seconds, String str){
		wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.textToBePresentInElement(ElementTobeFound, str));
	}

	public static WebElement isElementPresent(WebDriver driver, String xpath, int time){
		WebElement ele = null;
		
			for(int i=0; i< time; ){
				
				try{
					ele = driver.findElement(By.xpath(xpath));
					break;
				}catch(Exception e){
					System.out.println("Waiting for element to appear on DOM");
				}

			}
		return ele;
	}
	
	public static void clearAndSendKeys(WebElement element, String s){
		element.clear();
		element.sendKeys(s);
	}
	
	public static void pressKeyEnter(WebElement element) {
		element.sendKeys(Keys.ENTER);
	}
	
	public static boolean checkAlert_Accept() {
		try {
			Alert a = driver.switchTo().alert();
			String str = a.getText();
			System.out.println(str);

			a.accept();
			return true;

		} catch (Exception e) {

			System.out.println("no alert ");
			return false;

		}
	}

	public static void waitTillInvisible (WebElement element){
		wait = new WebDriverWait(driver, WAIT_TIME_OUT);
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	public static void scrollIntoViewJS (WebElement element){
		 js =(JavascriptExecutor)driver;
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
		 
		 
		 
	}
	
	public static void clickJS(WebElement ele){
		 js =(JavascriptExecutor)driver;
		 js.executeScript("arguments[0].click();", ele);
	}

	public static void waitTillInvisibleBy(By locator){
		wait = new WebDriverWait(driver, WAIT_TIME_OUT);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
		
	}
	
	public static void waitTilURLContains(String url){
		wait = new WebDriverWait(driver, WAIT_TIME_OUT);
		wait.until(ExpectedConditions.urlContains(url));
	}
	
	public static void moveToWebelement(WebElement MovetoWebElement){
		Actions builder = new Actions(driver);
		builder.moveToElement(MovetoWebElement).click().perform();
	}

	public static void selectFromDropdownByValue( WebDriver driver, WebElement element, String value){
		Select select = new Select (element);
		select.selectByValue(value);	
	}
	
	public static boolean retryingFindClick(String xpath) {
        boolean result = false;
        int attempts = 0;
        while(attempts < 2) {
            try {
                driver.findElement(By.xpath(xpath)).click();
                result = true;
                break;
            } catch(Exception e) {
            }
            attempts++;
        }
        return result;
	}
	
	

	
}
