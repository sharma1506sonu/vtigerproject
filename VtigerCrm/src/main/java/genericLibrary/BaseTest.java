package genericLibrary;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import pomPages.HomePageClass;
import pomPages.LoginClass;
import pomPages.LogoutClass;

public class BaseTest implements IAutoConstant {
	public WebDriver driver;
	public FileLib flib = new FileLib();
	public HomePageClass hp = new HomePageClass(driver);
	
	

	@BeforeSuite
	public void toConnectServer() {
		Reporter.log("=======Server connected successfully=====", true);
	}

	@BeforeTest
	public void toConnectDatabase() {
		Reporter.log("======Connected to database successfully=====", true);
	}

	@BeforeClass
	public void setUp() throws IOException {
		String browser = flib.getDataFromProperty(PROP_PATH, "browser");
		String url = flib.getDataFromProperty(PROP_PATH, "url");
		Reporter.log(browser, true);

		if (browser.equalsIgnoreCase("chrome"))
			driver = new ChromeDriver();
		else if (browser.equalsIgnoreCase("firefox"))
			driver = new FirefoxDriver();
		else if (browser.equalsIgnoreCase("edge"))
			driver = new EdgeDriver();
		else
			Reporter.log("invalid browser", true);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMESECONDS));
		driver.get(url);
	}

	@BeforeMethod
	public void login() throws Exception {

		String username = flib.getDataFromExcelSheet(EXCELPATH, LOGINSHEET, 1, 0);
		String password = flib.getDataFromExcelSheet(EXCELPATH, LOGINSHEET, 1, 1);

		// login
		LoginClass lp = new LoginClass(driver);
		lp.loginVtiger(username, password);
		Reporter.log("Login successfully", true);
	}

	@AfterMethod
	public void signout() {
		LogoutClass ls = new LogoutClass(driver);
		ls.signOut();
		Reporter.log("Logout successfully", true);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
		Reporter.log("Browser closed successfully", true);
	}

	@AfterTest
	public void toCloseDatabase() {
		Reporter.log("===Database closed successfully===");
	}

	@AfterSuite
	public void toCloseServer() {
		Reporter.log("===Server closed successfully===");
	}
}
