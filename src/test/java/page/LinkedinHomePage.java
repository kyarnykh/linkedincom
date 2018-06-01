package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * PageObject of LinkedinHomePage with methods and variables
 */
public class LinkedinHomePage extends LinkedinBasePage {

    @FindBy(xpath = "//*[@id='profile-nav-item']")
    private WebElement profileMenu;

    @FindBy(xpath = "//*[@role='combobox']")
    private WebElement searchField;

    @FindBy(xpath = "//*[@id='nav-search-controls-wormhole']/button")
    private WebElement searchButton;


    /**
     * Constructor of LinkedinHomePage class
     * @param webDriver - current webDriver object
     * PageFactory - initialisation WebElements on THIS page and write their location of page in RAM
     */
    public LinkedinHomePage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Check if Page is loaded
     * @return true/fail
     */
    @Override
    public boolean isPageLoaded() {
        return profileMenu.isDisplayed();
    }

    /**
     * Method for search some information by users
     * @param searchText - text for searching
     * @return - next new Page
     */
    public LinkedinSearchPage search (String searchText){
        searchField.sendKeys(searchText);
        searchButton.click();
        return new LinkedinSearchPage(webDriver);
    }

}
