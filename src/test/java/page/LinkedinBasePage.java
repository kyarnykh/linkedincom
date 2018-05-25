package page;

import org.openqa.selenium.WebDriver;


public abstract class LinkedinBasePage {
    protected WebDriver webDriver;


    public LinkedinBasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    abstract boolean isPageLoaded ();

}