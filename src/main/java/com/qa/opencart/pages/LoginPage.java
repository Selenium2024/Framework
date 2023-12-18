package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class LoginPage {

	private WebDriver driver;
	private ElementUtil elementUtil;

	// By locators:

	private By userName = By.id("input-email");
	private By Password = By.id("input-password");
	private By loginBtn = By.xpath("//input[@value='Login']");
	private By forgotPwdLink = By.linkText("Forgotten Password");
	private By logo = By.cssSelector("img[title='naveenopencart']");
	private By registerLink = By.linkText("Register");

	// page const
	public LoginPage(WebDriver driver) {

		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);

	}

	// page action

	public String getLoginPageTitle() {
		String title = elementUtil.waitForTitleIs(AppConstants.LOGIN_PAGE_TITLE, AppConstants.SHORT_DEFAULT_WAIT);
		System.out.println("Login page Title" + title);
		return title;
	}

	public String getLoginPageUrl() {

		String url = elementUtil.waitForURLContains(AppConstants.LOGIN_PAGE_URL_FRACTION, AppConstants.SHORT_DEFAULT_WAIT);
		System.out.println("Login page Url : " + url);
		return url;
	}

	public boolean isForgotPasswordLinkExist() {
		return elementUtil.waitForVisibilityOfElement(forgotPwdLink, AppConstants.SHORT_DEFAULT_WAIT).isDisplayed();

	}

	public boolean islogoExist() {

		return elementUtil.waitForVisibilityOfElement(logo, AppConstants.SHORT_DEFAULT_WAIT).isDisplayed();
	}

	public AccountPage doLogin(String username, String pwd) {
		elementUtil.waitForVisibilityOfElement(userName, AppConstants.SHORT_DEFAULT_WAIT).sendKeys(username);
		elementUtil.doSendKeys(Password, pwd);
		elementUtil.doClick(loginBtn);
		return new AccountPage(driver);

	}
	
	public RegisterPage navigateToRegisterPage() {
		elementUtil.waitForVisibilityOfElement(registerLink, AppConstants.SHORT_DEFAULT_WAIT).click();
		return new RegisterPage(driver);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
