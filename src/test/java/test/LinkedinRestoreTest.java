package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.*;


public class LinkedinRestoreTest extends LinkedinBaseTest {

    @DataProvider
    public Object[][] DataRestore() {
        return new Object[][]{
                {"*****@gmail.com", "*******"},
        };
    }


    @Test(dataProvider = "DataRestore")
    public void successfulResetPasswordTest(String userEmail, String userPassword) {
        Assert.assertTrue(linkedinLoginPage.isPageLoaded(),
                "Login page is not loaded");

        LinkedinSubmitPage linkedinSubmitPage = linkedinLoginPage.restoreButton();
        Assert.assertTrue(linkedinSubmitPage.isPageLoaded(),
                "Submit page is not loaded");

        LinkedinResetPage linkedinResetPage = linkedinSubmitPage.submit(userEmail);
        Assert.assertTrue(linkedinResetPage.isPageLoaded());

//        getResetPasswordLinkFromEmail();

        LinkedinConfirmPasswordPage linkedinConfirmPassword = new LinkedinConfirmPasswordPage(webDriver);
        Assert.assertTrue(linkedinConfirmPassword.isPageLoaded(),
                "Page is not loaded");

        LinkedinHomePage linkedinHomePage = linkedinConfirmPassword.submit(userPassword);
        Assert.assertTrue(linkedinHomePage.isPageLoaded(),
                "Home page is not loaded");

    }
}
