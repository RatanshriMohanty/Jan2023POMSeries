package com.qa.opencart.Tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;

import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.AppConstants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.AppConstant;

@Epic("Epic 100: Login Page Design")
@Story("US 101: design login page for open cart app with title, url, forgot pwd links, user is able to login")

public class LoginPageTest extends BaseTest {
	
	@Severity(SeverityLevel.MINOR)
	@Description("checking login page title test...")
	@Feature("title test")

	
	@Test
	public void loginPageTitleTest()
	{
		String actTitle = loginPage.getLoginPageTitle();
		AssertJUnit.assertEquals(actTitle, AppConstant.ACCOUNTS_PAGE_TITLE_VALUE);
	}
	
	@Test
	public void loginPageUrlTest()
	{
		String actURL = loginPage.getLoginPageURL();
		AssertJUnit.assertTrue(actURL.contains(AppConstant.LOGIN_PAGE_URL_FRACTION_VALUE));
	}

	
	@Test
	public void forgotPwdLinkExistTest()
	{
		AssertJUnit.assertTrue(loginPage.isForgotPwdLinkExit());
	}
	
	@Test
	public void loginTest()
	{
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		AssertJUnit.assertTrue(accPage.isLogoutLinkExist());
		//Assert.assertTrue(accPage.getAccPageTitle().equals("My Account"));
	}
	
	
	

}
