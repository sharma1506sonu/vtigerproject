package testScripts;

import org.testng.annotations.Test;
import genericLibrary.BaseTest;
import pomPages.ContactClass;
import pomPages.HomePageClass;

public class CreateContactTest extends BaseTest{
	@Test
	public void contactWithLastName() throws Exception {
		
		// organization link
		HomePageClass hp = new HomePageClass(driver);
		hp.clickContactPageLink();
		
		ContactClass cc=new ContactClass(driver);
		String lastName=flib.getDataFromExcelSheet(CONTACTEXCEL,LASTNAME, 1,0);
		cc.createCoantactWithLastName(lastName);
		
	}
	
	@Test
	public void contactWithLastNameOrgName() throws Exception {
		String lastName=flib.getDataFromExcelSheet(CONTACTEXCEL,LASTNAME, 1,0);
		String orgName = flib.getDataFromExcelSheet(EXCELPATH, ORGSHEET, 1,0);

		//organisation link
		HomePageClass hp = new HomePageClass(driver);
		hp.clickContactPageLink();
		
		ContactClass cc=new ContactClass(driver);
		cc.createCoantactLastNameOrgName(lastName,orgName);
		
	}

	@Test
	public void contactWithStartEndDate() throws Exception {
		
		//organisation link
		HomePageClass hp = new HomePageClass(driver);
		hp.clickContactPageLink();
		
		ContactClass cc=new ContactClass(driver);
		String lastName=flib.getDataFromExcelSheet(CONTACTEXCEL,LASTNAME, 1,0);
		
		cc.createCoantactWithStartEndDate(lastName);
		
	}
}
