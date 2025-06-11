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
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationPage;
@Listeners(com.comcast.crm.listenerutility.ListenerImplementationClass.class)
public class CreateContactWithOrgTest extends BaseClass {
	@Test
	public static void createContactWithOrgTest() throws IOException {
		ExcelUtility elib = new ExcelUtility();
		JavaUtility jlib = new JavaUtility();
	
		// read data from excel
		String LastName = elib.getDataFromExcel("Contact", 7, 2) + jlib.getRandomNmber();

		String OrgName = elib.getDataFromExcel("Contact", 7, 3) + jlib.getRandomNmber();

		HomePage hp = new HomePage(sdriver);
		hp.getOrgLink().click();

		OrganizationPage op = new OrganizationPage(sdriver);
		op.getCreateNewOrgBtn().click();

		// step-3: enter all the details and create new organization
		CreatingNewOrganizationPage cop = new CreatingNewOrganizationPage(sdriver);
		cop.createOrg(OrgName);

		String headerInfo = sdriver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		Assert.assertEquals(true, headerInfo.contains(OrgName));
		/*
		 * if (headerInfo.contains(OrgName)) { System.out.println(OrgName +
		 * " is created==PASS"); } else { System.out.println(OrgName +
		 * " is not created==FAIL"); }
		 */
		hp.getContactLink().click();

		ContactPage cp = new ContactPage(sdriver);
		cp.getCreateNewContactBtn().click();

		CreatingNewContactPage cnp = new CreatingNewContactPage(sdriver);
		cnp.createNewContactWithOrg(sdriver,LastName,OrgName);

		// verify Header orgname into expected result
		String headerMsg = sdriver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		Assert.assertEquals(true, headerMsg.contains(LastName));
		
		/*
		 * if (headerMsg.contains(LastName)) { System.out.println(LastName +
		 * " header verified==PASS"); } else { System.out.println(LastName +
		 * " header is verified==FAIL"); }
		 */
		// verify Header orgname into expected result
		String actualOrgName = sdriver.findElement(By.id("mouseArea_Organization Name")).getText();
		Assert.assertEquals(true, actualOrgName.trim().equals(OrgName));
		/*
		 * if (actualOrgName.trim().equals(OrgName)) { System.out.println(OrgName +
		 * " is verified==PASS"); } else { System.out.println(OrgName +
		 * " is verified==FAIL"); }
		 */
	}
}
