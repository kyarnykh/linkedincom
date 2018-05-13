import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;


public class LinkedinLoginTest {
    WebDriver webDriver;

    @BeforeMethod
    public void before () {
        webDriver = new FirefoxDriver();
        webDriver.get("https://www.linkedin.com");
//        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
//        Assert.assertEquals(linkedinLoginPage.getCurrentPageTittle(), "LinkedIn: Войти или зарегистрироваться",
//                "Login page title is wrong");
    }

    @AfterMethod
    public void after(){
        webDriver.close();
    }


    @Test
    public void successfulLoginTest() {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        Assert.assertEquals(linkedinLoginPage.getCurrentPageTittle(), "LinkedIn: Войти или зарегистрироваться",
                "Login page title is wrong");

        linkedinLoginPage.login("correctEmail", "correctPassword");

        LinkedinHomePage linkedinHomePage = new LinkedinHomePage(webDriver);
        Assert.assertTrue(linkedinHomePage.isProfileMenuIsDisplayed(),
                "Profile menu is not displayed");
        Assert.assertEquals(linkedinHomePage.getCurrentPageTittle(), "LinkedIn",
                "Home page title is wrong");
    }

    @Test
    public void successfulCaseIntensiveLogin() {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        Assert.assertEquals(linkedinLoginPage.getCurrentPageTittle(), "LinkedIn: Войти или зарегистрироваться",
                "Title is missing");

        linkedinLoginPage.login("CORRECTEMAIL", "correctPassword");

        LinkedinHomePage linkedinHomePage = new LinkedinHomePage(webDriver);
        Assert.assertTrue(linkedinHomePage.isProfileMenuIsDisplayed(),
                "Profile menu is not displayed");
        Assert.assertEquals(linkedinHomePage.getCurrentPageTittle(), "LinkedIn",
                "Home page title is wrong");
    }

    @Test
    public void successfulCaseLoginPhoneNumber() {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        Assert.assertEquals(linkedinLoginPage.getCurrentPageTittle(), "LinkedIn: Войти или зарегистрироваться",
                "Title is missing");
        linkedinLoginPage.login("correctPhoneNumber", "correctPassword");

        LinkedinHomePage linkedinHomePage = new LinkedinHomePage(webDriver);
        Assert.assertTrue(linkedinHomePage.isProfileMenuIsDisplayed(),
                "Profile menu is not displayed");
        Assert.assertEquals(linkedinHomePage.getCurrentPageTittle(), "LinkedIn",
                "Home page title is wrong");
    }

    @Test
    public void successfulCaseLoginWithEmptySpace() {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        Assert.assertEquals(linkedinLoginPage.getCurrentPageTittle(), "LinkedIn: Войти или зарегистрироваться",
                "Title is missing");

        linkedinLoginPage.login("        correctEmail        ", "correctPassword");

        LinkedinHomePage linkedinHomePage = new LinkedinHomePage(webDriver);
        Assert.assertTrue(linkedinHomePage.isProfileMenuIsDisplayed(),
                "Profile menu is not displayed");
        Assert.assertEquals(linkedinHomePage.getCurrentPageTittle(), "LinkedIn",
                "Home page title is wrong");
    }


    @Test
    public void verifyLoginWithEmptyUsernameAndPassword() {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        linkedinLoginPage.login("", "");
        Assert.assertTrue(linkedinLoginPage.isSignInButtonDisplayed(),
                "Sing In button is missing");
    }

    @Test
    public void verifyLoginWithEmptyUsername() {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
//      Assert.assertTrue(linkedinLoginPage.isSignInButtonDisplayed(),
//                "Sing In button is missing");

        linkedinLoginPage.login("", "correctPassword");
        Assert.assertTrue(linkedinLoginPage.isSignInButtonDisplayed(),
                "Sing In button is missing");
    }

    @Test
    public void verifyLoginWithEmptyPassword() {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
//      Assert.assertTrue(linkedinLoginPage.isSignInButtonDisplayed(),
//                "Sing In button is missing");

        linkedinLoginPage.login("correctEmail", "");
        Assert.assertTrue(linkedinLoginPage.isSignInButtonDisplayed(),
                "Sing In button is missing");
    }

    @Test
    public void verifyLoginWithIncorrectUsername() {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
//        Assert.assertTrue(linkedinLoginPage.isSignInButtonDisplayed(),
//                "Sing In button is missing");

        linkedinLoginPage.login("incorrectEmail", "correctPassword");

        LinkedinErrorPage linkedinErrorPage = new LinkedinErrorPage(webDriver);
        Assert.assertTrue(linkedinErrorPage.isLoginErrorMessageDisplayed(),
                "Error message is missing");
        Assert.assertEquals(linkedinErrorPage.getCurrentLoginError(),"Этот адрес эл. почты не зарегистрирован в LinkedIn. Повторите попытку.",
                "Error message is incorrect");
    }

    @Test
    public void verifyLoginWithIncorrectPassword() {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
//        Assert.assertTrue(linkedinLoginPage.isSignInButtonDisplayed(),
//                "Sing In button is missing");

        linkedinLoginPage.login("correctEmail", "incorrectPassword");

        LinkedinErrorPage linkedinErrorPage = new LinkedinErrorPage(webDriver);
        Assert.assertTrue(linkedinErrorPage.isPasswordErrorMessageDisplayed(),
                "Error message is missing");
        Assert.assertEquals(linkedinErrorPage.getCurrentPasswordError(), "Это неверный пароль. Повторите попытку или измените пароль.",
                "Error message is incorrect");
    }

    @Test
    public void verifyLoginWithIncorrectUsernamePhoneNumber() {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
//        Assert.assertTrue(linkedinLoginPage.isSignInButtonDisplayed(),
//                "Sing In button is missing");

        linkedinLoginPage.login("incorrectPhoneNumber", "correctPassword");

        LinkedinErrorPage linkedinErrorPage = new LinkedinErrorPage(webDriver);
        Assert.assertTrue(linkedinErrorPage.isLoginErrorMessageDisplayed(),
                "Error message is missing");
        Assert.assertEquals(linkedinErrorPage.getCurrentLoginErrorPhoneNumber(),"Обязательно включите в номер значок «+» и код своей страны.",
                "Error message is incorrect");
    }

    @Test
    public void verifyLoginWithIncorrectUsernameOtherLanguage() {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
//        Assert.assertTrue(linkedinLoginPage.isSignInButtonDisplayed(),
//                "Sing In button is missing");

        linkedinLoginPage.login("incorrectEmailWithOtherLanguage", "correctPassword");

        LinkedinErrorPage linkedinErrorPage = new LinkedinErrorPage(webDriver);
        Assert.assertTrue(linkedinErrorPage.isLoginErrorMessageDisplayed(),
                "Error message is missing");
        Assert.assertEquals(linkedinErrorPage.getCurrentLoginErrorOtherLanguage(), "Укажите действительный адрес эл. почты.",
                "Error message is incorrect");
    }


}
