package com.hyder.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.hyder.base.BasePage;
import com.hyder.utils.Log;

<<<<<<< HEAD

public class FlightFinderPage extends BasePage {
	
	public FlightFinderPage(WebDriver driver) {
		super(driver);
	}

	//Element Locators for one way radio button
=======
public class FlightFinderPage extends BasePage {

	public FlightFinderPage(WebDriver driver) throws Exception {
		super(driver);
	}

	// Element Locators for one way radio button
>>>>>>> cda4c41 (HybridFrameWork)
	@FindBy(xpath = "//input[@value='oneway']")
	private WebElement onewayRadio;

	public WebElement getOneWayRadio() {
		try {
			elementDetails.put(onewayRadio, "One Way radio button");
		} catch (Exception e) {

		}
		return onewayRadio;
	}
<<<<<<< HEAD
	
	//Select the location from dropdown
	@FindBy(name = "fromPort")
	private WebElement fromPortDrop;

	public WebElement getFromPortDrop(){
		try{
			elementDetails.put(fromPortDrop, "From Port drop down");
		}catch (Exception e) {

		}	
		return fromPortDrop;
	}

	//Select the day from dropdown
	@FindBy(xpath = "//select[@name='fromDay']")
	private WebElement fromDayDrop;
	
	public WebElement getFromDayDrop(){
		try{
			elementDetails.put(fromDayDrop, "From Day drop down");
		}catch (Exception e) {
=======

	// Select the location from dropdown
	@FindBy(name = "fromPort")
	private WebElement fromPortDrop;

	public WebElement getFromPortDrop() {
		try {
			elementDetails.put(fromPortDrop, "From Port drop down");
		} catch (Exception e) {

		}
		return fromPortDrop;
	}

	// Select the day from dropdown
	@FindBy(xpath = "//select[@name='fromDay']")
	private WebElement fromDayDrop;

	public WebElement getFromDayDrop() {
		try {
			elementDetails.put(fromDayDrop, "From Day drop down");
		} catch (Exception e) {
>>>>>>> cda4c41 (HybridFrameWork)

		}
		return fromDayDrop;
	}

<<<<<<< HEAD
	//Click Business radio button
	@FindBy(xpath = "//input[@value='Business']")
	private WebElement businessRadio;

	public WebElement getBusinessRadio(){

		try{
			elementDetails.put(businessRadio, "Business radio button");
		}catch (Exception e) {
=======
	// Click Business radio button
	@FindBy(xpath = "//input[@value='Business']")
	private WebElement businessRadio;

	public WebElement getBusinessRadio() {

		try {
			elementDetails.put(businessRadio, "Business radio button");
		} catch (Exception e) {
>>>>>>> cda4c41 (HybridFrameWork)

		}
		return businessRadio;
	}
<<<<<<< HEAD
    
	//Click find flights button
	@FindBy(name = "findFlights")
	private WebElement findFlightsButton;

	public WebElement getFindFlightsButton(){
		try{
			elementDetails.put(findFlightsButton, "Find Flights button");
		}catch (Exception e) {
=======

	// Click find flights button
	@FindBy(name = "findFlights")
	private WebElement findFlightsButton;

	public WebElement getFindFlightsButton() {
		try {
			elementDetails.put(findFlightsButton, "Find Flights button");
		} catch (Exception e) {
>>>>>>> cda4c41 (HybridFrameWork)

		}
		return findFlightsButton;
	}

<<<<<<< HEAD
	//Find Flights method. Notice there is no return type
=======
	// Find Flights method. Notice there is no return type
>>>>>>> cda4c41 (HybridFrameWork)
	public void findFlights(String departFrom, String departDate) {

		// Click one way radio button
		clickElement(getOneWayRadio());
		Log.info("FlightFinderPage.findFlights - One way Radio Button clicked");

		// Select Departing From dropdown
		SelectElementByText(getFromPortDrop(), departFrom);
		Log.info("FlightFinderPage.findFlights - Depart From Dropdown clicked");

		// Select Departing Day dropdown
		SelectElementByText(getFromDayDrop(), departDate);
		Log.info("FlightFinderPage.findFlights - Depart Date Dropdown clicked");

		// Click business class
		clickElement(getBusinessRadio());
		Log.info("FlightFinderPage.findFlights - Business Radio Button clicked");

		// Click Find Flights button
		clickElement(getFindFlightsButton());
		Log.info("FlightFinderPage.findFlights - Find Flights Button clicked");
	}
<<<<<<< HEAD
}
=======
}
>>>>>>> cda4c41 (HybridFrameWork)
