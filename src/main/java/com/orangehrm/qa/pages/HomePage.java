package com.orangehrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(id="welcome")
	WebElement welcome;
	
	@FindBy(xpath="//a[@id='welcome']")
	WebElement logout;
	
	@FindBy(xpath="//a[@id='menu_recruitment_viewRecruitmentModule']")
	WebElement recruitmentTab;
	
	@FindBy(linkText="Candidates")
	WebElement candidates;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyUserName() {
		String user = welcome.getText();
		return user.contains("Suresh Babu");
	}
	
	public LoginPage verifyLogout() {
		welcome.click();
		logout.click();
		return new LoginPage();
	}
	
	public RecruitmentPage clickOnRecruitmentTab() {
		Actions action = new Actions(driver);
		action.moveToElement(recruitmentTab).build().perform();
		candidates.click();
		return new RecruitmentPage();
	}

}
