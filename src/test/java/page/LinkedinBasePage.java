package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.GMailService;


/**
 * PageObject of LinkedinBasePage with the main methods
 */
public abstract class LinkedinBasePage {
    protected WebDriver webDriver;
    protected static GMailService gMailService = new GMailService();


    /**
     * Constructor of LinkedinBasePage class
     * @param webDriver - current webDriver object
     */
    public LinkedinBasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    /**
     * Abstract method for classes which extend this class
     * @return true/fail
     */
    abstract boolean isPageLoaded ();

    public WebElement waitUntilElementIsClickable (WebElement webElement, int timeOutInSeconds){
        WebDriverWait wait = new WebDriverWait(webDriver, timeOutInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        return webElement;
    }


}
