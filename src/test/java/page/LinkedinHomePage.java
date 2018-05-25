package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinHomePage extends LinkedinBasePage {

    @FindBy(xpath = "//*[@id='profile-nav-item']")
    private WebElement profileMenu;
    @FindBy(xpath = "//*[@role='combobox']")
    private WebElement searchField;
    @FindBy(xpath = "//*[@id='nav-search-controls-wormhole']/button")
    private WebElement searchButton;


    public LinkedinHomePage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @Override
    public boolean isPageLoaded() {
        return profileMenu.isDisplayed();
    }

    public void search (String searchText){
        searchField.sendKeys(searchText);
        searchButton.click();
    }

}
