package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinErrorPage extends LinkedinBasePage {

    @FindBy (xpath = "//*[@id='session_key-login-error']")
    private WebElement loginErrorMessage;

    @FindBy (xpath = "//div[@role='alert']")
    private WebElement bannerErrorMessage;

    public LinkedinErrorPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @Override
    public boolean isPageLoaded() {
        return loginErrorMessage.isDisplayed();
    }

    public String getBannerErrorMessage() {
        return bannerErrorMessage.getText();
    }


}