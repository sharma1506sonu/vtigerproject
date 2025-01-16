package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OrganisationClass {

	public OrganisationClass(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement CreateOrganisation;

	@FindBy(name = "accountname")
	private WebElement OrgName;

	@FindBy(xpath = "//select[@name='industry']")
	private WebElement IndustryDropdown;

	@FindBy(id = "phone")
	private WebElement phoneTextfield;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	// Business logic
	public void createOrg(String org) {
		CreateOrganisation.click();
		OrgName.sendKeys(org);
		saveBtn.click();

	}

	public void createOrgWithIndustry(String org, String industry) throws InterruptedException {
		CreateOrganisation.click();
		OrgName.sendKeys(org);
		Select s = new Select(IndustryDropdown);
		s.selectByVisibleText(industry);
		saveBtn.click();
	}

	public void CreateOrgIndustryPhone(String org, String industry, String phoneNo) {
		CreateOrganisation.click();
		OrgName.sendKeys(org);
		Select s = new Select(IndustryDropdown);
		s.selectByVisibleText(industry);
		phoneTextfield.sendKeys(phoneNo);
		saveBtn.click();
	}
}
