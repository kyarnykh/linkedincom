package page;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


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
        waitUntilElementIsClickable(sendButton,180);
        return sendButton.isDisplayed();
    }

    /**
     * Method for click on the link from user email
     * @return next new Page
     */
    public LinkedinConfirmNewPasswordPage navigateToLinkFromEmail() {
        String messageSubject = "данное сообщение содержит ссылку для изменения пароля";
        String messageTo = "kostia.yarnykh@gmail.com";
        String messageFrom = "security-noreply@linkedin.com";

        String message = gMailService.waitMessage(messageSubject, messageTo, messageFrom, 200);
        System.out.println("Content: " + message);

        String resetPasswordLink = StringUtils.substringBetween(message, "Чтобы изменить пароль в LinkedIn, нажмите <a href=\"", "\" style").replace("&amp;","&");
        System.out.println("Content: " + resetPasswordLink);
        webDriver.navigate().to(resetPasswordLink);

        return new LinkedinConfirmNewPasswordPage(webDriver);
    }
}
