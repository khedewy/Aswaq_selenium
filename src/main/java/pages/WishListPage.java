package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WishListPage {
    private final WebDriver driver;
    WebDriverWait wait;
    Actions actions;
    public WishListPage(WebDriver driver){
        this.driver = driver;
    }

    private final By product = By.xpath("//a[text()='Zebra Sarasa Ink Pen, 0.7 mm, Rollerball, Black']");
    private final By productAssertionMessage = By.xpath("//h3[text()='Zebra Sarasa Ink Pen, 0.7 mm, Rollerball, Black']");
    private final By addToWishlistButton = By.xpath("//button[@class='btn btn-default dropdown-toggle add-to-wishlist btn-white-bg']");
    private final By wishlistName = By.name("name");
    private final By submitAddingTOWishList = By.xpath("//button[@class='add_to_wishlist_submit btn-link']");
    private final By dropDownList = By.xpath("//i[@class='fa fa-caret-down']");
    private final By wishlist = By.xpath("//*[@id=\"info-topBar\"]/div/div/div[2]/div/div/li[4]/ul/li[4]/a/span");
    private final By assertionMessage = By.xpath("//div[@class='wishlist-name']");

    public void navigateToProduct(){
        driver.findElement(product).click();
    }

    public String getProductChosenAssertionMessage(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver.findElement(productAssertionMessage).getText();
    }

    public void addToWishList(String listName){
        driver.findElement(addToWishlistButton).click();
        driver.findElement(wishlistName).sendKeys(listName);
        driver.findElement(submitAddingTOWishList).click();
    }

    public void moveToWishList(){
        actions = new Actions(driver);
        actions.moveToElement(driver.findElement(dropDownList)).perform();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(wishlist)));
        driver.findElement(wishlist).click();
    }

    public String getAssertionMessage(){
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(assertionMessage)));
        return driver.findElement(assertionMessage).getText();
    }
}
