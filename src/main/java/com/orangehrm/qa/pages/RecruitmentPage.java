package com.orangehrm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.orangehrm.qa.base.TestBase;

public class RecruitmentPage extends TestBase{
	
	@FindBy(xpath="//select[@id='candidateSearch_jobTitle']")
	WebElement jobTitle_dropdown;
	
	@FindBy(id="btnSrch")
	WebElement searchBtn;
	
	@FindBy(id="btnAdd")
	WebElement addBtn;
	
	public RecruitmentPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void verifyCandidateSearch() {
		Select select = new Select(jobTitle_dropdown);
		select.selectByVisibleText("Tester");
		searchBtn.click();
	}
	
	public boolean selectingCandidates(String name) {
		driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]//parent::td[@class='left']//preceding-sibling::td//input")).click();
		return driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]//parent::td[@class='left']//preceding-sibling::td//input")).isSelected();
	}
	
	public void clickOnAddBtn() {
		addBtn.click();
	}
	
	public void addCandidate(String firstName, String lastName, String email, String job) {
		driver.findElement(By.id("addCandidate_firstName")).sendKeys(firstName);
		driver.findElement(By.id("addCandidate_lastName")).sendKeys(lastName);
		driver.findElement(By.id("addCandidate_email")).sendKeys(email);
		Select jobVacancy = new Select(driver.findElement(By.id("addCandidate_vacancy")));
		jobVacancy.selectByVisibleText(job);
		driver.findElement(By.id("btnSave")).click();
	}

}
