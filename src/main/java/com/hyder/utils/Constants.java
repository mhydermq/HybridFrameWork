package com.hyder.utils;

import java.text.SimpleDateFormat;

import java.util.Date;



public class Constants {

	// TestResults folder location
	public static final String PATH_RESULTS = System.getProperty("user.dir") + "/TestResults/";

	// Test Data Excel location
<<<<<<< HEAD
	public static final String PATH_DATA = System.getProperty("user.dir") + "/src/main/java/com/hyder/data/Data.xlsx";
=======
	public static final String PATH_DATA = System.getProperty("user.dir") 
			+ "/src/main/java/com/hyder/data/Data.xlsx";
>>>>>>> cda4c41 (HybridFrameWork)

	// Test Data Excel Sheet name
	public static final String SHEETNAME = "Sheet1";

	// Test Data Excel File Name
	public static final String FILE_NAME = "TestData.xlsx";

	// Property file name
	public static final String PROP_NAME = "system.properties";


	// Property file location
	public static final String PROP_LOCATION = "src/main/resources";

	public static Date date = new Date();
	public static SimpleDateFormat reportDate = new SimpleDateFormat("MM-dd-yyyy hh-mm-ss");

	//Log Files Constants
	public static String logFileName = "LOG_"+reportDate.format(date);
	public static String dateTag = reportDate.format(date);
	public static String logFolderName = "LOG_FOLDER_"+reportDate.format(date);

	// Extent Report constants
	public static final String filePath = System.getProperty("user.dir");
	public static final String reportPath = filePath + "/RESULT_LOG";
	public static final String imagePath = filePath + "/IMAGES";


<<<<<<< HEAD
	public static final String reportFileName = reportPath + "/" + "TESTREPORT_" + reportDate.format(date) + "TC.html";
	public static final String screenshotFileName = reportPath + "/SCREENSHOTS" + "TESTREPORT_"
			+ reportDate.format(date) + "TC.html";

	public static final String screenshotFilePath = screenshotFileName + "/SCREENSHOTS" + "TEST"
			+ reportDate.format(date) + "/";

	public static String sScreenshotFilepath = filePath + "/Screenshots/" + "IOLS_Screenshot_" + reportDate.format(date)
			+ "/";

	public static String sReportFileName = reportPath + "/" + "IOLSTestReport_" + reportDate.format(date) + ".html";
=======
	public static final String reportFileName = reportPath + "/" + "TESTREPORT_" 
	+ reportDate.format(date) + "TC.html";
	
	public static final String screenshotFileName = reportPath + "/SCREENSHOTS" + "TESTREPORT_"
			+ reportDate.format(date) + "TC.html";
	public static final String screenshotFilePath = screenshotFileName + "/SCREENSHOTS" + "TEST"
			+ reportDate.format(date) + "/";

	public static String sScreenshotFilepath = filePath + "/Screenshots/" + 
	"IOLS_Screenshot_" + reportDate.format(date)
			+ "/";
	public static String sReportFileName = reportPath + "/" + 
			"IOLSTestReport_" + reportDate.format(date) + ".html";
>>>>>>> cda4c41 (HybridFrameWork)



}