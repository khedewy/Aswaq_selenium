package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;


import java.time.Duration;

public class HomePage {
    private final WebDriver driver;
    Actions actions;
    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    private final By registerIcon = By.id("login_link");
    private final By registerButton = By.xpath("//a[@class='btn btn-default btn-blue-bg btn-font-fff-bold']");
    private final By dropDownList = By.xpath("//i[@class='fa fa-caret-down']");
    private final By logoutButton = By.xpath("//*[@id=\"info-topBar\"]/div/div/div[2]/div/div/li[4]/ul/li[6]/a/i");

    public RegisterPage navigateToRegisterPage() throws InterruptedException {
        driver.findElement(registerIcon).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(registerButton).click();
        return new RegisterPage(driver);
    }

    public void logout(){
        actions = new Actions(driver);
        actions.moveToElement(driver.findElement(dropDownList)).perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        actions.moveToElement(driver.findElement(logoutButton)).click().build().perform();
    }

    public LoginPage navigateToLoginPage(){
        driver.findElement(registerIcon).click();
        return new LoginPage(driver);
    }
}
