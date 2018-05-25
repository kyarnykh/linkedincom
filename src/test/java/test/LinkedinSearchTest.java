package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.LinkedinHomePage;
import page.LinkedinLoginPage;
import page.LinkedinSearchPage;

import java.util.List;
import static java.lang.Thread.sleep;

public class LinkedinSearchTest extends LinkedinBaseTest {

    public LinkedinSearchTest() {}

    @DataProvider
    public Object[][] DataSearch() {
        return new Object[][]{
                {"kostia.yarnykh@gmail.com", "Parol=P@ssw0rd", "HR"},
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
