package com.qa.opencart.Tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class LoginPageNegativeTest extends BaseTest {
	
	@DataProvider
	public Object[][] incorrectLoginTestData()
	{
		return new Object [][]
				{
			{"auto123@gmail.com", "123456"},
			{"test123@gmail.com", "123456"},
			{"auto12@gmail.com", "123456"},


				};
	}



@Test(dataProvider = "incorrectLoginTestData")
public void loginWithWrongCredentialsTest(String userName, String password)
{
	Assert.assertTrue(loginPage.doLoginWithWrongCredentials(userName, password));
}
}
