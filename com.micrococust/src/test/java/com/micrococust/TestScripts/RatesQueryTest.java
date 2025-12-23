package com.micrococust.TestScripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.micrococustbasetest.BaseClass;

import pomPages.*;

public class RatesQueryTest extends BaseClass {

    @Test
    public void verifyRatesDisplayed() throws InterruptedException {
        HomePage home = new HomePage(driver);
        home.openLoginPopup();

        LoginPage login = new LoginPage(driver);
        login.login("devops5@aaa2innovate.com", "@cupcake3#");

        AirQuerryPage airQuery = new AirQuerryPage(driver);
        airQuery.submitAirQuery();

        RatesQueryPreviewPage rates = new RatesQueryPreviewPage(driver);
        Assert.assertTrue(rates.isRatesDisplayed(), "Rates not displayed");
    }
}
