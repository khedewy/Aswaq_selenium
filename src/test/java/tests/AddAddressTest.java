package tests;

import data.AddAddressData;
import data.RegisterData;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddNewAddress;
import pages.HomePage;
import pages.RegisterPage;

import java.io.IOException;

public class AddAddressTest extends TestBase{
    HomePage homePage;
    RegisterPage registerPage;
    AddNewAddress addNewAddress;
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

    @Test(priority = 2)
    public void navigateToAddressPage(){
        addNewAddress = new AddNewAddress(driver);
        addNewAddress.navigateToAddressPage();
    }

    @Test(priority = 3)
    public void addNewAddress() throws IOException, ParseException {
        AddAddressData data = new AddAddressData();
        data.addAddressData();
        addNewAddress = new AddNewAddress(driver);
        addNewAddress.enterAddressData(data.fullName, data.phone, data.firstLine, data.note);
        Assert.assertEquals(addNewAddress.getAssertionMessage(),"My Address");
    }
}
