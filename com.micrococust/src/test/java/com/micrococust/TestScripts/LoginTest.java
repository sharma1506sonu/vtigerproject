package com.micrococust.TestScripts;

import org.testng.annotations.Test;

import com.micrococustbasetest.BaseClass;

import pomPages.HomePage;
import pomPages.LoginPage;

public class LoginTest extends BaseClass {

    @Test
    public void validLoginTest() throws InterruptedException {
        HomePage home = new HomePage(driver);
        home.openLoginPopup();

        LoginPage login = new LoginPage(driver);
        login.login("devops5@aaa2innovate.com", "@cupcake3#");
    }
}
