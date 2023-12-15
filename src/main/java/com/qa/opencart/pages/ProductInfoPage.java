package com.qa.opencart.pages;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class ProductInfoPage {

	private WebDriver driver;
	private ElementUtil elementUtil;
	private By productHeaderName = By.cssSelector("div#content h1");
	private By imageCount = By.cssSelector("ul.thumbnails img");
	private By productMetaData=By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[1]/li");
	private By productPrice=By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[2]/li");
	
	private Map<String, String> MedataList=new LinkedHashMap<String,String>();
	
	
	
	public ProductInfoPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}

	public String getProductHeaderName() {
		String ProdHeader = elementUtil.doElementGetText(productHeaderName);
		System.out.println(ProdHeader);
		return ProdHeader;
	}

	public int getImageCount() {
		int actualImageCount=elementUtil.waitForVisibilityOfElements(imageCount, AppConstants.SHORT_DEFAULT_WAIT).size();
		System.out.println("Images Counts=: "+actualImageCount);
		return actualImageCount;
	}
	
	private void getProductMetaData() {
		List<WebElement> metadatList=	elementUtil.waitForVisibilityOfElements(productMetaData, AppConstants.LONG_DEFAULT_WAIT);
		
		
		for(WebElement e: metadatList) {
			String MetaValue=e.getText();
			String Key=MetaValue.split(":")[0].trim();
			String value=MetaValue.split(":")[1].trim();
			MedataList.put(Key, value);
		}
		
	}
	
	private void getProductPriceData() {
		List<WebElement> metadatList=	elementUtil.waitForVisibilityOfElements(productPrice, AppConstants.LONG_DEFAULT_WAIT);
		
		String productPrice=metadatList.get(0).getText();
		String productExtPrice=metadatList.get(1).getText().split(":")[1].trim();
		
		MedataList.put("price", productPrice);
		MedataList.put("ExtPrice", productExtPrice);
		
		
	}
	
	public Map<String,String> getProductDetails() {
		MedataList.put("ProductName",getProductHeaderName());
		getProductMetaData();
		getProductPriceData();
		System.out.println(MedataList);
		return MedataList;
		
	}
	
	
	

}
