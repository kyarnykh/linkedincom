import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkedinHomePage {
    private WebDriver webDriver;

    private WebElement profileMenu;


    public LinkedinHomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        initElements(); //почему мы вызываем инициализацию именно в конструкторе
    }

    public void initElements() {
        profileMenu = webDriver.findElement(By.xpath("//*[@id='profile-nav-item']"));
    }

    public boolean isProfileMenuIsDisplayed() {
        return profileMenu.isDisplayed();
    }

    public String getCurrentPageTittle() {
        return webDriver.getTitle();
    }



}
