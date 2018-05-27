package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinConfirmPasswordPage extends LinkedinBasePage {

    @FindBy (xpath = "//*[@id='newPassword']")
    private WebElement newPasswordField;

    @FindBy (xpath = "//*[@id='confirmPassword']")
    private WebElement confirmPasswordField;

    @FindBy (xpath = "//*[@id='reset-password-submit-button']")
    private WebElement resetButton;

    public LinkedinConfirmPasswordPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @Override
    public boolean isPageLoaded() {
        return resetButton.isDisplayed();
    }

    public LinkedinHomePage submit(String userPassword) {
        newPasswordField.sendKeys();
        confirmPasswordField.sendKeys();
        resetButton.click();
        return new LinkedinHomePage(webDriver);
    }

}
