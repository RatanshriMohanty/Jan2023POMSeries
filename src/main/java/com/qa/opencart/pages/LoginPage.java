package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.AppConstant;
import com.qa.opencart.utils.ElementUtil;

public class LoginPage {
	
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	//1. const. of the page class
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		eleUtil = new ElementUtil(this.driver);
		
	}
	
	//2. private by locators :
	private By emailId = By.id("input-email");
	private By password = By.id("input-password");
	private By loginBtn = By.xpath("//input[@value='Login']");
	private By forgotPwdlink = By.linkText("Forgot Password");
	private By footerLinks = By.xpath("//footer//a");
	private By loginErrorMessg = By.cssSelector("div.alert.alert-danger.alert-dismissible");
	
	private By registerLink = By.linkText("Register");
	
	//3. public page actions/methods:
	public String getLoginPageTitle()
	{
		 return eleUtil.waitForTitleIsAndCapture(AppConstant.LOGIN_PAGE_TITLE_VALUE, AppConstant.SHORT_DEFAULT_WAIT);
	}
	
	public String getLoginPageURL()
	{
		return  eleUtil.waitForURLContainsAndCapture(AppConstant.LOGIN_PAGE_URL_FRACTION_VALUE, AppConstant.SHORT_DEFAULT_WAIT);
	}
	
	public boolean isForgotPwdLinkExit()
	{
		return eleUtil.checkElementIsDisplayed(forgotPwdlink);
	}
	
	public List<String> getFooterLinksList()
	{
		List<WebElement> footerLinksList =  eleUtil.waitForElementsVisible(footerLinks, AppConstant.MEDIUM_DEFAULT_WAIT);
		List<String> footerTextList = new ArrayList<String>();
		for(WebElement e: footerLinksList)
		{
			String text = e.getText();
			footerTextList.add(text);
		}
		return footerTextList;
		
	}
	public AccountsPage doLogin(String userName, String pwd)
	{
		System.out.println("correct creds are : " + userName + ":" +pwd);

		eleUtil.waitForElementVisible(emailId, AppConstant.MEDIUM_DEFAULT_WAIT).sendKeys(userName);
		eleUtil.doSendKeys(password, pwd);
		eleUtil.doClick(loginBtn);
		//return the next landing page - AccountsPage -- page changing model
		
		return new AccountsPage(driver);
		

		
		
	}
	
	public boolean doLoginWithWrongCredentials(String userName, String pwd)
	{
		System.out.println("wrong creds are : " + userName + ":" +pwd);
		eleUtil.waitForElementVisible(emailId, AppConstant.MEDIUM_DEFAULT_WAIT);
		eleUtil.doSendKeys(emailId, userName);
		eleUtil.doSendKeys(password, pwd);
		eleUtil.doClick(loginBtn);
		//return the next landing page - AccountsPage -- page changing model
		
		String errorMessg = eleUtil.doGetElementText(loginErrorMessg);
		System.out.println(errorMessg);
		
		

		if (errorMessg.contains(AppConstant.LOGIN_ERROR_MESSAGE))
		{
			return true;
		}
		return false;
		
		
	}
	
	public Registration navigateToRegisteration()
	{
		eleUtil.doClick(registerLink);
		return new Registration(driver);
	}
	

}
