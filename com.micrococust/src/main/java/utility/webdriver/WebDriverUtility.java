package utility.webdriver;

import org.openqa.selenium.WebDriver;

public class WebDriverUtility {
	
	public void Alert(WebDriver driver) {
	driver.switchTo().alert().accept();
	}

}
