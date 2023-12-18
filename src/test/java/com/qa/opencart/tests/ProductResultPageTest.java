package com.qa.opencart.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class ProductResultPageTest extends BaseTest {
	
	@BeforeClass
	public void productInfoSetup() {
		acctpage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@DataProvider
	public Object[][] getSearchData() {
		
		return new Object[][] {
				{"MacBook","MacBook Pro",4},
				{"MacBook","MacBook Air",4},
				{"iMac","iMac",3},
				{"Samsung","Samsung SyncMaster 941BW",1}
		};
	}
	
	@Test(dataProvider="getSearchData")
	public void productImageTest(String searchKey,String ProductName,int imageCount) {
		searchResultPage=acctpage.doSearch(searchKey);
		productInfoPage=searchResultPage.selectProduct(ProductName);
		Assert.assertEquals(productInfoPage.getImageCount(),imageCount);
	}
	@Test
	public void productInfoTest() {
		
		searchResultPage=acctpage.doSearch("MacBook");
		productInfoPage=searchResultPage.selectProduct("MacBook Pro");
		Map<String,String> ProductDetailsMap=  productInfoPage.getProductDetails();
		
		
		softAssert.assertEquals(ProductDetailsMap.get("Brand"), "Apple");
		softAssert.assertEquals(ProductDetailsMap.get("Product Code"), "Product 18");
		softAssert.assertEquals(ProductDetailsMap.get("Reward Points"), "800");
		softAssert.assertEquals(ProductDetailsMap.get("Availability"), "In Stock");
		
		softAssert.assertEquals(ProductDetailsMap.get("price"), "$2,000.00");
		softAssert.assertEquals(ProductDetailsMap.get("ExtPrice"), "$2,000.00");
		
		softAssert.assertAll();
	}

}
