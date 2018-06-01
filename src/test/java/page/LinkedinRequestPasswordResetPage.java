package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.GMailService;

/**
 * PageObject of LinkedinRequestPasswordResetPage with methods and variables
 */
public class LinkedinRequestPasswordResetPage extends LinkedinBasePage {

    @FindBy (xpath = "//*[@id='reset-password-submit-button']")
    private WebElement submitButton;

    @FindBy (xpath = "//*[@id='username']")
    private WebElement userEmailField;

    /**
     * Constructor of LinkedinRequestPasswordResetPage class
     * @param webDriver - current webDriver object
     * PageFactory - initialisation WebElements on THIS page and write their location of page in RAM
     */
    public LinkedinRequestPasswordResetPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Check if Page is loaded
     * @return true/fail
     */
    @Override
    public boolean isPageLoaded() {
        return submitButton.isDisplayed();
    }

    /**
     * Method for send user email
     * @param Email - user email
     * @return next new Page
     */
    public LinkedinRequestPasswordResetSubmitPage submitUserEmail(String Email) {
        gMailService.connect();
        userEmailField.sendKeys(Email);
        submitButton.click();
        return new LinkedinRequestPasswordResetSubmitPage(webDriver);
    }
}