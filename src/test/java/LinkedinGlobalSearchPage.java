import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkedinGlobalSearchPage extends LinkedinBasePage {


    private WebElement searchMenu;


    public LinkedinGlobalSearchPage(WebDriver webDriver) {
        super(webDriver);
        initElements();
    }

    @Override
    boolean isPageLoaded() {
        return searchMenu.isDisplayed();
    }

    public void initElements() {
        searchMenu = webDriver.findElement(By.xpath("//*/ul/li[1]/button"));
    }

}
