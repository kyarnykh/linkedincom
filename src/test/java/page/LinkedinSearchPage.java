package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import page.LinkedinBasePage;

import java.util.ArrayList;
import java.util.List;

public class LinkedinSearchPage extends LinkedinBasePage {


    private WebElement searchMenu;
    List<WebElement> searchResults;

    public LinkedinSearchPage(WebDriver webDriver) {
        super(webDriver);
        initElements();
    }

    @Override
    public boolean isPageLoaded() {
        return searchMenu.isDisplayed();
    }

    public void initElements() {
        searchMenu = webDriver.findElement(By.xpath("//*[@data-vertical='PEOPLE']"));
        searchResults = webDriver.findElements(By.xpath("//li[contains(@class, 'search-result__occluded-item')]"));
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
