package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * PageObject of LinkedinErrorPage with methods and variables
 */
public class LinkedinErrorPage extends LinkedinBasePage {

    @FindBy (xpath = "//*[@id='session_key-login-error']")
    private WebElement loginErrorMessage;

    @FindBy (xpath = "//div[@role='alert']")
    private WebElement bannerErrorMessage;

    /**
     * Constructor of LinkedinErrorPage class
     * @param webDriver - current webDriver object
     * PageFactory - initialisation WebElements on THIS page and write their location of page in RAM
     */
    public LinkedinErrorPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Check if Page is loaded
     * @return true/fail
     */
    @Override
    public boolean isPageLoaded() {
        return loginErrorMessage.isDisplayed();
    }

    /**
     * Method for return text of error message
     * @return Text of error message
     */
    public String getBannerErrorMessage() {
        return bannerErrorMessage.getText();
    }


}