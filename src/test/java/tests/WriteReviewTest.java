package tests;

import data.RegisterData;
import data.WriteReviewData;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegisterPage;
import pages.SearchPage;
import pages.WriteReviewPage;

import java.io.IOException;

public class WriteReviewTest extends TestBase{

    HomePage homePage;
    RegisterPage registerPage;
    SearchPage searchPage;
    WriteReviewPage writeReviewPage;
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
    public void searchForProduct(){
        searchPage = new SearchPage(driver);
        searchPage.searchForProducts("laptob");
    }

    @Test(priority = 3)
    public void writeReview() throws IOException, ParseException {
        writeReviewPage = new WriteReviewPage(driver);
        WriteReviewData data = new WriteReviewData();
        data.reviewData();
        writeReviewPage.addReview(data.title, data.body);
        Assert.assertEquals(writeReviewPage.getAssertionMessage(),"Thank You !");
    }
}
