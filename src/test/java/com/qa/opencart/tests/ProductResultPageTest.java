package com.qa.opencart.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class ProductResultPageTest extends BaseTest {
	
	@BeforeClass
	public void productInfoSetup() {
		acctpage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void productImageTest() {
		searchResultPage=acctpage.doSearch("MacBook");
		productInfoPage=searchResultPage.selectProduct("MacBook Pro");
		Assert.assertEquals(productInfoPage.getImageCount(),4);
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
