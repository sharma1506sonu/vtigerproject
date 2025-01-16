package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageClass {

	public HomePageClass(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Organizations")
	private WebElement organizationpageLink;

	public WebElement getOrganizationPageLink() {
		return getOrganizationPageLink();
	}

	@FindBy(linkText = "Contacts")
	private WebElement contactPageLink;

	public WebElement getContactPageLink() {
		return contactPageLink;
	}

	// business logic
	public void orgPageLink() {
		organizationpageLink.click();
	}

	public void contactPageLink() {
		contactPageLink.click();
	}

	public void signOutLink() {

	}
}
