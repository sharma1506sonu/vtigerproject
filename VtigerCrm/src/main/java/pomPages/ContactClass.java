package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import genericLibrary.WebDriverUtility;

public class ContactClass extends BaseClass{
	public ContactClass(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement createContactBtn;

	@FindBy(name = "lastname")
	private WebElement lastName;

	@FindBy(xpath = "//img[@title='Select']")
	private WebElement selectOrgPage;
	
	@FindBy(xpath = "//input[@name='search_text']")
	private WebElement searchBar;

	@FindBy(name = "search")
	private WebElement searchBtn;

	@FindBy(xpath = "//a[text()='org']")
	private WebElement orgname;

	@FindBy(xpath = "//input[@name='support_start_date']")
	private WebElement startDate;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	public void createCoantactWithLastName(String lastN) {
		createContactBtn.click();
		lastName.sendKeys(lastN);
		saveBtn.click();
	}

	public void createCoantactLastNameOrgName(String lastN,String org) throws InterruptedException {
		createContactBtn.click();
		lastName.sendKeys(lastN);
		selectOrgPage.click();
		WebDriverUtility wdl=new WebDriverUtility(driver);
		wdl.toSwitchWindows("module=Accounts");
		searchBar.sendKeys(org);
		searchBtn.click();
		orgname.click();
		wdl.toSwitchWindows("module=Contacts&action");
	    saveBtn.click();
	}


	public void createCoantactWithStartEndDate(String lastN) {
		createContactBtn.click();
		lastName.sendKeys(lastN);
		startDate.clear();
		startDate.sendKeys("2025-01-28");
		saveBtn.click();
	}

}