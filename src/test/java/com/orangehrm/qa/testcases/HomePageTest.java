package com.orangehrm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangehrm.qa.base.TestBase;
import com.orangehrm.qa.pages.HomePage;
import com.orangehrm.qa.pages.LoginPage;
import com.orangehrm.qa.pages.RecruitmentPage;

public class HomePageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	RecruitmentPage recruitmentPage;
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		recruitmentPage = new RecruitmentPage();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void homePageTitleTest() {
		String title = homePage.verifyHomePageTitle();
		Assert.assertEquals(title, "OrangeHRM");
	}
	
	@Test
	public void correctUsernameTest() {
		Assert.assertTrue(homePage.verifyUserName());
	}
	
	@Test
	public void logoutTest() {
		homePage.verifyLogout();
	}
	
	@Test
	public void clickOnRecruitmentTest() {
		recruitmentPage = homePage.clickOnRecruitmentTab();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
