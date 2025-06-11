package com.comcast.crm.orgtest;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import com.aventstack.extentreports.Status;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.genericwebdriverutility.JavaUtility;
import com.comcast.crm.genericwebdriverutility.UtilityClassObject;
import com.comcast.crm.listenerutility.ListenerImplementationClass;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationPage;

@Listeners(ListenerImplementationClass.class)
public class CreateOrgTest extends BaseClass {
	
	@Test( groups= "smokeTest")
	public void createOrgTest() throws EncryptedDocumentException, IOException {
	    ExcelUtility eLib=new ExcelUtility();
	    JavaUtility jLib=new JavaUtility();
	    
	    UtilityClassObject.getTest().log(Status.INFO, "read data from excel");
	    
		// Step-1: read data from excel
		String OrgName=eLib.getDataFromExcel("OrgData",1,2) + jLib.getRandomNmber();
	
		
	    // step-2: navigate to organization module
		UtilityClassObject.getTest().log(Status.INFO, "navigate to org page");
	    HomePage hp=new HomePage(sdriver);
	    hp.getOrgLink().click();
	    
	    UtilityClassObject.getTest().log(Status.INFO, "navigate to create org page");
	    OrganizationPage op=new OrganizationPage(sdriver);
	    op.getCreateNewOrgBtn().click();
	    
	    
	    // step-3: enter all the details and create new organization
	    UtilityClassObject.getTest().log(Status.INFO, "create org");
	    CreatingNewOrganizationPage cop=new CreatingNewOrganizationPage(sdriver);
	    cop.createOrg(OrgName);
	    UtilityClassObject.getTest().log(Status.INFO,OrgName+ " created");
	    
	    // step-4: verify header message
	    OrganizationInfoPage oip=new OrganizationInfoPage(sdriver);
	    String headerInfo = oip.getHeaderMsg().getText();
	    
        Assert.assertEquals(true,headerInfo.contains(OrgName));
		/*
		 * if(headerInfo.contains(OrgName)) { System.out.println(OrgName+
		 * " is created==PASS"); } else { System.out.println(OrgName+
		 * " is not created==FAIL"); }
		 */
	    // step-6: verify Header organization name into expected result
	    String actualOrgName=oip.getVerifyOrg().getText();
	    //String actualOrgName = sdriver.findElement(By.id("dtlview_Organization Name")).getText();
	    Assert.assertEquals(true,actualOrgName.equals(OrgName));
		/*
		 * if(actualOrgName.equals(OrgName)) {
		 * 
		 * System.out.println(OrgName+ " is verified==PASS"); } else {
		 * System.out.println(OrgName+ " is verified==FAIL"); }
		 */
	  
	}
}
