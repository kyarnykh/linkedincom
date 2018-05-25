package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import page.LinkedinBasePage;

public class LinkedinConfirmPasswordPage extends LinkedinBasePage {

    private WebElement newPasswordField;
    private WebElement confirmPasswordField;
    private WebElement resetButton;

    public LinkedinConfirmPasswordPage(WebDriver webDriver) {
        super(webDriver);
        initElements();
    }

    @Override
    public boolean isPageLoaded() {
        return resetButton.isDisplayed();
    }

    private void initElements() {
        resetButton = webDriver.findElement(By.xpath("//*[@id='reset-password-submit-button']"));
        newPasswordField = webDriver.findElement(By.xpath("newPassword"));
        confirmPasswordField = webDriver.findElement(By.xpath("//*[@id='confirmPassword']"));
    }

    public void submit(String newPassword) {
        newPasswordField.sendKeys();
        confirmPasswordField.sendKeys();
        resetButton.click();
    }

}
