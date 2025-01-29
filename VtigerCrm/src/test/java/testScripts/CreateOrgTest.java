package testScripts;

import org.testng.annotations.Test;
import genericLibrary.BaseTest;
import pomPages.HomePageClass;
import pomPages.OrganisationClass;

public class CreateOrgTest extends BaseTest{
	@Test
	public void createOrgTest() throws Exception {
		
		//organisation link
		HomePageClass hp = new HomePageClass(driver);
		hp.orgPageLink();
		
		//create Org
		OrganisationClass ogc=new OrganisationClass(driver);
		String OrgName = flib.getDataFromExcelSheet(EXCELPATH, ORGSHEET, 1,0);
		ogc.createOrg(OrgName);
	
		
	}
	@Test
	public void createOrgWithIndustry() throws Exception {
		//organisation link
		HomePageClass hp = new HomePageClass(driver);
		hp.orgPageLink();
		
		//create OrgWith Industry
		OrganisationClass ogc=new OrganisationClass(driver);
		String orgName = flib.getDataFromExcelSheet(EXCELPATH, ORGINDSHEET, 1,0);
		String industryName = flib.getDataFromExcelSheet(EXCELPATH, ORGINDSHEET, 1, 1);
	    ogc.createOrgWithIndustry(orgName, industryName);
		
		
	}
	
	@Test
	public void createOrgIndustryWithPhone() throws Exception {
		//organisation link
		HomePageClass hp = new HomePageClass(driver);
		hp.orgPageLink();
	
		//create OrgWith Industry
		OrganisationClass ogc=new OrganisationClass(driver);
		String orgName = flib.getDataFromExcelSheet(EXCELPATH, ORGINDPHONESHEET, 1,0);
		String industryName = flib.getDataFromExcelSheet(EXCELPATH, ORGINDPHONESHEET, 1, 1);
		String phoneNo = flib.getDataFromExcelSheet(EXCELPATH, ORGINDPHONESHEET, 1, 2);
	    ogc.CreateOrgIndustryPhone(orgName,industryName,phoneNo);
		
		
	}
}
