package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.ProductInfoPage;
import com.qa.opencart.pages.SearchResultPage;

public class BaseTest {

	protected WebDriver driver;
	protected Properties prop;
	DriverFactory df;
	protected LoginPage loginpage;
	protected AccountPage acctpage;
	protected SearchResultPage searchResultPage;
	protected ProductInfoPage productInfoPage;
	protected SoftAssert softAssert;
	@BeforeTest
	public void setup() {
		df = new DriverFactory();
		prop=df.initprop();
		driver = df.initDriver(prop);
		loginpage=new LoginPage(driver);
		softAssert=new SoftAssert();
		
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
