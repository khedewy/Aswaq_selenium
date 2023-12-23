package tests;

import data.EditProfileData;
import data.RegisterData;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EditProfilePage;
import pages.HomePage;
import pages.RegisterPage;

import java.io.IOException;

public class EditProfileTest extends TestBase{

    HomePage homePage;
    RegisterPage registerPage;
    EditProfilePage editProfilePage;
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
    public void navigateToProfilePage(){
        editProfilePage = new EditProfilePage(driver);
        editProfilePage.navigateToProfilePage();
    }

    @Test(priority = 3)
    public void editProfileInf() throws IOException, ParseException {
        EditProfileData data = new EditProfileData();
        data.editProfileData();
        editProfilePage = new EditProfilePage(driver);
        editProfilePage.editProfile(data.firstName, data.lastName, data.gender, data.MobileNumber, data.idNumber, data.currency);
        Assert.assertEquals(editProfilePage.getAssertionMessage(),"mahmoud khedewy");
    }
}
