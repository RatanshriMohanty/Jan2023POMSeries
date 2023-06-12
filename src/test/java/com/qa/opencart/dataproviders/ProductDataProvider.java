package com.qa.opencart.dataproviders;

import org.testng.annotations.DataProvider;

import com.qa.opencart.pojo.product;

public class ProductDataProvider {
	
	@DataProvider(name = "productData")
	public Object[][] getProductTestData( ) {
		return new Object [][] {
			
			{new product("Macbook", "Mackbook Pro", 4)},
			{new product("iMac", "iMac", 3)},
			{new product("Samsung", "Samsung Galaxy Tab 10.1", 7)},
			{new product("Samsung", "Samsung Galaxy SyncMaster 941BW", 7)},

			
			
		};
	}
	@DataProvider(name = "productDataWithImage")
	public Object [][] getProductImagesTestData()
	{
		return new Object [][]
				{
			{"Macbook","Mackbook Pro", 4},
			{"iMac","iMac", 3},
			{"Samsung","Samsung SyncMaster 941BW", 1},
			{"Samsung","Samsung Galaxy Tab 10.1", 7},

				};
	}
	
	@DataProvider(name = "productDataWithName")
	public Object [][] getProductData()
	{
		return new Object [][]
				{
			{"Macbook","Mackbook Pro"},
			{"iMac","iMac"},
			{"Samsung","Samsung SyncMaster 941BW"},
			{"Samsung","Samsung Galaxy Tab 10.1"},

				};
	}
	
	@DataProvider(name = "productDataWithSearchKey")
	public Object[][] getProductSearchKeyData()
{
	return new Object [][] 
			{
		{"Macbook"},
		{"iMac"},
		{"Samsung"},
	};
}
	
	

}
