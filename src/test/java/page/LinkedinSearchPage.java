package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * PageObject of LinkedinSearchPage with methods and variables
 */
public class LinkedinSearchPage extends LinkedinBasePage {


    @FindBy (xpath = "//*[@data-vertical='PEOPLE']")
    private WebElement searchMenu;

    @FindBy (xpath = "//li[contains(@class, 'search-result__occluded-item')]")
    List<WebElement> searchResults;

    /**
     * Constructor of LinkedinSearchPage class
     * @param webDriver - current webDriver object
     * PageFactory - initialisation WebElements on THIS page and write their location of page in RAM
     */
    public LinkedinSearchPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Check if Page is loaded
     * @return true/fail
     */
    @Override
    public boolean isPageLoaded() {
        return searchMenu.isDisplayed();
    }

    /**
     * Counts search results
     * @return int size
     */
    public int getResultsCount() {
        return searchResults.size();
    }

    /**
     * Constructor for display search results
     * @return List of search results
     */
    public List<String> getResultsList() {
        List<String> searchResultsList = new ArrayList<>();
        for (WebElement searchResult:searchResults){
            ((JavascriptExecutor)webDriver).executeScript(
                    "arguments[0].scrollIntoView();",searchResult);
            String searchResultText = searchResult.getText();
            searchResultsList.add(searchResultText);
        }
        return searchResultsList;
    }
}
