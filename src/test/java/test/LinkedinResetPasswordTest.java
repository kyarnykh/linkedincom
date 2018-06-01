package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.*;


/**
 * TestPage of LinkedinResetPasswordTest with methods, variables and test data
 */
public class LinkedinResetPasswordTest extends LinkedinBaseTest {

    /**
     * Test data for reset password
     * @return user email and new user password
     */
    @DataProvider
    public Object[][] DataRestore() {
        return new Object[][]{
                {"************@gmail.com", "********"},
        };
    }


    /**
     * Method for reset and set user password
     * @param userEmail - user email
     * @param userPassword - new user password
     */
    @Test(dataProvider = "DataRestore")
    public void successfulResetPasswordTest(String userEmail, String userPassword) {
        Assert.assertTrue(linkedinLoginPage.isPageLoaded(),
                "Login page is not loaded");

        LinkedinRequestPasswordResetPage linkedinRequestPasswordResetPage = linkedinLoginPage.clickOnForgotPasswordLink();
        Assert.assertTrue(linkedinRequestPasswordResetPage.isPageLoaded(),
                "Reset page is not loaded");

        LinkedinRequestPasswordResetSubmitPage linkedinRequestPasswordResetSubmitPage = linkedinRequestPasswordResetPage.submitUserEmail(userEmail);
        Assert.assertTrue(linkedinRequestPasswordResetSubmitPage.isPageLoaded(),
                "Submit page is not loaded");

        LinkedinConfirmNewPasswordPage linkedinConfirmNewPasswordPage = linkedinRequestPasswordResetSubmitPage.navigateToLinkFromEmail();
        Assert.assertTrue(linkedinConfirmNewPasswordPage.isPageLoaded(),
                "Confirm page is not loaded");

        LinkedinHomePage linkedinHomePage = linkedinConfirmNewPasswordPage.submitNewUserPassword(userPassword);
        Assert.assertTrue(linkedinHomePage.isPageLoaded(),
                "Home page is not loaded");

    }
}
