import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;


public class LinkedinLoginTest {
    WebDriver webDriver;

    @BeforeMethod
    public void before() {
        webDriver = new FirefoxDriver();
        webDriver.get("https://www.linkedin.com");
    }

    @AfterMethod
    public void after() {
        webDriver.close();
    }

    @DataProvider
    public Object[][] PositiveDataProviderHomePage() {
        return new Object[][]{
                {"correctEmail", "correctPassword"},
                {"CORRECTEMAIL", "correctPassword"},
                {"correctPhoneNumber", "correctPassword"},
                {"      correctEmail    ", "correctPassword"},
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
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        Assert.assertEquals(linkedinLoginPage.getCurrentPageTittle(), "LinkedIn: Войти или зарегистрироваться",
                "Login page title is wrong");

        linkedinLoginPage.login(userEmail, userPassword);

        LinkedinHomePage linkedinHomePage = new LinkedinHomePage(webDriver);
        Assert.assertTrue(linkedinHomePage.isProfileMenuIsDisplayed(),
                "Profile menu is not displayed");
    }


    @Test(dataProvider = "NegativeDataProviderLoginPage")
    public void verifyLoginAndPasswordWithEmptySpace (String userName, String userPassword) {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
//      Assert.assertTrue(linkedinLoginPage.isSignInButtonDisplayed(),
//                "Sing In button is missing");

        linkedinLoginPage.login(userName, userPassword);
        Assert.assertTrue(linkedinLoginPage.isSignInButtonDisplayed(),
                "Sing In button is missing");
    }


    @Test(dataProvider = "NegativeDataProviderErrorPage")
    public void verifyLoginWithIncorrectLoginAndPassword (String userName, String userPassword) {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        Assert.assertTrue(linkedinLoginPage.isSignInButtonDisplayed(),
                "Sing In button is missing");

        linkedinLoginPage.login(userName, userPassword);

        LinkedinErrorPage linkedinErrorPage = new LinkedinErrorPage(webDriver);
        Assert.assertEquals(linkedinErrorPage.getBannerErrorMessage(), "При заполнении формы были допущены ошибки. Проверьте и исправьте отмеченные поля.",
                "Error banner is missing");
    }

    @Test(dataProvider = "NegativeDataProviderErrorPage")
    public void verifyLoginWithIncorrectLoginError (String userName, String userPassword) {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        Assert.assertTrue(linkedinLoginPage.isSignInButtonDisplayed(),
                "Sing In button is missing");

        linkedinLoginPage.login(userName, userPassword);

        LinkedinErrorPage linkedinErrorPage = new LinkedinErrorPage(webDriver);
        Assert.assertTrue(linkedinErrorPage.isLoginErrorMessageDisplayed(),
                "Error is missing");
    }


}