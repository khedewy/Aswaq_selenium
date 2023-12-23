package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UpdateWishListPage {
    private final WebDriver driver;
    WebDriverWait wait;
    public UpdateWishListPage(WebDriver driver){
        this.driver = driver;
    }

    private final By removeProductButton = By.xpath("//button[@class='wishlist-option remove-btn-wishlist']");
    private final By removingProductAssertion = By.xpath("//div[text()='Your wish list is empty.']");
    private final By editWishListButton = By.id("edit-wishlist");
    private final By changeListName = By.name("name");
    private final By doneButton = By.xpath("//button[@class='btn btn-default btn-red-bg btn-font-fff-bold']");
    private final By changeListNameAssertion = By.xpath("//div[@class='wishlist-name']");
    private final By deleteListButton = By.id("remove-wishlist");
    private final By confirmDelete = By.xpath("//button[text()='Delete']");
    private final By deleteListAssertion = By.xpath("//*[@id=\"default\"]/div[1]/div[2]/div/div/div[2]/div/div/div/div[1]");


    public void removeProduct(){
        driver.findElement(removeProductButton).click();
    }

    public String getRemovingProductAssertionMessage(){
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(removingProductAssertion)));
        return driver.findElement(removingProductAssertion).getText();
    }

    public void changeListName(String name){
        driver.findElement(editWishListButton).click();
        driver.findElement(changeListName).clear();
        driver.findElement(changeListName).sendKeys(name);
        driver.findElement(doneButton).click();
    }
    public String getChangeListNameAssertion(){
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(changeListNameAssertion)));
        return driver.findElement(changeListNameAssertion).getText();
    }

    public void deleteList(){
        driver.findElement(deleteListButton).click();
        driver.findElement(confirmDelete).click();
    }

    public String getDeleteListAssertionMessage(){
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(deleteListAssertion)));
        return driver.findElement(deleteListAssertion).getText();
    }
}
