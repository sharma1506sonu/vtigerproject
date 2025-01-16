package genericLibrary;
	import java.time.Duration;
	import java.util.Set;

	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.WebDriverWait;

	public class WebDriverUtility {
		WebDriver driver;
		WebDriverWait wait;
		Actions act;
		
		public WebDriverUtility(WebDriver driver){
			this.driver = new ChromeDriver();
			this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
			this.act = new Actions(driver);
		}
		/**
		 * This method is used to maximize screen.
		 */
		public void maximize() {
			driver.manage().window().maximize();
		}
		public void minimize() {
			driver.manage().window().minimize();
		}
		
		public void waitForElement(long time) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
		}
		
		public void handleDropDown(WebElement dropdown,int index) {
			Select s =new Select(dropdown);
			s.selectByIndex(index);
		}
		
		public void handleDropDown(WebElement dropdown,String text) {
			Select s =new Select(dropdown);
			s.selectByVisibleText(text);
		}
		
		public void handleDropDown(String value,WebElement dropdown) {
			Select s =new Select(dropdown);
			s.selectByValue(value);
		}
		public void todoubleClick(WebElement element) {
	         Actions a =new Actions(driver);
			
			a.doubleClick(element).perform();
			
		}
		
		public void toRightClick(WebElement element) {
	        Actions a =new Actions(driver);
			
	        a.contextClick(element).perform();
		}
		public void toDragAndDrop(WebElement src,WebElement dest) {
	        Actions a =new Actions(driver);
			
	        a.dragAndDrop(src, dest).perform();
			
		}
		public void clickAndHold(WebElement element) {
	        Actions a =new Actions(driver);
			
			a.clickAndHold(element).perform();
			a.release().perform();
		}
		public void toMouseHover(WebElement element) {
	        Actions a =new Actions(driver);
	        a.moveToElement(element).perform();
			
		}
		public void toSwitchFrameId(String id) {
			driver.switchTo().frame(id);
		}
		
		public void toSwitchFrameName(String name) {
			driver.switchTo().frame(name);
		}
		public void toSwitchFrame(WebElement element) {
			driver.switchTo().frame(element);
		}
		public void switchToParentFrame() {
			driver.switchTo().parentFrame();
		}
		
		public void switchToDefaultFrame() {
			driver.switchTo().defaultContent();
		}
		
		public void switchToAlert() {
			driver.switchTo().alert();
		}
		public void acceptAlert() {
			driver.switchTo().alert().accept();
		}
		
		public void dismissAlert() {
			driver.switchTo().alert().dismiss();
		}
		
		public void toSwitchWindows(String partialTitle) {
			Set<String> winIDs = driver.getWindowHandles();
			for (String x : winIDs) {
				driver.switchTo().window(x);
				if(driver.getTitle().contains(partialTitle));
					break;
			}

		}
		
		public void toscrollWindow(WebElement element) {
			JavascriptExecutor j=(JavascriptExecutor) driver;
			j.executeScript("arguments[0].scrollIntoView(true)",element);
		}
		
	}




