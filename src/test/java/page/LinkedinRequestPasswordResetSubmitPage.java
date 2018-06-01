package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.GMailService;

/**
 * PageObject of LinkedinRequestPasswordResetSubmitPage with methods and variables
 */
public class LinkedinRequestPasswordResetSubmitPage extends LinkedinBasePage {

    @FindBy (xpath = "//*[@id='resend-url']")
    private WebElement sendButton;

    /**
     * Constructor of LinkedinRequestPasswordResetSubmitPage class
     * @param webDriver - current webDriver object
     * PageFactory - initialisation WebElements on THIS page and write their location of page in RAM
     */
    public LinkedinRequestPasswordResetSubmitPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Check if Page is loaded
     * @return true/fail
     */
    @Override
    public boolean isPageLoaded() {
        return sendButton.isDisplayed();
    }

    /**
     * Method for click on the link from user email
     * @return next new Page
     */
    public LinkedinConfirmNewPasswordPage navigateToLinkFromEmail(String userEmail) {
        String messageSubject = "enter email subj here";
        String messageTo = userEmail;
        String messageFrom = "SST TAU <security-noreply@linkedin.com>";

        GMailService gMailService = new GMailService();
        gMailService.connect();
        String message = gMailService.waitMessage(messageSubject, messageTo, messageFrom, 10);
        System.out.println("Content: " + message);


        return new LinkedinConfirmNewPasswordPage(webDriver);
    }
}
