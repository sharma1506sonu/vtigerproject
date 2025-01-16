package testScripts;

import org.testng.annotations.Test;
import genericLibrary.BaseTest;
import pomPages.ContactClass;
import pomPages.HomePageClass;
import pomPages.LoginClass;

public class CreateContactTest extends BaseTest{
	HomePageClass hp=new HomePageClass(driver);
	@Test
	public void contactWithLastName() throws Exception {
		String username = flib.getDataFromExcelSheet(EXCELPATH, LOGINSHEET, 1,0);
		String password = flib.getDataFromExcelSheet(EXCELPATH, LOGINSHEET, 1, 1);
		
		//login
		LoginClass lp=new LoginClass(driver);
		lp.loginVtiger(username, password);
		
		//organisation link
		
		hp.contactPageLink();
		
		ContactClass cc=new ContactClass(driver);
		String lastName=flib.getDataFromExcelSheet(CONTACTEXCEL,LASTNAME, 1,0);
		cc.createCoantactWithLastName(lastName);
		
	}
	
	@Test
	public void contactWithLastNameOrgName() throws Exception {
		String lastName=flib.getDataFromExcelSheet(CONTACTEXCEL,LASTNAME, 1,0);
		String orgName = flib.getDataFromExcelSheet(EXCELPATH, ORGSHEET, 1,0);

		//organisation link
		hp.contactPageLink();
		
		ContactClass cc=new ContactClass(driver);
		cc.createCoantactLastNameOrgName(lastName,orgName);
		
	}

	@Test
	public void contactWithStartEndDate() throws Exception {
		
		//organisation link
		hp.contactPageLink();
		
		ContactClass cc=new ContactClass(driver);
		String lastName=flib.getDataFromExcelSheet(CONTACTEXCEL,LASTNAME, 1,0);
		
		cc.createCoantactWithStartEndDate(lastName);
		
	}
}
