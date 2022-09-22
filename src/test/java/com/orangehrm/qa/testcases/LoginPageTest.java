package com.orangehrm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangehrm.qa.base.TestBase;
import com.orangehrm.qa.pages.HomePage;
import com.orangehrm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();	
	}
	
	@Test(priority = 0)
	public void loginPageTitleTest() {
		String title = loginPage.validatingLoginPageTitle();
		Assert.assertEquals(title, "OrangeHRM");
	}
	
	@Test(priority = 1)
	public void orangeHrmLogoTest() {
		boolean isLogoDisplayed = loginPage.validateOrangeHrmImage();
		Assert.assertTrue(isLogoDisplayed);
	}
	
	@Test(priority = 2)
	public void loginTest() {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
