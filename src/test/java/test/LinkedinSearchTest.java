package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.LinkedinHomePage;
import page.LinkedinSearchPage;

import java.util.List;
import static java.lang.Thread.sleep;

public class LinkedinSearchTest extends LinkedinBaseTest {

    public LinkedinSearchTest() {}

    @DataProvider
    public Object[][] DataSearch() {
        return new Object[][]{
                {"****@gmail.com", "****", "HR"},
        };
    }


    @Test (dataProvider = "DataSearch")
    public void basicSearchTest(String userEmail, String userPassword, String Searchterm) throws InterruptedException {
        Assert.assertTrue(linkedinLoginPage.isPageLoaded(),
                "Login page is not loaded");
        LinkedinHomePage linkedinHomePage = linkedinLoginPage.login(userEmail, userPassword);
        Assert.assertTrue(linkedinHomePage.isPageLoaded(),
                "Home page is not loaded");

        LinkedinSearchPage linkedinSearchPage = linkedinHomePage.search(Searchterm);

        sleep(3000);

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
