import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkedinHomePage extends LinkedinBasePage {

    private WebElement profileMenu;
    private WebElement searchField;
    private WebElement searchButton;


    public LinkedinHomePage(WebDriver webDriver) {
        super(webDriver);
        initElements();
    }

    @Override
    boolean isPageLoaded() {
        return profileMenu.isDisplayed();
    }

    public void initElements() {
        profileMenu = webDriver.findElement(By.xpath("//*[@id='profile-nav-item']"));
        searchField = webDriver.findElement(By.xpath("//*[@role='combobox']"));
        searchButton = webDriver.findElement(By.xpath("//*[@id='nav-search-controls-wormhole']/button"));
    }

    public void search (String searchText){
        searchField.sendKeys(searchText);
        searchButton.click();
    }

}
