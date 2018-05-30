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
     */
    public LinkedinLoginPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Check if Page is loaded
     * @return true/fails
     */
    @Override
    public boolean isPageLoaded() {
        return signInButton.isDisplayed();
    }

    public LinkedinHomePage login(String userEmail, String userPassword){
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPassword);
        signInButton.click();
        return PageFactory.initElements(webDriver, LinkedinHomePage.class);
    }

    public LinkedinErrorPage loginError(String userEmail, String userPassword){
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPassword);
        signInButton.click();
        return new LinkedinErrorPage(webDriver);
    }

    public LinkedinRequestPasswordResetPage clickOnForgotPasswordLink() {
        forgotButton.click();
        return new LinkedinRequestPasswordResetPage(webDriver);
    }
}
