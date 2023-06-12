package com.qa.opencart.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterMethod;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.beust.jcommander.Parameters;
import com.qa.opencart.Factory.DriverFactory;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.ProductInfoPage;
import com.qa.opencart.pages.Registration;
import com.qa.opencart.pages.ResultsPage;


public class BaseTest {

	WebDriver driver;
	protected LoginPage loginPage;
	protected AccountsPage accPage;
	protected ResultsPage resultsPage;
	protected ProductInfoPage productInfoPage;
	protected Registration registrationPage;
	
	protected DriverFactory df;
	 protected Properties prop;
	 
	 protected SoftAssert softAssert;
	
	 @Parameters({"browser"})
		@BeforeTest
		public void setup(String browserName) {
			df = new DriverFactory();
			prop = df.initProp();
				if(browserName!=null) {
					prop.setProperty("browser", browserName);
				}		
			driver = df.initDriver(prop);
			
			loginPage = new LoginPage(driver);
			softAssert = new SoftAssert();
		}

	
		@AfterTest
		public void tearDown() {
			driver.quit();
		}

	}
