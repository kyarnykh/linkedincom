package test;

import org.testng.Assert;
import org.testng.annotations.*;
import page.LinkedinErrorPage;
import page.LinkedinHomePage;


public class LinkedinLoginTest extends LinkedinBaseTest {


    @DataProvider
    public Object[][] PositiveDataProviderHomePage() {
        return new Object[][]{
                {"correctEmail", "correctPassword"},
                {"CORRECTEMAIL", "correctPassword"},
                {"correctPhoneNumber", "correctPassword"},
                {"      correctEmail    ", "correctPassword"},
                {"correctEmail", "  correctPassword    "},
        };
    }

    @DataProvider
    public Object[][] NegativeDataProviderLoginPage() {
        return new Object[][]{
                {"", ""},
                {"", "correctPassword"},
                {"correctEmail", ""},
        };
    }

    @DataProvider
    public Object[][] NegativeDataProviderErrorPage() {
        return new Object[][]{
                {"incorrectEmail", "correctPassword"},
                {"correctEmail", "incorrectPassword"},
                {"incorrectPhoneNumber", "correctPassword"},
                {"incorrectPostServices", "correctPassword"},
                {"incorrectEmailWithOtherLanguage", "correctPassword"},
        };
    }


    @Test(dataProvider = "PositiveDataProviderHomePage")
    public void successfulLoginTest(String userEmail, String userPassword) {
        Assert.assertTrue(linkedinLoginPage.isPageLoaded(),
                "Login page is not loaded");
        LinkedinHomePage linkedinHomePage = linkedinLoginPage.login(userEmail, userPassword);
        Assert.assertTrue(linkedinHomePage.isPageLoaded(),
                "Home page is not loaded");
    }

    @Test(dataProvider = "NegativeDataProviderLoginPage")
    public void verifyLoginAndPasswordWithEmptySpace (String userName, String userPassword) {
        linkedinLoginPage.login(userName, userPassword);
        Assert.assertTrue(linkedinLoginPage.isPageLoaded(),
                "Sing In button is missing");
    }

    @Test(dataProvider = "NegativeDataProviderErrorPage")
    public void verifyLoginWithIncorrectLoginAndPassword (String userName, String userPassword) {
        Assert.assertTrue(linkedinLoginPage.isPageLoaded(),
                "Sing In button is missing");
        LinkedinErrorPage linkedinErrorPage = linkedinLoginPage.loginError(userName, userPassword);
        Assert.assertEquals(linkedinErrorPage.getBannerErrorMessage(), "При заполнении формы были допущены ошибки. Проверьте и исправьте отмеченные поля.",
                "Error banner is missing");
    }

    @Test(dataProvider = "NegativeDataProviderErrorPage")
    public void verifyLoginWithIncorrectLoginError (String userName, String userPassword) {
        Assert.assertTrue(linkedinLoginPage.isPageLoaded(),
                "Login page is not loaded");
        LinkedinErrorPage linkedinErrorPage = linkedinLoginPage.loginError(userName, userPassword);
        Assert.assertTrue(linkedinErrorPage.isPageLoaded(),
                "Error is missing");
    }


}