package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinSubmitPage extends LinkedinBasePage {

    @FindBy (xpath = "//*[@id='reset-password-submit-button']")
    private WebElement submitButton;

    @FindBy (xpath = "//*[@id='username']")
    private WebElement userEmailField;

    public LinkedinSubmitPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @Override
    public boolean isPageLoaded() {
        return submitButton.isDisplayed();
    }

    public LinkedinResetPage submit(String Email) {
        userEmailField.sendKeys(Email);
        submitButton.click();
        return new LinkedinResetPage (webDriver);
    }
}