package com.hyder.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.hyder.base.BasePage;
import com.hyder.utils.Log;


public class HomePage extends BasePage {


	public HomePage(WebDriver driver) throws Exception {
		super(driver);
	}
	// Element Locators for username textbox
	@FindBy(id = "username")
	private WebElement userName;

	public WebElement getUserName(){
		try{
			elementDetails.put(userName, "User Name text box");
		}catch(Exception e){
			
		}

		return userName;
	}

	// Element Locators for password textbox
	@FindBy(name = "password")
	private WebElement password;

	public WebElement getPassword(){
		try{
			elementDetails.put(password, "Password text box");
		}catch(Exception e){

		}
		return password;
	}

	// Element Locators for login button
	@FindBy(xpath = "//input[@name='login']")
	private WebElement login;


	public WebElement getLogin() {		
		try{
			elementDetails.put(login, "Login button");
		}catch(Exception e){

		}
		return login;
	}

	// Login method. Notice there is no return type
	public FlightFinderPage loginUser(String uname, String pwd) throws Exception {

		// Enter username
		EnterText(getUserName(), uname);

		// Log4j logging
		Log.info("HomePage.loginUser - username entered");

		// Enter password
		EnterText(getPassword(), pwd);

		// Log4j logging
		Log.info("HomePage.loginUser - password entered");

		// Click Login button
		clickElement(getLogin());

		// Log4j logging
		Log.info("HomePage.loginUser - login button clicked");

		return new FlightFinderPage(driver);

	}
}

