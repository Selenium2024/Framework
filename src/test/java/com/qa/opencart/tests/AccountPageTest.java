package com.qa.opencart.tests;

import java.util.Collections;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

public class AccountPageTest extends BaseTest {

	@BeforeClass
	public void accountpagesetup() {
		acctpage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test
	public void accPageTitleTest() {

		Assert.assertEquals(acctpage.getAccountPageTitle(), AppConstants.ACCOUNR_PAGE_TITLE);

	}

	@Test
	public void isLogoutLinkExistTest() {
		Assert.assertTrue(acctpage.isLogoutLinkExist());
	}

	@Test
	public void isSearchFieldExistTest() {
		Assert.assertTrue(acctpage.isSearchFieldExist());
	}

	@Test
	public void accountPageHeadersCountTest() {
		Assert.assertEquals(acctpage.getAccountHeaders().size(), AppConstants.ACCOUNT_PAGE_HEADERS_COUNT);

	}

	@Test
	public void accountPageHeadersTest() {

		List<String> ActualHeaderList = acctpage.getAccountHeaders();
		Collections.sort(ActualHeaderList);
		List<String> ExpectedHeaderList = AppConstants.Account_PAGE_HEADER_LIST;
		Collections.sort(ExpectedHeaderList);

		Assert.assertEquals(ActualHeaderList, ExpectedHeaderList);

	}
	@Test
	public void accountPageLinksCountTest() {
		Assert.assertEquals(acctpage.getLinks().size(), AppConstants.ACCOUNT_PAGE_Links_COUNT);

	}
	@Test
	public void serachTest() {
		searchResultPage=acctpage.doSearch("MacBook");
		productInfoPage=searchResultPage.selectProduct("MacBook Pro");
		String ActualProductHeader=productInfoPage.getProductHeaderName();
		Assert.assertEquals(ActualProductHeader, "MacBook Pro");
	}

}
