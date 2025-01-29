package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginClass extends BaseClass{

	public LoginClass(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(name = "user_name")
	private WebElement userName;

	@FindBy(name = "user_password")
	private WebElement password;

	@FindBy(id = "submitButton")
	private WebElement loginBtn;

	// Bussiness logic
	public void loginVtiger(String un, String pass) {
		userName.sendKeys(un);
		password.sendKeys(pass);
		loginBtn.click();

	}

}
