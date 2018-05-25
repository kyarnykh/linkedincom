package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import page.LinkedinBasePage;

public class LinkedinSubmitPage extends LinkedinBasePage {

    private WebElement submitButton;
    private WebElement userEmailField;

    public LinkedinSubmitPage(WebDriver webDriver) {
        super(webDriver);
        initElements();
    }

    @Override
    public boolean isPageLoaded() {
        return submitButton.isDisplayed();
    }

    private void initElements() {
        userEmailField = webDriver.findElement(By.xpath("//*[@id='username']"));
        submitButton = webDriver.findElement(By.xpath("//*[@id='reset-password-submit-button']"));
    }


    public void submit(String Email) {
        userEmailField.sendKeys(Email);
        submitButton.click();
    }
}