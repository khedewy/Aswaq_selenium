package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EditProfilePage {
    private final WebDriver driver;
    Actions actions;
    Select select;
    WebDriverWait wait;
    public EditProfilePage(WebDriver driver){
        this.driver = driver;
    }

    private final By dropDownList = By.xpath("//i[@class='fa fa-caret-down']");
    private final By profile = By.xpath("//*[@id=\"info-topBar\"]/div/div/div[2]/div/div/li[4]/ul/li[2]/a/span");
    private final By editProfile = By.xpath("//a[text()='Edit Info']");
    private final By firstNameTxt = By.id("id_first_name");
    private final By lastNameTxt = By.id("id_last_name");
    private final By genderList = By.id("id_gender");
    private final By MobileNumber = By.id("id_phone_number");
    private final By idNumberTxt = By.id("id_id_number");
    private final By currencyList = By.id("id_preferred_currency");
    private final By saveButton = By.xpath("//button[@class='btn btn-block btn-red-bg btn-font-fff-bold']");
    private final By assertionMessage = By.xpath("//*[@id=\"info-topBar\"]/div/div/div[2]/div/div/li[4]/a/span");


    public void navigateToProfilePage(){
        actions = new Actions(driver);
        actions.moveToElement(driver.findElement(dropDownList)).perform();
        driver.findElement(profile).click();
    }

    public void editProfile(String firstName,String lastName,String gender,
                            String Mobile, String idNumber,String currency){
        driver.findElement(editProfile).click();
        driver.findElement(firstNameTxt).clear();
        driver.findElement(firstNameTxt).sendKeys(firstName);
        driver.findElement(lastNameTxt).clear();
        driver.findElement(lastNameTxt).sendKeys(lastName);
        select = new Select(driver.findElement(genderList));
        select.selectByVisibleText(gender);
        driver.findElement(MobileNumber).sendKeys(Mobile);
        driver.findElement(idNumberTxt).sendKeys(idNumber);
        select = new Select(driver.findElement(currencyList));
        select.selectByVisibleText(currency);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(saveButton)));
        driver.findElement(saveButton).click();
    }

    public String getAssertionMessage(){
        return driver.findElement(assertionMessage).getText();
    }


}
