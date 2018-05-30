package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.*;


public class LinkedinResetPasswordTest extends LinkedinBaseTest {

    @DataProvider
    public Object[][] DataRestore() {
        return new Object[][]{
                {"*******@gmail.com", "*****"},
        };
    }


    @Test(dataProvider = "DataRestore")
    public void successfulResetPasswordTest(String userEmail, String userPassword) {
        Assert.assertTrue(linkedinLoginPage.isPageLoaded(),
                "Login page is not loaded");

        LinkedinRequestPasswordResetPage linkedinRequestPasswordResetPage = linkedinLoginPage.clickOnForgotPasswordLink();
        Assert.assertTrue(linkedinRequestPasswordResetPage.isPageLoaded(),
                "Reset page is not loaded");

        LinkedinRequestPasswordResetSubmitPage linkedinRequestPasswordResetSubmitPage = linkedinRequestPasswordResetPage.submit(userEmail);
        Assert.assertTrue(linkedinRequestPasswordResetSubmitPage.isPageLoaded(),
                "Submit page is not loaded");

        LinkedinConfirmNewPasswordPage linkedinConfirmNewPasswordPage = linkedinRequestPasswordResetSubmitPage.navigateToLinkFromEmail();
        Assert.assertTrue(linkedinConfirmNewPasswordPage.isPageLoaded(),
                "Confirm page is not loaded");

        LinkedinHomePage linkedinHomePage = linkedinConfirmNewPasswordPage.submit(userPassword);
        Assert.assertTrue(linkedinHomePage.isPageLoaded(),
                "Home page is not loaded");

    }
}
