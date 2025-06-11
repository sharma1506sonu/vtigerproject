package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
	   WebDriver driver;
		public ContactInfoPage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver,this);
		}
		
		@FindBy(className = "dvHeaderText")
		private WebElement headerMsg;
		
		@FindBy(id="dtlview_Last Name")
		private WebElement VerifyContact;
	

		public WebElement getHeaderMsg() {
			return headerMsg;
		}

		public WebElement getVerifyContact() {
			return VerifyContact;
		}
		
		
}
