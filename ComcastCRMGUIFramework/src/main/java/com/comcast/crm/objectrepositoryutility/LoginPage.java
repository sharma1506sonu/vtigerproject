package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.genericwebdriverutility.WebDriverUtility;


public class LoginPage extends WebDriverUtility{  
	//Rule-1 create a separate java class
	//Rule-2 Object creation
	public WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(name="user_name")
	private WebElement usernameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindAll({@FindBy(id="submitButton"), @FindBy(xpath = "//input[@value='login']")})
	private WebElement loginBtn;
	
	
	// Rule-3 Object Initialization
	
	
		//Rule-4 Object encapsulation

	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	
	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	// step-5 provide actions[// business logic]
	
	public void loginToApp(String url, String username, String password) {
		maximizeWindow(driver);
		waitForPageToLoad(driver);
		driver.get(url);
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();
	}
	
}

