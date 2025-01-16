package testScripts;

import org.testng.annotations.Test;

import genericLibrary.BaseTest;
import pomPages.HomePageClass;


public class HomePageTest extends BaseTest {
@Test
public void homePageTest() throws Exception {
	
	HomePageClass hp=new HomePageClass(driver);
	hp.orgPageLink();
	hp.contactPageLink();

}
}
