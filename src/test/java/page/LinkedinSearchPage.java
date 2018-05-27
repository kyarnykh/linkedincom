package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class LinkedinSearchPage extends LinkedinBasePage {


    @FindBy (xpath = "//*[@data-vertical='PEOPLE']")
    private WebElement searchMenu;

    @FindBy (xpath = "//li[contains(@class, 'search-result__occluded-item')]")
    List<WebElement> searchResults;

    public LinkedinSearchPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @Override
    public boolean isPageLoaded() {
        return searchMenu.isDisplayed();
    }

    public int getResultsCount() {
        return searchResults.size();
    }

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
