package com.orangehrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//page object repository
	@FindBy(id="txtUsername")
	@CacheLookup
	WebElement username;
	
	@FindBy(id="txtPassword")
	WebElement password;
	
	@FindBy(id="btnLogin")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[contains(text(),'Forgot your password?')]")
	WebElement forgotPassword;
	
	@FindBy(xpath="//img[@src='/symfony/web/webres_6315bbebe9e877.26918613/themes/default/images/login/logo.png']")
	WebElement orangeHrmLogo;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validatingLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateOrangeHrmImage() {
		return orangeHrmLogo.isDisplayed();
	}
	
	public HomePage login(String uname, String pwd) {
		username.sendKeys(uname);
		password.sendKeys(pwd);
		loginBtn.click();	
		return new HomePage();
	}
}
