package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.GMailService;

public class LinkedinRequestPasswordResetSubmitPage extends LinkedinBasePage {

    @FindBy (xpath = "//*[@id='resend-url']")
    private WebElement sendButton;

    public LinkedinRequestPasswordResetSubmitPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @Override
    public boolean isPageLoaded() {
        return sendButton.isDisplayed();
    }

    public LinkedinConfirmNewPasswordPage navigateToLinkFromEmail() {
        String messageSubject = "enter email subj here";
        String messageTo = "sst.tau@gmail.com";
        String messageFrom = "SST TAU <sst.tau@gmail.com>";

        GMailService gMailService = new GMailService();
        gMailService.connect();
        String message = gMailService.waitMessage(messageSubject, messageTo, messageFrom, 10);
        System.out.println("Content: " + message);


        return new LinkedinConfirmNewPasswordPage(webDriver);
    }
}
