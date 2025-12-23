package com.micrococust.TestScripts;

import org.testng.annotations.Test;
import pomPages.*;

public class AirQueryTest extends com.micrococustbasetest.BaseClass {

    @Test
    public void airQuerySubmissionTest() throws InterruptedException {

        HomePage home = new HomePage(driver);
        home.openLoginPopup();

        LoginPage login = new LoginPage(driver);
        login.login("devops5@aaa2innovate.com", "@cupcake3#");

        AirQuerryPage aqp = new AirQuerryPage(driver);
        aqp.submitAirQuery();
              
    }

}
