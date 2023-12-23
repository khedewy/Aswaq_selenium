package tests;

import data.RegisterData;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;

import java.io.IOException;

public class LoginTest extends TestBase {
    HomePage homePage;
    LoginPage loginPage;
    RegisterPage registerPage;
    RegisterData data;
    String currentTime = String.valueOf(System.currentTimeMillis());

    @Test
    public void navigateToRegisterPage() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.navigateToRegisterPage();
    }

    @Test(priority = 1)
    public void enterRegisterData() throws IOException, ParseException {
        data = new RegisterData();
        data.testData();
        registerPage = new RegisterPage(driver);
        registerPage.enterRegisterData(data.email+currentTime+"@gmail.com", data.password);
        Assert.assertEquals(registerPage.getAssertionMessage(),data.email+currentTime+"@gmail.com");
    }

    @Test(priority = 2)
    public void logout(){
        homePage = new HomePage(driver);
        homePage.logout();
    }

    @Test(priority = 3)
    public void navigateToLoginPageAndEnterLoginData() throws IOException, ParseException {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        homePage.navigateToLoginPage();
        data = new RegisterData();
        data.testData();
        loginPage.enterLoginData(data.email+currentTime+"@gmail.com", data.password);
        Assert.assertEquals(loginPage.getAssertionMessage(),data.email+currentTime+"@gmail.com");
    }

}
