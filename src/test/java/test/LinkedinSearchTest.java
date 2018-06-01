package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.LinkedinHomePage;
import page.LinkedinSearchPage;

import java.util.List;
import static java.lang.Thread.sleep;

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
     * @param Searchterm - text for searching
     * @throws InterruptedException - for page with search results
     */
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
                    "Searchterm "+Searchterm+" is missing in following results: \n"+result);
        }

    }

}
