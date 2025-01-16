package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginClass {

	public LoginClass(WebDriver driver) {
		PageFactory.initElements(driver, this);
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
