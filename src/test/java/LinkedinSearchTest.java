import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static java.lang.Thread.sleep;

public class LinkedinSearchTest {
    WebDriver webDriver;

    public LinkedinSearchTest() {}


    @BeforeMethod
    public void before() {
        webDriver = new FirefoxDriver();
        webDriver.get("https://www.linkedin.com");
    }

    @AfterMethod
    public void after() {
        webDriver.close();
    }

    @DataProvider
    public Object[][] DataSearch() {
        return new Object[][]{
                {"correctNumber", "correctPassword", "HR"},
        };
    }



    @Test (dataProvider = "DataSearch")
    public void basicSearchTest(String userEmail, String userPassword, String searchText) throws InterruptedException {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        Assert.assertTrue(linkedinLoginPage.isPageLoaded(),
                "Login page is not loaded");

        linkedinLoginPage.login(userEmail, userPassword);

        LinkedinHomePage linkedinHomePage = new LinkedinHomePage(webDriver);
        Assert.assertTrue(linkedinHomePage.isPageLoaded(),
                "Home page is not loaded");

        sleep(5000);

        linkedinHomePage.search(searchText);

        sleep(5000);

        LinkedinGlobalSearchPage linkedinGlobalSearchPage = new LinkedinGlobalSearchPage(webDriver);
        Assert.assertTrue(linkedinGlobalSearchPage.isPageLoaded(),
                "Search page is not loaded");

        List<WebElement> searchResults = webDriver.findElements(By.xpath("//*[@class='search-results__list list-style-none']"));

        System.out.println("Number of results: "+searchResults.size());

        for (WebElement searchResult : searchResults) {
            String searchResultText = searchResult.getText();
            if (searchResultText.contains(searchText)) {
                System.out.println("Search term found in result item");
            }
            System.out.println(searchResultText);
        }

    }


}
