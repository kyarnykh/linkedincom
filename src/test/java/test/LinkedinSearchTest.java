package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.LinkedinHomePage;
import page.LinkedinSearchPage;

import java.util.List;

/**
 *  TestPage of LinkedinSearchTest with methods, variables and test data
 */
public class LinkedinSearchTest extends LinkedinBaseTest {

    public LinkedinSearchTest() {}

    /**
     * Test data for search
     * @return user email, user password and text for searching
     */
    @DataProvider
    public Object[][] DataSearch() {
        return new Object[][]{
                {"******@gmail.com", "********", "HR"},
        };
    }


    /**
     * Method for count search term
     * @param userEmail - correct user email
     * @param userPassword - correct user password
     * @param searchTerm - text for searching
     * @throws InterruptedException - for page with search results
     */
    @Test (dataProvider = "DataSearch")
    public void basicSearchTest(String userEmail, String userPassword, String searchTerm) {
        Assert.assertTrue(linkedinLoginPage.isPageLoaded(),
                "Login page is not loaded");
        LinkedinHomePage linkedinHomePage = linkedinLoginPage.login(userEmail, userPassword);
        Assert.assertTrue(linkedinHomePage.isPageLoaded(),
                "Home page is not loaded");

        LinkedinSearchPage linkedinSearchPage = linkedinHomePage.search(searchTerm);

        Assert.assertTrue(linkedinSearchPage.isPageLoaded(),
                "Search page is not loaded");

        Assert.assertEquals(linkedinSearchPage.getResultsCount(), 10,
                "Search results count is wrong");

        List<String> resultsList = linkedinSearchPage.getResultsList();

        for(String result:resultsList){
            Assert.assertTrue(result.contains(searchTerm),
                    "Searchterm "+searchTerm+" is missing in following results: \n"+result);
        }

    }

}
