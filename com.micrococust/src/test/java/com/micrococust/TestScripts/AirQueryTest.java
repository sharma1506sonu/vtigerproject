package com.micrococust.TestScripts;

import org.testng.annotations.Test;
import pomPages.*;
import utility.webdriver.WebDriverUtility;

public class AirQueryTest extends com.micrococustbasetest.BaseClass {

    @Test
    public void airQuerySubmissionTest() throws InterruptedException {
        HomePage home = new HomePage(driver);
        home.openLoginPopup();

        LoginPage login = new LoginPage(driver);
        login.login("devops5@aaa2innovate.com", "@cupcake3#");
        
        WebDriverUtility wUtil=new WebDriverUtility();
        wUtil.Alert(driver);

        AirQuerryPage airQuery = new AirQuerryPage(driver);
        airQuery.submitAirQuery(
                "DEL", "DXB", "100", "5",
                "25-12-2025", "Electronics"
        );
    }
}
