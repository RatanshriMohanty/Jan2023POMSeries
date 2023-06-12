package com.qa.opencart.Tests;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.AppConstant;

public class AccountsPageTest extends BaseTest {

	@BeforeClass
	public void accPageSetup() {
		//accPage = loginPage.doLogin("janautomation@gmail.com", "Selenium@12345");
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test
	public void accPageTitleTest() {
		String actTitle = accPage.getAccPageTitle();
		Assert.assertEquals(actTitle, AppConstant.ACCOUNTS_PAGE_TITLE_VALUE);
	}

	@Test
	public void isLogoutLinkExistTest() {
		Assert.assertTrue(accPage.isLogoutLinkExist());
	}

	@Test
	public void isMyAccLinkExistTest() {
		Assert.assertTrue(accPage.isMyAccountLinkExist());
	}

	@Test
	public void accPageHeadersCountTest() {
		List<String> actAccHeadersList = accPage.getAccountPageHeadersList();
		Assert.assertEquals(actAccHeadersList.size(), 4);
	}

	@Test
	public void accPageHeadersTest() {
		List<String> actAccHeadersList = accPage.getAccountPageHeadersList();
		Assert.assertEquals(actAccHeadersList, AppConstant.EXP_ACCOUNTS_HEADERS_LIST);
	}

}

