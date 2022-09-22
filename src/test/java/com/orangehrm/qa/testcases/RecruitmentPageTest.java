package com.orangehrm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.orangehrm.qa.base.TestBase;
import com.orangehrm.qa.pages.HomePage;
import com.orangehrm.qa.pages.LoginPage;
import com.orangehrm.qa.pages.RecruitmentPage;
import com.orangehrm.qa.util.TestUtil;

public class RecruitmentPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	RecruitmentPage recruitmentPage;
	String sheetName = "candidates";
	public RecruitmentPageTest() {
		super();
	}

	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		recruitmentPage = new RecruitmentPage();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage.clickOnRecruitmentTab();
	}
	
	@Test(priority = 1)
	public void candidateSearchTest() {
		recruitmentPage.verifyCandidateSearch();
	}
	
	@Test(priority = 2)
	public void selectingCadidatesTest() {
		boolean isSelected = recruitmentPage.selectingCandidates("Palasa");
		Assert.assertTrue(isSelected);
	}
	
	@DataProvider
	public Object[][] getOrangeHrmCandidatesData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority = 3, dataProvider="getOrangeHrmCandidatesData")
	public void addCandidatesTest(String firstName, String lastName, String email, String job) {
		recruitmentPage.clickOnAddBtn();
		recruitmentPage.addCandidate(firstName, lastName, email, job);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
