package webstoreselenium.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import webstoreselenium.qa.pages.WebMail;
import webstoreselenium.qa.utils.TestUtil;
import webstoreselenium.qa.utils.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	WebMail webmail;
	
	@FindBy(xpath="//p[contains(text(),'Hello. Sign in')]")
	@CacheLookup protected WebElement homeSignIn;
	@FindBy(xpath = "//a[text()='Sign in']") 
	@CacheLookup protected WebElement signIn;
	@FindBy(xpath="//input[@name='model' and @value='Model No. Search']") protected WebElement modelSearchTextBox;
	@FindBy (xpath = "//form[@id='model_search_function']//i") protected  WebElement modelSearchIcon;
	@FindBy(xpath="//div[@id='cp_popup']//img") protected WebElement  cookieId;
	
	@FindBy (id = "username") @CacheLookup private WebElement userName;
	
	@FindBy (id = "password") @CacheLookup  private WebElement password;
	@FindBy (xpath = "//div[@id='lgnDiv']//span[text()='sign in']") @CacheLookup private WebElement signInWeb;
	@FindBy (xpath = "//a[@href='/WebStore/updateProfile.html']") public WebElement updateProfile;
	@FindBy(xpath= "//p[contains(text(),'Your Account')]") public WebElement urAccount;
	@FindBy(xpath= "//a[contains(text(),'Products')]") public WebElement product;
	


	public TestBase(){
		/**
		 * 	read the config file
		 * . means current dir, home
		 * 
		 * "/Users/lexterA/workspace2/webstoreselenium/src/main/java/webstoreselenium/qa/config/config.properties"
		 * */
		
		
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
	
	public void initialize(){
		//initialize browser
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}
	
	public void loginWebMail(){
		driver.get(prop.getProperty("webMail"));
		//webmail.login();
		TestUtil.clearAndSendKeys(userName, prop.getProperty("username"));
		TestUtil.clearAndSendKeys(password, prop.getProperty("webmailpwd"));
		TestUtil.click(signInWeb);
	}
	
	public void navigateToWebMail(){
		driver.navigate().to(prop.getProperty("webMail"));
		
	}
	

}
