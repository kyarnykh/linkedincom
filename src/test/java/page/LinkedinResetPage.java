package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import page.LinkedinBasePage;

public class LinkedinResetPage extends LinkedinBasePage {

    private WebElement sendButton;

    public LinkedinResetPage(WebDriver webDriver) {
        super(webDriver);
        initElements();
    }

    @Override
    public boolean isPageLoaded() {
        return sendButton.isDisplayed();
    }

    private void initElements() {
        sendButton = webDriver.findElement(By.xpath("//*[@id='resend-url']"));
    }

}
