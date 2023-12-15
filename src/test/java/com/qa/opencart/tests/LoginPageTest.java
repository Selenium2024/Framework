package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

public class LoginPageTest extends BaseTest {

	@Test(priority = 1)
	public void loginPageTitleTest() {
		String actualTitle = loginpage.getLoginPageTitle();
		Assert.assertEquals(actualTitle, AppConstants.LOGIN_PAGE_TITLE);
	}

	@Test(priority = 2)
	public void loginPageUrlTest() {
		String ActUrl = loginpage.getLoginPageUrl();
		Assert.assertTrue(ActUrl.contains(AppConstants.LOGIN_PAGE_URL_FRACTION));
	}

	@Test(priority = 3)
	public void loginPageforgotPwdLinkExistTest() {
		Assert.assertTrue(loginpage.isForgotPasswordLinkExist());

	}

	@Test(priority = 4)
	public void loginPageAppLogoExistTest() {
		Assert.assertTrue(loginpage.islogoExist());

	}

	@Test(priority = 5)
	public void loginTest() {
		acctpage=loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertTrue(acctpage.isLogoutLinkExist());
	}

}
