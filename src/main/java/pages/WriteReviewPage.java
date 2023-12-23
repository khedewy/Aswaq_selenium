package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WriteReviewPage {
    private final WebDriver driver;
    WebDriverWait wait;
    public WriteReviewPage(WebDriver driver){
        this.driver = driver;
    }

    private final By product = By.xpath("//a[text()='HP Elitebook 8470 Laptop, Intel Core i7, 8GB RAM, 500 GB HDD, DOS, Black, A1G60AV']");
    private final By addReviewButton = By.id("add-review");
    private final By Score = By.xpath("//*[@id=\"add_review_form\"]/fieldset/div[1]/div/div[3]/i[4]");
    private final By titleTxt = By.id("id_title");
    private final By bodyTxt = By.id("id_body");
    private final By submitButton = By.xpath("//button[@class='btn btn-red-bg btn-lg btn-submit-review' and text()='Submit'][1]");
    private final By assertionMessage = By.xpath("//h1[text()='Thank You !']");


    public void addReview(String title, String Body){
        driver.findElement(product).click();
        driver.findElement(addReviewButton).click();
        driver.findElement(Score).click();
        driver.findElement(titleTxt).sendKeys(title);
        driver.findElement(bodyTxt).sendKeys(Body);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(submitButton)));
        driver.findElement(submitButton).click();
    }

    public String getAssertionMessage(){
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(assertionMessage)));
        return driver.findElement(assertionMessage).getText();
    }
}
