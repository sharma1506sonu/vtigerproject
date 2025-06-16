package com.comcast.crm.basetest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.io.IOException;
import java.sql.SQLException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.genericwebdriverutility.UtilityClassObject;
import com.comcast.crm.genericwebdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class BaseClass {
	
	  
	  public FileUtility fLib=new FileUtility();
	  public WebDriverUtility wbLib=new WebDriverUtility();
	  public DataBaseUtility dbLib=new DataBaseUtility();
	  WebDriver driver=null;
	  public static WebDriver sdriver=null;
	  
	@BeforeSuite
	public void configBeforeSuite() throws SQLException {
	dbLib.getDBConnection();
	System.out.println("=======Server connected DB successfully=====");
	
	}
 //   @Parameters("BROWSER")
	@BeforeClass
	public void configBeforeClass() throws IOException {
//    	public void configBeforeClass(String BROWSER) throws IOException {
		String BROWSER = fLib.getDataFromPropertiesFile("browser");
		    
		    if(BROWSER.equals("chrome")) {
		    	driver=new ChromeDriver();
		    }
		    
		    else if(BROWSER.equals("firefox")) {
		    	driver=new FirefoxDriver();
		    }
		    
		    else if(BROWSER.equals("edge")) {
		    	driver=new EdgeDriver();
		    }
		    else {
		    	driver=new ChromeDriver();
		    }
		    sdriver=driver;
		    UtilityClassObject.setDriver(driver);
		    System.out.println("=======browser launched successfully=====");
		
	}

	@BeforeMethod
	public void login() throws IOException {
      
        String URL = fLib.getDataFromPropertiesFile("url");
		String USERNAME = fLib.getDataFromPropertiesFile("username");
		String PASSWORD = fLib.getDataFromPropertiesFile("password");

		// login
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(URL, USERNAME, PASSWORD);
		 System.out.println("====login===");
	}

	@AfterMethod
	public void logout() {
		HomePage hp=new HomePage(driver);
		hp.logout();
		System.out.println("===logout===");
	}

	@AfterClass
	public void configAfterClass() throws SQLException {
    	driver.close();
		System.out.println("Browser closed successfully");
	}

	
	@AfterSuite
	public void toCloseDB() throws SQLException {
		dbLib.closeDataBaseConnection();
		System.out.println("DB closed successfully");
		
	}
}
