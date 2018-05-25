package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import page.LinkedinBasePage;


public class LinkedinSuccessPage extends LinkedinBasePage {

    private WebElement resetButton;

    public LinkedinSuccessPage(WebDriver webDriver) {
            super(webDriver);
            initElements();
        }

        @Override
        public boolean isPageLoaded() {
            return resetButton.isDisplayed();
        }

        private void initElements() {
            resetButton = webDriver.findElement(By.xpath("//*[@id='reset-password-submit-button']"));
        }

        public void goHomePage() {
            resetButton.click();
        }


}
