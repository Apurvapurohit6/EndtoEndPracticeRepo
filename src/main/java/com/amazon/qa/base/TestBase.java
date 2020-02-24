package com.amazon.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.amazon.qa.util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() throws IOException
	{
			try 
			{
				prop = new Properties();
				FileInputStream ip = new FileInputStream("C:\\Users\\16476\\eclipse-workspace\\AmazonTest\\src\\main\\java\\com\\amazon\\qa\\config\\config.properties");
				prop.load(ip);
			}
			catch(FileNotFoundException e)
			{
				e.printStackTrace();
			}
	}
	public static void initialisation()
	{
			String browser = prop.getProperty("browser");
			if(browser.equalsIgnoreCase("chrome"))
			{
					System.setProperty("webdriver.chrome.driver", "C:\\Work\\chromedriver.exe");
					driver = new ChromeDriver();			
			}
			else if(browser.equalsIgnoreCase("Firefox"))
			{
					//write a code for firefox
			}
			else if(browser.equals("IE"))
			{
					//write a code for ie
			}
			
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_load_timeout, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(TestUtil.implicit_wait, TimeUnit.SECONDS);
			driver.get(prop.getProperty("url"));
			
		
	}
}
