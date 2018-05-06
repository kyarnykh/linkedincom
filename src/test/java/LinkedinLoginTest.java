import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import static java.lang.Thread.sleep;

public class LinkedinLoginTest {
    WebDriver webDriver;

    @BeforeMethod
    public void before () {
        webDriver = new FirefoxDriver();
        webDriver.get("https://www.linkedin.com");
    }

    @AfterMethod
    public void after(){
        webDriver.close();
    }


    @Test
    public void successfulLoginTest() throws InterruptedException {
        Assert.assertEquals(webDriver.getTitle(), "LinkedIn: Войти или зарегистрироваться",
                "Title is missing");

        WebElement userEmailField = webDriver.findElement(By.xpath("//*[@id='login-email']"));
        String userLogin = "correctEmail@gmail.com";
        userEmailField.sendKeys(userLogin);

        WebElement userPasswordField = webDriver.findElement(By.xpath("//*[@id='login-password']"));
        String userPassword = "correctPassword";
        userPasswordField.sendKeys(userPassword);

        WebElement signInButton = webDriver.findElement(By.xpath("//*[@id='login-submit']"));
        signInButton.click();

        sleep(5000);

        Assert.assertEquals(webDriver.getTitle(), "LinkedIn",
                "Title is missing");
    }

    @Test
    public void successfulCaseIntensiveLogin() throws InterruptedException {
        Assert.assertEquals(webDriver.getTitle(), "LinkedIn: Войти или зарегистрироваться",
                "Title is missing");
        WebElement userEmailField = webDriver.findElement(By.xpath("//*[@id='login-email']"));
        String userLogin = "CORRECTEMAILL@gmail.com";
        userEmailField.sendKeys(userLogin);

        WebElement userPasswordField = webDriver.findElement(By.xpath("//*[@id='login-password']"));
        String userPassword = "correctPassword";
        userPasswordField.sendKeys(userPassword);

        WebElement signInButton = webDriver.findElement(By.xpath("//*[@id='login-submit']"));
        signInButton.click();

        sleep(5000);

        Assert.assertEquals(webDriver.getTitle(), "LinkedIn",
                "Title is missing");
    }

    @Test
    public void verifyLoginWithEmptyUsernameAndPassword() throws InterruptedException {
        WebElement singInButton = webDriver.findElement(By.xpath("//*[@id='login-submit']"));
        Assert.assertTrue(singInButton.isDisplayed(),
                "Sing In button is missing");

        WebElement userEmailField = webDriver.findElement(By.xpath("//*[@id='login-email']"));
        userEmailField.sendKeys("");

        WebElement userPasswordField = webDriver.findElement(By.xpath("//*[@id='login-password']"));
        userPasswordField.sendKeys("");

        singInButton.click();
        sleep(5000);
        Assert.assertTrue(singInButton.isDisplayed(), "Sing In button is missing");
     }

    @Test
    public void verifyLoginWithEmptyUsername() throws InterruptedException {
        WebElement singInButton = webDriver.findElement(By.xpath("//*[@id='login-submit']"));
        Assert.assertTrue(singInButton.isDisplayed(),
                "Sing In button is missing");

        WebElement userEmailField = webDriver.findElement(By.xpath("//*[@id='login-email']"));
        userEmailField.sendKeys("");

        WebElement userPasswordField = webDriver.findElement(By.xpath("//*[@id='login-password']"));
        userPasswordField.sendKeys("correctPassword");

        singInButton.click();
        sleep(5000);
        Assert.assertTrue(singInButton.isDisplayed(), "Sing In button is missing");
    }

    @Test
    public void verifyLoginWithEmptyPassword() throws InterruptedException {
        WebElement singInButton = webDriver.findElement(By.xpath("//*[@id='login-submit']"));
        Assert.assertTrue(singInButton.isDisplayed(),
                "Sing In button is missing");

        WebElement userEmailField = webDriver.findElement(By.xpath("//*[@id='login-email']"));
        userEmailField.sendKeys("correctEmail@gmail.com");

        WebElement userPasswordField = webDriver.findElement(By.xpath("//*[@id='login-password']"));
        userPasswordField.sendKeys("");

        singInButton.click();
        sleep(5000);
        Assert.assertTrue(singInButton.isDisplayed(), "Sing In button is missing");
    }

    @Test
    public void verifyLoginWithIncorrectUsername() throws InterruptedException {
        WebElement singInButton = webDriver.findElement(By.xpath("//*[@id='login-submit']"));
        Assert.assertTrue(singInButton.isDisplayed(),
                "Sing In button is missing");

        WebElement userEmailField = webDriver.findElement(By.xpath("//*[@id='login-email']"));
        userEmailField.sendKeys("incorrectEmail@gmail.com");

        WebElement userPasswordField = webDriver.findElement(By.xpath("//*[@id='login-password']"));
        userPasswordField.sendKeys("correctPassword");

        singInButton.click();
        sleep(5000);
        WebElement errorMessage = webDriver.findElement(By.xpath("//*[@id='session_key-login-error']"));
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message is missing");
    }

    @Test
    public void verifyLoginWithIncorrectPassword() throws InterruptedException {
        WebElement singInButton = webDriver.findElement(By.xpath("//*[@id='login-submit']"));
        Assert.assertTrue(singInButton.isDisplayed(),
                "Sing In button is missing");

        WebElement userEmailField = webDriver.findElement(By.xpath("//*[@id='login-email']"));
        userEmailField.sendKeys("correctEmail@gmail.com");

        WebElement userPasswordField = webDriver.findElement(By.xpath("//*[@id='login-password']"));
        userPasswordField.sendKeys("incorrectPassword");

        singInButton.click();
        sleep(5000);
        WebElement errorMessage = webDriver.findElement(By.xpath("//*[@id='session_password-login-error']"));
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message is missing");
    }


}
