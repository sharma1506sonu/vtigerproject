package utility.webdriver;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebDriverUtility {
	
	public void Alert(WebDriver driver) {
	driver.switchTo().alert().accept();
	}
   
	public void javascriptExecutorScroll(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500)"); 

	}
	
	public void javascriptExecutorClick(WebDriver driver, WebElement element) {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].click();",element);
	}
	
}
