package com.comcast.crm.orgtest;


import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;

import com.comcast.crm.genericwebdriverutility.JavaUtility;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationPage;

@Listeners(com.comcast.crm.listenerutility.ListenerImplementationClass.class)
public class CreateOrgWithIndustryTest extends BaseClass {
	@Test ( groups= "smokeTest")
	public  void createOrgWithIndustryTest() throws IOException {
		// read data from properties file
				ExcelUtility elib=new ExcelUtility();
			    JavaUtility jlib=new JavaUtility();
			
			    
				
				//read data from excel
				
				String industryName=elib.getDataFromExcel("OrgData",4,3);
				
				String industryType=elib.getDataFromExcel("OrgData",4,4) ;
			
				
		
	    
	            // navigate to org module
				String OrgName=elib.getDataFromExcel("OrgData",4,2) + jlib.getRandomNmber();
				
			    // step-2: navigate to organization module
			    HomePage hp=new HomePage(sdriver);
			    hp.getOrgLink().click();
			    
			    
			    OrganizationPage op=new OrganizationPage(sdriver);
			    op.getCreateNewOrgBtn().click();
			    
			    
			    // step-3: enter all the details and create new organization
			    CreatingNewOrganizationPage cop=new CreatingNewOrganizationPage(sdriver);
			    cop.createOrg(OrgName,industryName, industryType);;
				  
				//  sdriver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
	    //verify the industry and type info
	    String actualIndustry = sdriver.findElement(By.id("dtlview_Industry")).getText();
	    Assert.assertEquals(true, actualIndustry.equals(industryName));
		/*
		 * if(actualIndustry.equals(industryName)) { System.out.println(industryName+
		 * " information  is verified==PASS"); } else { System.out.println(industryName+
		 * " information is not verified==FAIL"); }
		 */
		   String actualType = sdriver.findElement(By.id("dtlview_Type")).getText();
		   Assert.assertEquals(true, actualType.equals(industryType) );
		/* if(actualType.equals(industryType)) { System.out.println(industryType+
		 * " information  is verified==PASS"); } else { System.out.println(industryType+
		 * " information is not verified==FAIL"); }
		 */
	    
	}
}
