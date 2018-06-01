package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * PageObject of LinkedinLoginPage with methods and variables
 */
public class LinkedinLoginPage extends LinkedinBasePage {

    @FindBy(xpath = "//*[@id='login-email']")
    private WebElement userEmailField;

    @FindBy(xpath = "//*[@id='login-password']")
    private WebElement userPasswordField;

    @FindBy(xpath = "//*[@id='login-submit']")
    private WebElement signInButton;

    @FindBy(xpath = "//*[@class='link-forgot-password']")
    private WebElement forgotButton;

    /**
     * Constructor of LinkedinLoginPage class
     * @param webDriver - current webDriver object
     * PageFactory - initialisation WebElements on THIS page and write their location of page in RAM
     */
    public LinkedinLoginPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Check if Page is loaded
     * @return true/fail
     */
    @Override
    public boolean isPageLoaded() {
        return signInButton.isDisplayed();
    }

    /**
     * Method for login by users
     * @param userEmail - user email
     * @param userPassword - user password
     * @return next new Page and initialisation WebElement on the new Page
     */
    public LinkedinHomePage login(String userEmail, String userPassword){
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPassword);
        signInButton.click();
        return PageFactory.initElements(webDriver, LinkedinHomePage.class);
    }

    /**
     * Method for login by users with invalid data
     * @param userEmail - incorrect user email
     * @param userPassword - incorrect user password
     * @return next new Page with error messages
     */
    public LinkedinErrorPage loginError(String userEmail, String userPassword){
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPassword);
        signInButton.click();
        return new LinkedinErrorPage(webDriver);
    }

    /**
     * Method for click by link
     * @return - next new Page
     */
    public LinkedinRequestPasswordResetPage clickOnForgotPasswordLink() {
        forgotButton.click();
        return new LinkedinRequestPasswordResetPage(webDriver);
    }
}
