package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactClass {
	WebDriver driver;

	public ContactClass(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement createContactBtn;

	@FindBy(name = "lastname")
	private WebElement lastName;

	@FindBy(xpath = "//img[@title='Select']")
	private WebElement selectOrgPage;

	@FindBy(xpath = "//input[@name='support_start_date']")
	private WebElement startDate;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	public void createCoantactWithLastName(String lastN) {
		createContactBtn.click();
		lastName.sendKeys(lastN);
		saveBtn.click();
	}

	public void createCoantactLastNameOrgName(String lastN, String org) throws InterruptedException {
		createContactBtn.click();
		lastName.sendKeys(lastN);
		selectOrgPage.click();
			SelectOrgClass soc=new SelectOrgClass(driver);
			soc.selectOrg(org);
	    saveBtn.click();
	}

	public void createCoantactWithStartEndDate(String lastN) {
		createContactBtn.click();
		lastName.sendKeys(lastN);
		startDate.clear();
		startDate.sendKeys("2024-12-15");
		saveBtn.click();
	}

}