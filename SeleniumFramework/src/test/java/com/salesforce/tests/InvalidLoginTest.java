package com.salesforce.tests;

import com.salesforce.base.BaseTest;
import com.salesforce.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InvalidLoginTest extends BaseTest {

    private LoginPage loginPage;

    @BeforeMethod
    public void initializePage() {
        loginPage = new LoginPage(driver);
    }

    @Test(priority = 1)
    public void verifyLoginWithEmptyCredentials() {
        loginPage.doLogin("", "");
        Assert.assertTrue(loginPage.isErrorMessageDisplayed());
    }

    @Test(priority = 2)
    public void verifyLoginWithEmptyUsername() {
        loginPage.doLogin("", "SomePassword123");
        Assert.assertTrue(loginPage.isErrorMessageDisplayed());
    }

    @Test(priority = 3)
    public void verifyLoginWithEmptyPassword() {
        loginPage.doLogin("testuser@salesforce.com", "");
        Assert.assertTrue(loginPage.isErrorMessageDisplayed());
    }

    @Test(priority = 4)
    public void verifyLoginWithInvalidUsername() {
        loginPage.doLogin("invaliduser@invalid.com", "SomePassword123");
        Assert.assertTrue(loginPage.isErrorMessageDisplayed());
    }

    @Test(priority = 5)
    public void verifyLoginWithInvalidPassword() {
        loginPage.doLogin("testuser@salesforce.com", "WrongPassword123");
        Assert.assertTrue(loginPage.isErrorMessageDisplayed());
    }

    @Test(priority = 6)
    public void verifyLoginWithInvalidCredentials() {
        loginPage.doLogin("invaliduser@invalid.com", "InvalidPassword123");
        Assert.assertTrue(loginPage.isErrorMessageDisplayed());
    }

    @Test(priority = 7)
    public void verifyLoginWithSpecialCharactersInUsername() {
        loginPage.doLogin("test<>@#$%user@invalid.com", "SomePassword123");
        Assert.assertTrue(loginPage.isErrorMessageDisplayed());
    }

    @Test(priority = 8)
    public void verifyLoginWithSQLInjectionAttempt() {
        loginPage.doLogin("' OR '1'='1", "' OR '1'='1");
        Assert.assertTrue(loginPage.isErrorMessageDisplayed());
    }

    @Test(priority = 9)
    public void verifyLoginWithXSSAttempt() {
        loginPage.doLogin("<script>alert('xss')</script>", "password");
        Assert.assertTrue(loginPage.isErrorMessageDisplayed());
    }

    @Test(priority = 10)
    public void verifyErrorMessageIsDisplayedForInvalidLogin() {
        loginPage.doLogin("nonexistent@user.com", "randompassword");
        Assert.assertTrue(loginPage.isErrorMessageDisplayed());
        String errorText = loginPage.getErrorMessage();
        Assert.assertFalse(errorText.isEmpty());
    }
}
