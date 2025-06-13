package com.comcast.crm.contacttest;
import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.genericwebdriverutility.JavaUtility;
import com.comcast.crm.objectrepositoryutility.ContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewContactPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
//@Listeners(com.comcast.crm.listenerutility.ListenerImplementationClass.class)
public class CreateContactTest extends BaseClass {
	@Test
public static void createContactTest () throws IOException {

System.out.println("createContactTest Strart");
			ExcelUtility elib=new ExcelUtility();
		    JavaUtility jlib=new JavaUtility();
		    
			//read data from excel
			String LastName=elib.getDataFromExcel("Contact",1,2) + jlib.getRandomNmber() ;
			
		   HomePage hp=new HomePage(sdriver);
		    hp.getContactLink().click();
		    
		    ContactPage cp=new ContactPage(sdriver);
		    cp.getCreateNewContactBtn().click();;
		    
		    CreatingNewContactPage cnp=new CreatingNewContactPage(sdriver);
		    cnp.createNewContact(LastName);
		    
		    //verify Header lastname into expected result
		    String actualLastName = sdriver.findElement(By.id("dtlview_Last Name")).getText();
		    Assert.assertEquals(true, actualLastName.equals(LastName));
			/*
			 * if(actualLastName.equals(LastName)) { System.out.println(LastName+
			 * " contact is created==PASS"); } else { System.out.println(LastName+
			 * " contact is not created==FAIL"); }
			 */
		    System.out.println("createContactTest end");

}
}
