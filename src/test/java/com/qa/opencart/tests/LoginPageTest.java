package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.listeners.TestAllureListener;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;


@Epic("Epic 100: Design open cart login page")
@Story("US 101: Login page features")
@Feature("F50: Feature login page")
@Listeners(TestAllureListener.class)
public class LoginPageTest extends BaseTest {

	@Description("login page title test")
	@Severity(SeverityLevel.MINOR)
	@Test(priority = 1)
	public void loginPageTitleTest() {
		String actualTitle = loginpage.getLoginPageTitle();
		Assert.assertEquals(actualTitle, AppConstants.LOGIN_PAGE_TITLE);
	}
	@Description("login page URL test")
	@Severity(SeverityLevel.MINOR)
	@Test(priority = 2)
	public void loginPageUrlTest() {
		String ActUrl = loginpage.getLoginPageUrl();
		Assert.assertTrue(ActUrl.contains(AppConstants.LOGIN_PAGE_URL_FRACTION));
	}
	@Description("Verifying forgot password link")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 3)
	public void loginPageforgotPwdLinkExistTest() {
		Assert.assertTrue(loginpage.isForgotPasswordLinkExist());

	}

	@Description("Verifying logo is exist or not")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 4)
	public void loginPageAppLogoExistTest() {
		Assert.assertTrue(loginpage.islogoExist());

	}
	@Description("Verifying user is able to login or not ")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 5)
	public void loginTest() {
		acctpage=loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertTrue(acctpage.isLogoutLinkExist());
	}

}
