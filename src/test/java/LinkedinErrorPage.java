import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkedinErrorPage extends LinkedinBasePage {

    private WebElement loginErrorMessage;
    private WebElement bannerErrorMessage;

    public LinkedinErrorPage(WebDriver webDriver) {
        super(webDriver);
        initElements();
    }

    @Override
    boolean isPageLoaded() {
        return loginErrorMessage.isDisplayed();
    }

    private void initElements(){
        loginErrorMessage = webDriver.findElement(By.xpath("//*[@id='session_key-login-error']"));
        bannerErrorMessage = webDriver.findElement(By.xpath("//div[@role='alert']"));

    }

    public String getBannerErrorMessage() {
        return bannerErrorMessage.getText();
    }


}