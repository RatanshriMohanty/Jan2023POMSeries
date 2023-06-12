package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtil;

public class AccountsPage {
	
	
	private WebDriver driver;

	//1. const. of the page class
	public AccountsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//2. by locators:
	private By logout = By.linkText("Logout");
	private By myAccount = By.linkText("My Account");
	private By accHeaders = By.cssSelector("div#content h2");
	private By search = By.name("search");
	private By searchIcon = By.cssSelector("div#search button");
	
	
	//3. page actions:
	public String getAccPageTitle() {
		String title = driver.getTitle();
		System.out.println("Acc page title : " + title);
		return title;
	}
	
	public boolean isLogoutLinkExist() {
		return driver.findElement(logout).isDisplayed();
	}
	
	public boolean isMyAccountLinkExist() {
		return driver.findElement(myAccount).isDisplayed();
	}
	
	public List<String> getAccountPageHeadersList() {
		List<WebElement> headersList = driver.findElements(accHeaders);
		List<String> headersValList = new ArrayList<String>();
		for(WebElement e : headersList) {
			String text = e.getText();
			headersValList.add(text);
		}
		return headersValList;
	}
	
	public ResultsPage doSearch(String searchTerm) {
	//	ElementUtil.waitForElementVisible(search, 10)
		driver.findElement(search).sendKeys(searchTerm);
		driver.findElement(searchIcon).click();
		return new ResultsPage(driver);
	}

}
