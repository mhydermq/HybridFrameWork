package com.hyder.base;

import java.io.File;
<<<<<<< HEAD
=======
import java.io.IOException;
>>>>>>> cda4c41 (HybridFrameWork)
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
	
<<<<<<< HEAD
	public BasePage(WebDriver driver){
=======
	public BasePage(WebDriver driver) throws Exception {
>>>>>>> cda4c41 (HybridFrameWork)
	    this.driver = driver;
	    
		if(driver==null){
			driver = getDriver();	
		}

		//Initialize Page Factory. Passing child object
		PageFactory.initElements(driver, this);
		Log.info("Page Factory initialized");
	}

<<<<<<< HEAD
	public WebDriver getDriver(){
=======
	public WebDriver getDriver() throws Exception{
>>>>>>> cda4c41 (HybridFrameWork)

		String browser = Config.getProp().getProperty("selenium.browser");

		if(browser.equals("SAFARI")){
<<<<<<< HEAD
			System.setProperty("webdriver.safari.driver", Config.getProp().getProperty("webdriver.safari.driver"));
=======
			System.setProperty("webdriver.safari.driver", 
					Config.getProp().getProperty("webdriver.safari.driver"));
>>>>>>> cda4c41 (HybridFrameWork)

			driver = new SafariDriver();
			driver.manage().window().maximize();
		}

		else if(browser.equals("FIREFOX")){
<<<<<<< HEAD
			System.setProperty("webdriver.gecko.driver", Config.getProp().getProperty("webdriver.firefox.driver"));
=======
			System.setProperty("webdriver.gecko.driver", 
					Config.getProp().getProperty("webdriver.firefox.driver"));
>>>>>>> cda4c41 (HybridFrameWork)

			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(pageTimeOutWait, TimeUnit.SECONDS);
		}

		else if(browser.equals("CHROME")){
<<<<<<< HEAD
			System.setProperty("webdriver.chrome.driver", Config.getProp().getProperty("webdriver.chrome.driver"));
=======
			System.setProperty("webdriver.chrome.driver", 
					Config.getProp().getProperty("webdriver.chrome.driver"));
>>>>>>> cda4c41 (HybridFrameWork)

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
<<<<<<< HEAD

=======
>>>>>>> cda4c41 (HybridFrameWork)
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
<<<<<<< HEAD
	public void navigateToURL(String siteURL) {
		driver.navigate().to(siteURL);
		report.logStatus(LogStatus.PASS, "OpenBrowser: " + Config.getProp().getProperty("selenium.browser") + "," 
=======
	public void navigateToURL(String siteURL) throws IOException {
		driver.navigate().to(siteURL);
		report.logStatus(LogStatus.PASS, "OpenBrowser: " 
		+ Config.getProp().getProperty("selenium.browser") + "," 
>>>>>>> cda4c41 (HybridFrameWork)
		+ siteURL,"Passed");
		Log.info("Demo URL Launched");
	}

	// Take a screenshot
	public void takeScreenShot(String fileName) {
		try {
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
<<<<<<< HEAD
			FileUtils.copyFile(screenshot, new File(Constants.sScreenshotFilepath + fileName + ".png"));
=======
			FileUtils.copyFile(screenshot, new File(Constants.sScreenshotFilepath +
					fileName + ".png"));
>>>>>>> cda4c41 (HybridFrameWork)
			Log.info("Screenshot captured");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Log.info("Screenshot exception");
		}
	}
<<<<<<< HEAD

=======
>>>>>>> cda4c41 (HybridFrameWork)
	// End Extent Reporting
	public void endReport() {
		report.endTest();
	}

	// End a Test
	public void endTest() {
		driver.close();
		driver.quit();
	}
<<<<<<< HEAD

=======
>>>>>>> cda4c41 (HybridFrameWork)
	//Click Element method.
	//This method will log in Extent Report as well in Log4j.
	public boolean clickElement(WebElement element) {

		try {
			element = waitForElement(element);
<<<<<<< HEAD

			if (element != null) {
				takeScreenShot(elementDetails.get(element));
				report.logStatus(LogStatus.PASS, "Click",
						"Click " + elementDetails.get(element) + " <span class='label success'>Success</span>");

=======
			if (element != null) {
				takeScreenShot(elementDetails.get(element));
				report.logStatus(LogStatus.PASS, "Click",
						"Click " + elementDetails.get(element) 
						+ " <span class='label success'>Success</span>");
>>>>>>> cda4c41 (HybridFrameWork)
				report.screenshotLog(LogStatus.PASS, "Click Success " + elementDetails.get(element),
						Constants.sScreenshotFilepath + elementDetails.get(element) + ".png");

				Log.info("Element Clicked: "+elementDetails.get(element));
				element.click();
				return true;
			}
<<<<<<< HEAD

			else
 			throw new NoSuchElementException("Element not found");

=======
			else
 			throw new NoSuchElementException("Element not found");
>>>>>>> cda4c41 (HybridFrameWork)
		} catch (Exception e) {
			takeScreenShot("Fail_" + Constants.dateTag);

			report.screenshotLog(LogStatus.FAIL, "Click Failed ",
					Constants.sScreenshotFilepath + "Fail_" + Constants.dateTag + ".png");
<<<<<<< HEAD

			Log.info("Element Click Exception");
			report.endTest();

=======
			Log.info("Element Click Exception");
			report.endTest();
>>>>>>> cda4c41 (HybridFrameWork)
			throw new NoSuchElementException("Element not found");
		}
	}

	//Enter text in text box method.
	//This method will log in Extent Report as well in Log4j.
	public boolean EnterText(WebElement element, String input) {
		try {
			element = waitForElement(element);
<<<<<<< HEAD

=======
>>>>>>> cda4c41 (HybridFrameWork)
			if (element != null) {
				element.sendKeys(input);

				report.logStatus(LogStatus.PASS, "Enter Text",
<<<<<<< HEAD
					"Enter Text into " + elementDetails.get(element) + " <span class='label success'>Success</span>");

				Log.info("Enter text: " + elementDetails.get(element));

				return true;
			}else

				throw new NoSuchElementException("Element not found");

=======
					"Enter Text into " + elementDetails.get(element) 
					+ " <span class='label success'>Success</span>");
								Log.info("Enter text: " + elementDetails.get(element));
				return true;
			}else
				throw new NoSuchElementException("Element not found");
>>>>>>> cda4c41 (HybridFrameWork)
		} catch (Exception e) {

			takeScreenShot("Fail_" + Constants.dateTag);
			report.screenshotLog(LogStatus.FAIL, "Enter Text",
					Constants.sScreenshotFilepath + "Fail_" + Constants.dateTag + ".png");
			Log.info("Enter text Exception");
<<<<<<< HEAD

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

				report.logStatus(LogStatus.PASS, "Select Element", "Select Element For " + elementDetails.get(element)
						+ " <span class='label success'>Success</span>");

				Log.info("Select element: " + elementDetails.get(element));

				return true;

			}else

=======
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
>>>>>>> cda4c41 (HybridFrameWork)
				throw new NoSuchElementException("Element not found");

		} catch (Exception e) {
			takeScreenShot("Fail_" + Constants.dateTag);
<<<<<<< HEAD

			report.screenshotLog(LogStatus.FAIL, "Select Element",
					Constants.sScreenshotFilepath + "Fail_" + Constants.dateTag + ".png");
			Log.info("Select element Exception ");

			throw new NoSuchElementException("Element not found");
		}
	}
}
=======
			report.screenshotLog(LogStatus.FAIL, "Select Element",
					Constants.sScreenshotFilepath + "Fail_" + Constants.dateTag + ".png");
			Log.info("Select element Exception ");
			throw new NoSuchElementException("Element not found");
		}
	}
}
>>>>>>> cda4c41 (HybridFrameWork)
