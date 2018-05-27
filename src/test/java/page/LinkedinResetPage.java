package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinResetPage extends LinkedinBasePage {

    @FindBy (xpath = "//*[@id='resend-url']")
    private WebElement sendButton;

    public LinkedinResetPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @Override
    public boolean isPageLoaded() {
        return sendButton.isDisplayed();
    }

}
