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
        String userLogin = "email@gmail.com";
        userEmailField.sendKeys(userLogin);

        WebElement userPasswordField = webDriver.findElement(By.xpath("//*[@id='login-password']"));
        String userPassword = "Password";
        userPasswordField.sendKeys(userPassword);

        WebElement signInButton = webDriver.findElement(By.xpath("//*[@id='login-submit']"));
        signInButton.click();

        sleep(3000);

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
         sleep(3000);
         Assert.assertTrue(singInButton.isDisplayed(), "Sing In button is missing");
     }

}
