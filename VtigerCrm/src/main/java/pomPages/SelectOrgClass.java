package pomPages;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectOrgClass {
	WebDriver driver;

	public SelectOrgClass(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='search_text']")
	private WebElement searchBar;

	@FindBy(name = "search")
	private WebElement searchBtn;

	@FindBy(xpath = "//a[text()='org']")
	private WebElement orgname;

	// business logic
	public void selectOrg(String org) throws InterruptedException {
		String parentID = driver.getWindowHandle();
		Set<String> childIDs = driver.getWindowHandles();
		childIDs.remove(parentID);
		for (String id : childIDs) {
			driver.switchTo().window(id);
			{
				if (driver.getTitle().contains("null"));
					
			}
		}
		searchBar.sendKeys(org);
		searchBtn.click();
		orgname.click();
		driver.switchTo().window(parentID);
	}

}
