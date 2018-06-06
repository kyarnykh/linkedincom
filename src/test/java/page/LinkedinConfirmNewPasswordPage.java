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

    @FindBy (xpath = "//*[@id='reset-password-submit-button']")
    private WebElement goToHomeButtom;


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
        waitUntilElementIsClickable(resetButton,30);
        return resetButton.isDisplayed();
    }

    /**
     * Method for set and confirm new user password
     * @param newPassword - new user password
     * @param confirmPassword - new user password
     * @return - next new Page
     */
    public LinkedinHomePage submitNewUserPassword(String newPassword, String confirmPassword) {
        newPasswordField.sendKeys(newPassword);
        confirmPasswordField.sendKeys(confirmPassword);
        resetButton.click();
        waitUntilElementIsClickable(goToHomeButtom, 60);
        goToHomeButtom.click();
        return new LinkedinHomePage(webDriver);
    }

}
