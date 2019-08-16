package com.hyder.testcase;

import org.testng.annotations.Test;
import com.hyder.pages.HomePage;
import com.hyder.utils.Config;
import com.hyder.utils.Constants;
import com.hyder.utils.ExcelUtil;
import com.hyder.utils.Log;
import com.hyder.utils.Reports;
import org.testng.annotations.BeforeMethod;
import java.lang.reflect.Method;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;


public class BookFlightTest {
	WebDriver driver;
	HomePage homePage;
	Reports report;

  // First Test Case	
  @Test
  public void firstTestCase() {
	  homePage = new HomePage(driver);

	  try {
		homePage.navigateToURL(ExcelUtil.getCellData(1, 1));
		homePage.loginUser(ExcelUtil.getCellData(1, 2), 
				ExcelUtil.getCellData(1, 3)).findFlights(ExcelUtil.getCellData(1, 4), ExcelUtil.getCellData(1, 5));
	} catch (Exception e) {
		e.printStackTrace();
	}
  }
  
  //Second Test Case	 
  @Test
  public void secondTestCase() {
	  homePage = new HomePage(driver);
	  try{
		  homePage.navigateToURL(ExcelUtil.getCellData(2, 1));
		  homePage.loginUser(ExcelUtil.getCellData(2, 2), 
				  ExcelUtil.getCellData(2, 3)).findFlights(ExcelUtil.getCellData(2, 4), ExcelUtil.getCellData(2, 5));

	  } catch (Exception e) {
			e.printStackTrace();
	  }
  }
	 
  // Before Method to start logging
  @BeforeMethod
  public void beforeMethod(Method method) {

	  Log.startTestCase(method.getName());
	  report.startTest(method.getName());
	  System.out.println(Config.getProp().getProperty("selenium.browser")); 
  } 

  // After Method to end logging
  @AfterMethod
  public void afterMethod() {

	    homePage.endTest();
		homePage.endReport();
		Log.endTestCase("firstTestCase");

  }

    //Before Class to initialize Log4j
	@BeforeClass

	public void beforeClass() {
		 System.setProperty(Config.getProp().getProperty("logfoldername"), Constants.logFolderName);
		 System.setProperty(Config.getProp().getProperty("logfilename"), Constants.logFileName);

		 DOMConfigurator.configure("src/main/java/com/hyder/utils/log4j.xml");

		 try {
			ExcelUtil.setExcelFile(Constants.PATH_DATA, "Sheet1");

		} catch (Exception e) {
			e.printStackTrace();
		}
		 report = new Reports();
	}
}