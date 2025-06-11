package com.comcast.crm.objectrepositoryutility;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewOrganizationPage {

	public CreatingNewOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	@FindBy(name="accountname")
	private WebElement orgNameEdt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(name="industry")
    private WebElement industryDB;
	@FindBy(name="accounttype")
    private WebElement industryType;
    
	@FindBy(id="phone")
	private WebElement phoneNumber;
	
    public WebElement getPhoneNumber() {
		return phoneNumber;
	}


	public WebElement getIndustryDB() {
		return industryDB;
	}

	public WebElement getIndustryType() {
		return industryType;
	}
	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}
    
	public WebElement getPhoneNmber() {
		return phoneNumber;
	}
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public void createOrg(String orgName) {
		orgNameEdt.sendKeys(orgName);
		saveBtn.click();
		
	
	}
	
	public void createOrg(String orgName, String industry, String Type) {
		orgNameEdt.sendKeys(orgName);
		Select sel=new Select(industryDB);
		sel.selectByVisibleText(industry);
		 Select s2=new Select(industryType);
		  s2.selectByVisibleText(Type);
		saveBtn.click();
	}
	
	public void createOrg(String orgName, String phone) {
		orgNameEdt.sendKeys(orgName);
	    phoneNumber.sendKeys(phone);
		saveBtn.click();
	}
	
}
