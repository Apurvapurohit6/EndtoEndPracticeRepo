package com.amazon.qa.testcases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginpage;
	String expectedtitle = "Amazon.ca: Low Prices – Fast Shipping – Millions of Items";
	
	LoginPageTest() throws IOException
	{
		super();
	}
	

	@BeforeMethod
	public void setup() throws IOException
	{
		initialisation();
		loginpage = new LoginPage();
	}
	
	@Test(priority=1)
	public void loginToAmazonTest() throws IOException
	{
		loginpage.navigatetologinpage();
		loginpage.logintoamazon(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=2)
	public void loginPageTitleTest()
	{
		String actualtitle = loginpage.validatehomepagetitle();
		Assert.assertEquals(actualtitle, expectedtitle);
		
	}
	
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

}
