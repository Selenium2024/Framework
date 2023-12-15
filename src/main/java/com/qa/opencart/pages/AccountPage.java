package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class AccountPage {

	private WebDriver driver;
	private ElementUtil elementUtil;

	private By LogoutLink = By.linkText("Logout");
	private By search = By.name("search");
	private By accountHeaders = By.cssSelector("div#content>h2");
	private By links = By.xpath("//div[@class=\"list-group\"]/a");
	private  By searchButton=By.cssSelector("div#search button");

	// page const
	public AccountPage(WebDriver driver) {

		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);

	}

	public String getAccountPageTitle() {
		String title = elementUtil.waitForTitleIs(AppConstants.ACCOUNR_PAGE_TITLE, AppConstants.SHORT_DEFAULT_WAIT);
		System.out.println("Account page title: " + title);
		return title;
	}

	// page action

	public boolean isLogoutLinkExist() {
		return elementUtil.waitForVisibilityOfElement(LogoutLink, AppConstants.SHORT_DEFAULT_WAIT).isDisplayed();
	}

	public void logout() {

		if (isLogoutLinkExist()) {

			elementUtil.doClick(LogoutLink);

		}

	}

	public boolean isSearchFieldExist() {

		return elementUtil.waitForVisibilityOfElement(search, AppConstants.SHORT_DEFAULT_WAIT).isDisplayed();

	}

	public List<String> getAccountHeaders() {
		List<WebElement> headers = elementUtil.waitForVisibilityOfElements(accountHeaders,
				AppConstants.SHORT_DEFAULT_WAIT);
		List<String> ArrayList = new ArrayList<String>();
		for (WebElement e : headers) {

			String ActualHeaders = e.getText();
			ArrayList.add(ActualHeaders);

		}

		return ArrayList;
	}

	public List<String> getLinks() {

		List<WebElement> Links = elementUtil.waitForVisibilityOfElements(links, AppConstants.SHORT_DEFAULT_WAIT);
		List<String> LinksList = new ArrayList<String>();
		for (WebElement e : Links) {

			String LinksText = e.getText();
			LinksList.add(LinksText);

		}
		
		return LinksList;
	}
	
	public SearchResultPage doSearch(String productName) {
		
		elementUtil.waitForVisibilityOfElement(search, AppConstants.SHORT_DEFAULT_WAIT).sendKeys(productName);
		elementUtil.doClick(searchButton);
		return new SearchResultPage(driver);
		
		
	}
	
	
	
}
