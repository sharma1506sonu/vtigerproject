package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageClass extends BaseClass {

	public HomePageClass(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(linkText = "Organizations")
	public WebElement organizationpageLink;

	public WebElement getOrganizationPageLink() {
		return getOrganizationPageLink();
	}

	@FindBy(linkText = "Contacts")
	public WebElement contactPageLink;

	public WebElement getContactPageLink() {
		return contactPageLink;
	}

	// business logic
	public void orgPageLink() {
		organizationpageLink.click();
	}

	public void clickContactPageLink() {
		contactPageLink.click();
	}

	public void signOutLink() {

	}
}
