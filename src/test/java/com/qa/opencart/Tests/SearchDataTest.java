package com.qa.opencart.Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.dataproviders.ProductDataProvider;
import com.qa.opencart.pojo.product;

public class SearchDataTest extends BaseTest {
	
	@BeforeClass
	public void searchSetup()
	{
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	
	


	
	@Test(dataProvider = "productData", dataProviderClass = ProductDataProvider.class)
	public void searchProductResultCountTest(product Product )
	{
		resultsPage = accPage.doSearch(Product.getSearchKey());
		Assert.assertTrue(resultsPage.getProductResultsCount()>0);
	}
	
	@Test(dataProvider = "productData",  dataProviderClass = ProductDataProvider.class)
	public void searchPageTitleTest(product Product)
	{
		resultsPage = accPage.doSearch(Product.getSearchKey());
		String actSearchTitle = resultsPage.getResultsPageTitle(Product.getSearchKey());
		System.out.println("Search page Title : " + actSearchTitle);
		Assert.assertEquals(actSearchTitle, "Search -" + Product.getSearchKey());
	}
	

	
	@Test(dataProvider = "productData", dataProviderClass = ProductDataProvider.class)
	public void selectProductTest(product Product)
	{
		resultsPage = accPage.doSearch(Product.getSearchKey());
		productInfoPage = resultsPage.selectProduct(Product.getSearchKey());
		String actProductHeaderName =  productInfoPage.getProductHeaderName();
		System.out.println("actual product name : " +actProductHeaderName);
		Assert.assertEquals(actProductHeaderName, Product.getSearchKey());
	}
	

	
	@Test(dataProvider = "productData", dataProviderClass = ProductDataProvider.class)
	public void productImagesTest(product Product)
	{
		resultsPage = accPage.doSearch(Product.getSearchKey());
		productInfoPage = resultsPage.selectProduct(Product.getSearchKey());
		int actProductImagesCount = productInfoPage.getProductImagesCount();
		System.out.println("actual product images count : " + actProductImagesCount);
		Assert.assertEquals(actProductImagesCount, Product.getSearchKey());
	}
	

}
