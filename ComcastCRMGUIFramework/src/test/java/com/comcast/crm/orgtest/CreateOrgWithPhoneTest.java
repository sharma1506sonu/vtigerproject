package com.comcast.crm.orgtest;

import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.genericwebdriverutility.JavaUtility;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationPage;

public class CreateOrgWithPhoneTest extends BaseClass {
	@Test ( groups= "regressionTest")
	public static void createOrgWithPhoneTest() throws IOException {
		// read data from properties file
				ExcelUtility elib=new ExcelUtility();
			    JavaUtility jlib=new JavaUtility();
			    
				
				//read data from excel
				String OrgName=elib.getDataFromExcel("OrgData",7,2) + jlib.getRandomNmber();
				String Phone=elib.getDataFromExcel("OrgData",7,3);
				
				HomePage hp = new HomePage(sdriver);
				hp.getOrgLink().click();
		
				 
			    OrganizationPage op=new OrganizationPage(sdriver);
			    op.getCreateNewOrgBtn().click();
			    
			    
			    
			    // step-3: enter all the details and create new organization
			    CreatingNewOrganizationPage cop=new CreatingNewOrganizationPage(sdriver);
			    cop.createOrg(OrgName,Phone);
	   
	    //verify Header phone number into expected result
	    String actualPhoneNum = sdriver.findElement(By.id("dtlview_Phone")).getText();
	    Assert.assertEquals(true, actualPhoneNum.equals(Phone));
		/*
		 * if(actualPhoneNum.equals(Phone)) { System.out.println(Phone+
		 * " is created==PASS"); } else { System.out.println(Phone+
		 * " is not created==FAIL"); }
		 */
	    
	}
}
