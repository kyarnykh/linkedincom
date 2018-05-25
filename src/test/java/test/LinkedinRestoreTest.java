package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.*;


public class LinkedinRestoreTest extends LinkedinBaseTest {

    @DataProvider
    public Object[][] DataRestore() {
        return new Object[][]{
                {"???@gmail.com", "////"},
        };
    }


    @Test(dataProvider = "DataRestore")
    public void successfulResetPasswordTest(String userEmail, String NewPassword) {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        Assert.assertTrue(linkedinLoginPage.isPageLoaded(),
                "Login page is not loaded");

        linkedinLoginPage.restoreButton();

        LinkedinSubmitPage linkedinSubmitPage = new LinkedinSubmitPage(webDriver);
        Assert.assertTrue(linkedinSubmitPage.isPageLoaded(),
                "Submit page is not loaded");

        linkedinSubmitPage.submit(userEmail);

        LinkedinResetPage linkedinResetPage = new LinkedinResetPage (webDriver);
        Assert.assertTrue(linkedinResetPage.isPageLoaded());

//        getResetPasswordLinkFromEmail();

        LinkedinConfirmPasswordPage linkedinConfirmPassword = new LinkedinConfirmPasswordPage(webDriver);
        Assert.assertTrue(linkedinConfirmPassword.isPageLoaded(),
                "Page is not loaded");

        linkedinConfirmPassword.submit(NewPassword);

        LinkedinSuccessPage linkedinSuccessPage = new LinkedinSuccessPage(webDriver);
        Assert.assertTrue(linkedinSuccessPage.isPageLoaded(),
                "Success page is not loaded");

        linkedinSuccessPage.goHomePage();

        linkedinLoginPage.login(userEmail, NewPassword);

        LinkedinHomePage linkedinHomePage = new LinkedinHomePage(webDriver);
        Assert.assertTrue(linkedinHomePage.isPageLoaded(),
                "Home page is not loaded");


    }
}
