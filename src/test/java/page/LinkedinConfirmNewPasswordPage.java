package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * PageObject of LinkedinConfirmNewPasswordPage with methods and variables
 */
public class LinkedinConfirmNewPasswordPage extends LinkedinBasePage {

    @FindBy (xpath = "//*[@id='newPassword']")
    private WebElement newPasswordField;

    @FindBy (xpath = "//*[@id='confirmPassword']")
    private WebElement confirmPasswordField;

    @FindBy (xpath = "//*[@id='reset-password-submit-button']")
    private WebElement resetButton;

    /**
     * Constructor of LinkedinConfirmNewPasswordPage class
     * @param webDriver - current webDriver object
     * PageFactory - initialisation WebElements on THIS page and write their location of page in RAM
     */
    public LinkedinConfirmNewPasswordPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Check if Page is loaded
     * @return true/fail
     */
    @Override
    public boolean isPageLoaded() {
        return resetButton.isDisplayed();
    }

    /**
     * Method for set and confirm new user password
     * @param userPassword - new user password
     * @return - next new Page
     */
    public LinkedinHomePage submit(String userPassword) {
        newPasswordField.sendKeys();
        confirmPasswordField.sendKeys();
        resetButton.click();
        return new LinkedinHomePage(webDriver);
    }

}
