import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

import static java.lang.Thread.sleep;

public class BadCodeExample {

public static void main(String args[]) throws InterruptedException {
    System.out.println("Hello World!!!");
    WebDriver webDriver = new FirefoxDriver();
    webDriver.get("https://www.google.com");
    WebElement searchField = webDriver.findElement(By.name("q"));
    String searchTerm = "selenium";
    searchField.sendKeys(searchTerm);
    searchField.sendKeys(Keys.RETURN);

    sleep (3000);

    List<WebElement> searchResults1 = webDriver.findElements(By.xpath("//div[@class='srg']/div[@class='g']"));

    System.out.println("Number of results: "+searchResults1.size());

    for (WebElement searchResult1 : searchResults1) {
        String searchResultText = searchResult1.getText();
        if (searchResultText.contains(searchTerm)) {
            System.out.println("Search term found in result item");
        }
        System.out.println(searchResultText);
    }

    sleep (5000);
    webDriver.close();

}


}
