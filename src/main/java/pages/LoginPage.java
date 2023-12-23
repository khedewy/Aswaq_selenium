package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private final WebDriver driver;
    WebDriverWait wait;
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }
    private final By emailTxt = By.id("id_login-username");
    private final By passwordTxt = By.id("id_login-password");
    private final By loginButton = By.name("login_submit");
    private final By assertionMessage = By.xpath("//*[@id=\"info-topBar\"]/div/div/div[2]/div/div/li[4]/a/span");

    public void enterLoginData(String email, String password){
        driver.findElement(emailTxt).sendKeys(email);
        driver.findElement(passwordTxt).sendKeys(password);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(loginButton)));
        driver.findElement(loginButton).click();
    }

    public String getAssertionMessage(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver.findElement(assertionMessage).getText();
    }
}
