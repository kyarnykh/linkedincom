package page;

import org.openqa.selenium.WebDriver;


/**
 * PageObject of LinkedinBasePage with the main methods
 */
public abstract class LinkedinBasePage {
    protected WebDriver webDriver;


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

}
