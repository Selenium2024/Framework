package com.qa.opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class SearchResultPage {

	private WebDriver driver;
	private ElementUtil elementUtil;
	// private By ProductNames =
	// By.xpath("//div[@class='product-thumb']/child::div/a");

	public SearchResultPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}

	public ProductInfoPage selectProduct(String ProductName) {
		By.linkText(ProductName);
		elementUtil.waitForVisibilityOfElement(By.linkText(ProductName), AppConstants.MEDIUM_DEFAULT_WAIT).click();

		//elementUtil.doClick(ProductNameLocator);
		
		return new ProductInfoPage(driver);
	}

}
