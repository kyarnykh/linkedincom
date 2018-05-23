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
                {"0938319813", "88910106", "HR"},
        };
    }


    @Test (dataProvider = "DataSearch")
    public void basicSearchTest(String userEmail, String userPassword, String Searchterm) throws InterruptedException {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        Assert.assertTrue(linkedinLoginPage.isPageLoaded(),
                "Login page is not loaded");

        linkedinLoginPage.login(userEmail, userPassword);

        LinkedinHomePage linkedinHomePage = new LinkedinHomePage(webDriver);
        Assert.assertTrue(linkedinHomePage.isPageLoaded(),
                "Home page is not loaded");

        sleep(3000);

        linkedinHomePage.search(Searchterm);

        sleep(3000);

        LinkedinSearchPage linkedinSearchPage = new LinkedinSearchPage(webDriver);
        Assert.assertTrue(linkedinSearchPage.isPageLoaded(),
                "Search page is not loaded");

        Assert.assertEquals(linkedinSearchPage.getResultsCount(), 10,
                "Search results count is wrong");

        List<String> resultsList = linkedinSearchPage.getResultsList();

        for(String result:resultsList){
            Assert.assertTrue(result.contains(Searchterm),
                    "Searchterm"+Searchterm+"is missing in following results: \n"+result);
        }


    }

}
