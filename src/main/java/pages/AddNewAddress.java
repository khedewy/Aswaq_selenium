package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddNewAddress {
    private final WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    public AddNewAddress(WebDriver driver){
        this.driver = driver;
    }

    private final By dropDownList = By.xpath("//i[@class='fa fa-caret-down']");
    private final By address = By.xpath("//*[@id=\"info-topBar\"]/div/div/div[2]/div/div/li[4]/ul/li[5]/a/span");
    private final By addNewAddressButton = By.xpath("//a[@class='btn btn-default btn-red-bg btn-font-fff-bold']");
    private final By fullNameTxt = By.id("id_full_name");
    private final By countryTxt = By.id("select2-chosen-1");
    private final By countryChosen = By.xpath("//*[@id=\"select2-results-1\"]/li[2]");
    private final By cityTxt = By.id("select2-chosen-2");
    private final By cityChosen = By.xpath("//*[@id=\"select2-results-2\"]/li[6]");
    private final By phoneNumberTxt = By.id("id_phone_number");
    private final By F_LineAddressTxt = By.id("id_line1");
    private final By noteTxt = By.id("id_notes");
    private final By saveButton = By.xpath("//button[@class='btn btn-default btn-red-bg btn-font-fff-bold no-margin']");
    private final By assertionMessage = By.xpath("//div[text()='My Address']");

    public void navigateToAddressPage(){
        actions = new Actions(driver);
        actions.moveToElement(driver.findElement(dropDownList)).perform();
        driver.findElement(address).click();
    }

    public void enterAddressData(String fullName,String phone,String F_line,String note){
        driver.findElement(addNewAddressButton).click();
        driver.findElement(fullNameTxt).sendKeys(fullName);
        driver.findElement(countryTxt).click();
        driver.findElement(countryChosen).click();
        driver.findElement(cityTxt).click();
        driver.findElement(cityChosen).click();
        driver.findElement(phoneNumberTxt).sendKeys(phone);
        driver.findElement(F_LineAddressTxt).sendKeys(F_line);
        driver.findElement(noteTxt).sendKeys(note);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(saveButton)));
        driver.findElement(saveButton).click();
    }

    public String getAssertionMessage(){
        return driver.findElement(assertionMessage).getText();
    }


}
