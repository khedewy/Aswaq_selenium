package tests;

import data.RegisterData;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegisterPage;

import java.io.IOException;

public class RegisterTest extends TestBase{

    HomePage homePage;
    RegisterPage registerPage;
    String currentTime = String.valueOf(System.currentTimeMillis());
    @Test
    public void navigateToRegisterPage() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.navigateToRegisterPage();
    }

    @Test(priority = 1)
    public void enterRegisterData() throws IOException, ParseException {
        RegisterData data = new RegisterData();
        data.testData();
        registerPage = new RegisterPage(driver);
        registerPage.enterRegisterData(data.email+currentTime+"@gmail.com", data.password);
        Assert.assertEquals(registerPage.getAssertionMessage(),data.email+currentTime+"@gmail.com");
    }
}
