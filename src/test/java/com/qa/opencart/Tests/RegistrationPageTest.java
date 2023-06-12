package com.qa.opencart.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.utils.ElementUtil;
import com.qa.opencart.utils.ExcelUtil;
import com.qa.opencart.base.BaseTest;
import com.qa.opencart.pages.Registration;
import com.qa.opencart.utils.AppConstant;

public class RegistrationPageTest extends BaseTest  {
	
	
	@BeforeClass
	public void regSetup() {
		 Registration registerationPage = loginPage.navigateToRegisteration();
	}
	
	
	public String getRandomEmailID() {
		return "testautomation"+System.currentTimeMillis()+"@gmail.com";
		//return "testautomation" + UUID.randomUUID()+"@gmail.com";
		
	}
	
//	@DataProvider(name = "regData")
//	public Object[][] getUserRegTestData() {
//		return new Object[][] {
//			{"abhi", "anand", "9876545678", "abhi@123", "yes"},
//			{"robinson", "matinez", "9876545600", "robin@123", "no"},
//			{"amber", "automation", "9876545998", "amber@123", "yes"},
//		};
//	}
	
	
	@DataProvider(name = "regExcelData")
	public Object[][] getRegExcelTestData() {
		Object regData[][] = ExcelUtil.getTestData(AppConstant.REGISTER_SHEET_NAME);
		return regData;
	}
	
	
	@Test(dataProvider = "regExcelData")
	public void userRegisterTest(String firstName, String lastName, String telephone, String password, String subscribe) {
		Registration registerationPage = null;
		String actRegSuccMessg = 
				registerationPage.registerUser(firstName, lastName, getRandomEmailID(), telephone, password, subscribe);
		Assert.assertEquals(actRegSuccMessg, AppConstant.USER_RESG_SUCCESS_MESSG);
	}
	
	
	

}
