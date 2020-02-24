package com.amazon.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.HomePage;

public class LoginPage extends TestBase {
	
	
	//Page factory : OR
	@FindBy(id = "nav-link-accountList") 
	WebElement signin;	
	
	@FindBy(id="ap_email")
	WebElement emailid;
	
	@FindBy(id="continue")
	WebElement continuebutton;
	
	@FindBy(id="ap_password")
	WebElement password;
	
	@FindBy(id="signInSubmit")
	WebElement submitbutton;
		
	
	

	public LoginPage() throws IOException
	{
		PageFactory.initElements(driver, this);
	}


	public void navigatetologinpage() throws IOException
	{
		signin.click();
		//return new LoginPage();
	}
	
	public HomePage logintoamazon(String username , String pwd) throws IOException
	{
		emailid.sendKeys(username);
		continuebutton.click();
		password.sendKeys(pwd);
		submitbutton.click();
		return new HomePage();
		
	}
	public String validatehomepagetitle()
	{
		return driver.getTitle();
	}

}
