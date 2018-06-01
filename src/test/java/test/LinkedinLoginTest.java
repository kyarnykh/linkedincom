package test;

import org.testng.Assert;
import org.testng.annotations.*;
import page.LinkedinErrorPage;
import page.LinkedinHomePage;


/**
 * TestPage of LinkedinLoginTest with methods, variables and test data
 */
public class LinkedinLoginTest extends LinkedinBaseTest {


    /**
     * Test data for successful login by users
     * @return user email and password
     */
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

    /**
     * Test data for login with wrong parameters
     * @return user email and password
     */
    @DataProvider
    public Object[][] NegativeDataProviderLoginPage() {
        return new Object[][]{
                {"", ""},
                {"", "correctPassword"},
                {"correctEmail", ""},
        };
    }

    /**
     * Test data for login with wrong parameters
     * @return user email and password
     */
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


    /**
     * Test for check successful login by users
     * @param userEmail - correct user email
     * @param userPassword - correct user password
     */
    @Test(dataProvider = "PositiveDataProviderHomePage")
    public void successfulLoginTest(String userEmail, String userPassword) {
        Assert.assertTrue(linkedinLoginPage.isPageLoaded(),
                "Login page is not loaded");
        LinkedinHomePage linkedinHomePage = linkedinLoginPage.login(userEmail, userPassword);
        Assert.assertTrue(linkedinHomePage.isPageLoaded(),
                "Home page is not loaded");
    }

    /**
     * Test for check unsuccessful login by users
     * @param userEmail - incorrect user email
     * @param userPassword - incorrect user password
     */
    @Test(dataProvider = "NegativeDataProviderLoginPage")
    public void verifyLoginAndPasswordWithEmptySpace (String userEmail, String userPassword) {
        linkedinLoginPage.login(userEmail, userPassword);
        Assert.assertTrue(linkedinLoginPage.isPageLoaded(),
                "Sing In button is missing");
    }

    /**
     * Test for check text of error message via login
     * @param userEmail - incorrect/correct user email
     * @param userPassword - incorrect/correct user password
     */
    @Test(dataProvider = "NegativeDataProviderErrorPage")
    public void verifyLoginWithIncorrectLoginAndPassword (String userEmail, String userPassword) {
        Assert.assertTrue(linkedinLoginPage.isPageLoaded(),
                "Sing In button is missing");
        LinkedinErrorPage linkedinErrorPage = linkedinLoginPage.loginError(userEmail, userPassword);
        Assert.assertEquals(linkedinErrorPage.getBannerErrorMessage(), "При заполнении формы были допущены ошибки. Проверьте и исправьте отмеченные поля.",
                "Error banner is missing");
    }

    /**
     * Test for check error message is displayed
     * @param userEmail - incorrect/correct user email
     * @param userPassword - incorrect/correct user password
     */
    @Test(dataProvider = "NegativeDataProviderErrorPage")
    public void verifyLoginWithIncorrectLoginError (String userEmail, String userPassword) {
        Assert.assertTrue(linkedinLoginPage.isPageLoaded(),
                "Login page is not loaded");
        LinkedinErrorPage linkedinErrorPage = linkedinLoginPage.loginError(userEmail, userPassword);
        Assert.assertTrue(linkedinErrorPage.isPageLoaded(),
                "Error is missing");
    }


}