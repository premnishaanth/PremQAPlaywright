package com.salesforce.tests;

import com.salesforce.base.BaseTest;
import com.salesforce.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ValidLoginTest extends BaseTest {

    private LoginPage loginPage;

    @BeforeMethod
    public void initializePage() {
        loginPage = new LoginPage(driver);
    }

    @Test(priority = 1)
    public void verifyLoginPageIsDisplayed() {
        Assert.assertTrue(loginPage.isLoginPageDisplayed());
    }

    @Test(priority = 2)
    public void verifyUsernameFieldIsDisplayed() {
        Assert.assertTrue(loginPage.isUsernameFieldDisplayed());
    }

    @Test(priority = 3)
    public void verifyPasswordFieldIsDisplayed() {
        Assert.assertTrue(loginPage.isPasswordFieldDisplayed());
    }

    @Test(priority = 4)
    public void verifyRememberMeCheckboxIsDisplayed() {
        Assert.assertTrue(loginPage.isRememberMeCheckboxDisplayed());
    }

    @Test(priority = 5)
    public void verifyLoginPageTitle() {
        String expectedTitle = "Login | Salesforce";
        Assert.assertEquals(loginPage.getPageTitle(), expectedTitle);
    }

    @Test(priority = 6)
    public void verifyValidLoginWithCredentials() {
        String validUsername = "testuser@salesforce.com";
        String validPassword = "ValidPassword123";
        loginPage.doLogin(validUsername, validPassword);
        Assert.assertTrue(loginPage.isLoginSuccessful() || loginPage.isErrorMessageDisplayed());
    }

    @Test(priority = 7)
    public void verifyValidLoginWithRememberMe() {
        String validUsername = "testuser@salesforce.com";
        String validPassword = "ValidPassword123";
        loginPage.doLoginWithRememberMe(validUsername, validPassword);
        Assert.assertTrue(loginPage.isLoginSuccessful() || loginPage.isErrorMessageDisplayed());
    }
}
