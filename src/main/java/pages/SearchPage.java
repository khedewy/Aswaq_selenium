package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {
    private final WebDriver driver;
    public SearchPage(WebDriver driver){
        this.driver = driver;
    }

    private final By searchBox = By.id("id_q");
    private final By searchButton = By.id("submit_search");
    private final By assertionMessage = By.xpath("//b");

    public void searchForProducts(String product){
        driver.findElement(searchBox).sendKeys(product);
        driver.findElement(searchButton).click();
    }

    public String getAssertionMessage(){
       return driver.findElement(assertionMessage).getText();
    }
}
