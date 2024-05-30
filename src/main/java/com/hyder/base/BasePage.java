package com.hyder.base;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.relevantcodes.extentreports.LogStatus;
import com.hyder.utils.Config;
import com.hyder.utils.Constants;
import com.hyder.utils.Log;
import com.hyder.utils.Reports;


public class BasePage {
	public WebDriver driver;
	private static final int pageElementLoadWait = 30;
	private static final int pageTimeOutWait = 20;
	public Reports report = new Reports();
	public static HashMap<WebElement, String> elementDetails = new HashMap<WebElement, String>();
	
	public BasePage(WebDriver driver) throws Exception {
	    this.driver = driver;
	    
		if(driver==null){
			driver = getDriver();	
		}

		//Initialize Page Factory. Passing child object
		PageFactory.initElements(driver, this);
		Log.info("Page Factory initialized");
	}


	public WebDriver getDriver() throws Exception{
		String browser = Config.getProp().getProperty("selenium.browser");

		if(browser.equals("SAFARI")){

			System.setProperty("webdriver.safari.driver", 
					Config.getProp().getProperty("webdriver.safari.driver"));
			driver = new SafariDriver();
			driver.manage().window().maximize();
		}

		else if(browser.equals("FIREFOX")){
			System.setProperty("webdriver.gecko.driver", 
					Config.getProp().getProperty("webdriver.firefox.driver"));
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(pageTimeOutWait, TimeUnit.SECONDS);
		}

		else if(browser.equals("CHROME")){
			System.setProperty("webdriver.chrome.driver", 
					Config.getProp().getProperty("webdriver.chrome.driver"));
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			options.addArguments("--disable-web-security");
			options.addArguments("--no-proxy-server");
			Map<String, Object> prefs = new HashMap<String, Object>();

			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			options.setExperimentalOption("prefs", prefs);

			//DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			//capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			//driver = new ChromeDriver(capabilities);

			driver = new ChromeDriver(options);
			driver.manage().timeouts().implicitlyWait(pageTimeOutWait, TimeUnit.SECONDS);
			//driver.manage().window().maximize();
		}

		//Setting page load time out
		driver.manage().timeouts().pageLoadTimeout(pageTimeOutWait, TimeUnit.SECONDS);
		return driver;
	}

	// Wait for Element to be clickable
	public WebElement waitForElement(WebElement element) {
		try{
			WebDriverWait wait = new WebDriverWait(driver, pageElementLoadWait);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			Log.info("Wait for element "+ elementDetails.get(element));
			
			return element;

		}catch(Exception e){

		}
		return null;
	}

	// Navigate to URL
	public void navigateToURL(String siteURL) throws IOException {
		driver.navigate().to(siteURL);
		report.logStatus(LogStatus.PASS, "OpenBrowser: " 
		+ Config.getProp().getProperty("selenium.browser") + "," 
		+ siteURL,"Passed");
		Log.info("Demo URL Launched");
	}

	// Take a screenshot
	public void takeScreenShot(String fileName) {
		try {
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File(Constants.sScreenshotFilepath +
					fileName + ".png"));
			Log.info("Screenshot captured");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Log.info("Screenshot exception");
		}
	}

	// End Extent Reporting
	public void endReport() {
		report.endTest();
	}

	// End a Test
	public void endTest() {
		driver.close();
		driver.quit();
	}
	
	//Click Element method.
	//This method will log in Extent Report as well in Log4j.
	public boolean clickElement(WebElement element) {

		try {
			element = waitForElement(element);

			if (element != null) {
				takeScreenShot(elementDetails.get(element));
				report.logStatus(LogStatus.PASS, "Click",
						"Click " + elementDetails.get(element) 
						+ " <span class='label success'>Success</span>");
				report.screenshotLog(LogStatus.PASS, "Click Success " + elementDetails.get(element),
						Constants.sScreenshotFilepath + elementDetails.get(element) + ".png");

				Log.info("Element Clicked: "+elementDetails.get(element));
				element.click();
				return true;
			}

			else
 			throw new NoSuchElementException("Element not found");
		} catch (Exception e) {
			takeScreenShot("Fail_" + Constants.dateTag);

			report.screenshotLog(LogStatus.FAIL, "Click Failed ",
					Constants.sScreenshotFilepath + "Fail_" + Constants.dateTag + ".png");

			Log.info("Element Click Exception");
			report.endTest();
			throw new NoSuchElementException("Element not found");
		}
	}

	//Enter text in text box method.
	//This method will log in Extent Report as well in Log4j.
	public boolean EnterText(WebElement element, String input) {
		try {
			element = waitForElement(element);
			if (element != null) {
				element.sendKeys(input);
				report.logStatus(LogStatus.PASS, "Enter Text",

					"Enter Text into " + elementDetails.get(element) 
					+ " <span class='label success'>Success</span>");
								Log.info("Enter text: " + elementDetails.get(element));
				return true;
			}else
				throw new NoSuchElementException("Element not found");
		} catch (Exception e) {

			takeScreenShot("Fail_" + Constants.dateTag);
			report.screenshotLog(LogStatus.FAIL, "Enter Text",
					Constants.sScreenshotFilepath + "Fail_" + Constants.dateTag + ".png");
			Log.info("Enter text Exception");

			throw new NoSuchElementException("Element not found");
		}	
	}
	//Select a value from drop down by text method.
	//This method will log in Extent Report as well in Log4j.*/
	public boolean SelectElementByText(WebElement element, String input) {
		try {
			element = waitForElement(element);
			if (element != null) {
				Select dropdown = new Select(element);
				dropdown.selectByVisibleText(input);
				report.logStatus(LogStatus.PASS, "Select Element", "Select Element For " 
				+ elementDetails.get(element)
						+ " <span class='label success'>Success</span>");
				Log.info("Select element: " + elementDetails.get(element));
				return true;
			}else
				throw new NoSuchElementException("Element not found");

		} catch (Exception e) {
			takeScreenShot("Fail_" + Constants.dateTag);
			report.screenshotLog(LogStatus.FAIL, "Select Element",
					Constants.sScreenshotFilepath + "Fail_" + Constants.dateTag + ".png");
			Log.info("Select element Exception ");
			throw new NoSuchElementException("Element not found");
		}
	}
}
