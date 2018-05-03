import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class LinkedinLoginTest {

    @Test
    public void successfulLoginTest() throws InterruptedException {
        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("https://www.linkedin.com");

        Assert.assertEquals(webDriver.getTitle(),"LinkedIn: Войти или зарегистрироваться");

        WebElement userEmailField = webDriver.findElement(By.xpath("//*[@id='login-email']"));
        String userLogin = "login_1@gmail.com";
        userEmailField.sendKeys(userLogin);

        WebElement userPasswordField = webDriver.findElement(By.xpath("//*[@id='login-password']"));
        String userPassword = "P@ssw0rd_1";
        userPasswordField.sendKeys(userPassword);

        WebElement signInButton = webDriver.findElement(By.xpath("//*[@id='login-submit']"));
        signInButton.sendKeys(Keys.RETURN);

        sleep (10000);

        Assert.assertEquals(webDriver.getTitle(),"LinkedIn");

        webDriver.close();



    }
}
