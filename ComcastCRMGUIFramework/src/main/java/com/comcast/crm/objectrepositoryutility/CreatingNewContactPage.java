package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.genericwebdriverutility.WebDriverUtility;

public class CreatingNewContactPage extends WebDriverUtility{
	public CreatingNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="lastname")
	private WebElement lastNameEdt;
	
	@FindBy (xpath ="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(name="accountname")
	private WebElement orgNameEdt;
	
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img")
	private WebElement selectOrgBtn;

	@FindBy(name = "search_text")
	private WebElement searchBar;

	@FindBy(name = "search")
	private WebElement searchBtn;
	
	 @FindBy (name="support_start_date")
	 private WebElement supportStartDateTextField;
	 
	 @FindBy(name="support_end_date")
	 private WebElement supportEndDateTextField;

	public WebElement getLastName() {
		return lastNameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}

	public WebElement getSearchBar() {
		return searchBar;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
	public WebElement getSupportStartDateTextField() {
		return supportStartDateTextField;
	}

	public WebElement getSupportEndDateTextField() {
		return supportEndDateTextField;
	}
	
	public void createNewContact(String lastName) {
		lastNameEdt.sendKeys(lastName);
		saveBtn.click();
	}
	
	public void createNewContactWithOrg(WebDriver driver, String lastName, String OrgName) {
		lastNameEdt.sendKeys(lastName);
		selectOrgBtn.click();
		switchToTabOnURL(driver, "module=Accounts");
		searchBar.sendKeys(OrgName);
		searchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+OrgName+"']")).click();
		switchToTabOnURL(driver, "module=Contacts");
		saveBtn.click();
	}

	public void createNewContactWithSupportDate(String lastName,String startDate, String EndDate) {
		lastNameEdt.sendKeys(lastName);
		supportStartDateTextField.clear();
		supportStartDateTextField.sendKeys(startDate);
		supportEndDateTextField.clear();
		supportEndDateTextField.sendKeys(EndDate);
		saveBtn.click();
	}

}
