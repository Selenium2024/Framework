package com.qa.opencart.tests;

import java.util.UUID;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class RegisterPageTest extends BaseTest {
	
	@BeforeClass
	public void RegSetup() {
		
		registerPage=loginpage.navigateToRegisterPage();
	}
	
	public String getRandomEmailID() {
		return "TestAutomation"+System.currentTimeMillis()+"@openCart.com";
		//return "TestAutomation"+UUID.randomUUID()+"@openCart.com";
	}
	
	@DataProvider
	public Object[][] getUserRegData() {
		
		return new Object[][] {
			{"Rudransh", "Bhalla", "7888998876", "RD@2022", "YES"},
			{"Rudransh", "Bhalla",  "7888998876", "RD@2022", "YES"},
			{"Rudransh", "Bhalla",  "7888998876", "RD@2022", "YES"},
			{"Rudransh", "Bhalla",  "7888998876", "RD@2022", "NO"}
		};
	}
	
	
	@Test(dataProvider="getUserRegData")
	public void userRegTest(String firstName,String lastName,String Telephone,String Password,String Subscribe) {
		boolean isRegDone=registerPage.userRegistration(firstName, lastName,getRandomEmailID() , Telephone, Password, Subscribe);
		Assert.assertTrue(isRegDone);
	}

}
