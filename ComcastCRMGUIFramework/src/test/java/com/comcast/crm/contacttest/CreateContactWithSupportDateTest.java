package com.comcast.crm.contacttest;


import java.io.IOException;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.genericwebdriverutility.JavaUtility;
import com.comcast.crm.listenerutility.ListenerImplementationClass;
import com.comcast.crm.objectrepositoryutility.ContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewContactPage;
import com.comcast.crm.objectrepositoryutility.HomePage;

@Listeners(ListenerImplementationClass.class)
public class CreateContactWithSupportDateTest extends BaseClass {
	@Test
public static void createContactWithSupportDateTest() throws IOException {
	ExcelUtility elib = new ExcelUtility();
	JavaUtility jlib = new JavaUtility();

	//read data from excel
	String LastName=elib.getDataFromExcel("Contact",4,2) + jlib.getRandomNmber() ;
			HomePage hp=new HomePage(sdriver);
			hp.getContactLink().click();
			
		    String startDate = jlib.getSystemDate();
		    String endDate = jlib.getRequiredDate(30);
		    ContactPage cp=new ContactPage(sdriver);
		    cp.getCreateNewContactBtn().click();;
		    
		    CreatingNewContactPage cnp=new CreatingNewContactPage(sdriver);
		    cnp.createNewContactWithSupportDate(LastName, startDate, endDate);
		    
		    //verify Header lastname into expected result
		    String actualLastName = sdriver.findElement(By.id("dtlview_Last Name")).getText();
		    Assert.assertEquals(true, actualLastName.equals(LastName));
			/*
			 * if(actualLastName.equals(LastName)) { System.out.println(LastName+
			 * " contact is created==PASS"); } else { System.out.println(LastName+
			 * " contact is not created==FAIL"); }
			 */
		    
		    //verify start date and end date
		    String startD = sdriver.findElement(By.id("dtlview_Support Start Date")).getText();
		    Assert.assertEquals(true, startDate.equals(startD));
		    
			/*
			 * if(startDate.equals(startD)) { System.out.println(startDate+
			 * " is verified==PASS"); } else { System.out.println(startDate+
			 * " is not verified==FAIL"); }
			 */
		    
		    String endD = sdriver.findElement(By.id("dtlview_Support End Date")).getText();
		    Assert.assertEquals(true, endDate.equals(endD));
		    
			/*
			 * if(endDate.equals(endD)) { System.out.println(endDate+ " is verified==PASS");
			 * } else { System.out.println(endDate+ " is not verified==FAIL"); }
			 */
}
}
