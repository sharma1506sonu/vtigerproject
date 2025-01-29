package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LogoutClass extends BaseClass {
	public LogoutClass(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	WebDriver driver;	
	@FindBy (xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement signoutArea;
	
	@FindBy (xpath="//a[text()='Sign Out']")
	private WebElement signoutBtn;
	
	//business logic
	
	public void signOut() {
		Actions act=new Actions(driver);
		act.moveToElement(signoutArea).perform();
		signoutBtn.click();
	}
}
