package com.hyder.testcase;

<<<<<<< HEAD
import org.testng.annotations.Test;
=======
import java.lang.reflect.Method;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

>>>>>>> cda4c41 (HybridFrameWork)
import com.hyder.pages.HomePage;
import com.hyder.utils.Config;
import com.hyder.utils.Constants;
import com.hyder.utils.ExcelUtil;
import com.hyder.utils.Log;
import com.hyder.utils.Reports;
<<<<<<< HEAD
import org.testng.annotations.BeforeMethod;
import java.lang.reflect.Method;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
=======
>>>>>>> cda4c41 (HybridFrameWork)


public class BookFlightTest {
	WebDriver driver;
	HomePage homePage;
	Reports report;

  // First Test Case	
  @Test
<<<<<<< HEAD
  public void firstTestCase() {
	  homePage = new HomePage(driver);

=======
  public void firstTestCase() throws Exception {
	  homePage = new HomePage(driver);
>>>>>>> cda4c41 (HybridFrameWork)
	  try {
		homePage.navigateToURL(ExcelUtil.getCellData(1, 1));
		homePage.loginUser(ExcelUtil.getCellData(1, 2), 
				ExcelUtil.getCellData(1, 3)).findFlights(ExcelUtil.getCellData(1, 4), ExcelUtil.getCellData(1, 5));
	} catch (Exception e) {
		e.printStackTrace();
	}
  }
<<<<<<< HEAD
  
  //Second Test Case	 
  @Test
  public void secondTestCase() {
=======
  //Second Test Case	 
  @Test
  public void secondTestCase() throws Exception {
>>>>>>> cda4c41 (HybridFrameWork)
	  homePage = new HomePage(driver);
	  try{
		  homePage.navigateToURL(ExcelUtil.getCellData(2, 1));
		  homePage.loginUser(ExcelUtil.getCellData(2, 2), 
				  ExcelUtil.getCellData(2, 3)).findFlights(ExcelUtil.getCellData(2, 4), ExcelUtil.getCellData(2, 5));

	  } catch (Exception e) {
			e.printStackTrace();
<<<<<<< HEAD
	  }
  }
	 
  // Before Method to start logging
  @BeforeMethod
  public void beforeMethod(Method method) {

=======
	}
  } 
  // Before Method to start logging
  @BeforeMethod
  public void beforeMethod(Method method) throws Exception {
>>>>>>> cda4c41 (HybridFrameWork)
	  Log.startTestCase(method.getName());
	  report.startTest(method.getName());
	  System.out.println(Config.getProp().getProperty("selenium.browser")); 
  } 

  // After Method to end logging
  @AfterMethod
  public void afterMethod() {
<<<<<<< HEAD

	    homePage.endTest();
		homePage.endReport();
		Log.endTestCase("firstTestCase");

  }

    //Before Class to initialize Log4j
	@BeforeClass

	public void beforeClass() {
=======
	    homePage.endTest();
		homePage.endReport();
		Log.endTestCase("firstTestCase");
  }
    //Before Class to initialize Log4j
	@BeforeClass
	public void beforeClass() throws Exception {
>>>>>>> cda4c41 (HybridFrameWork)
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
<<<<<<< HEAD
}
=======
}
>>>>>>> cda4c41 (HybridFrameWork)
