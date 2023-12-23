package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SearchPage;

public class SearchTest extends TestBase{

    SearchPage searchPage;

    @Test
    public void searchForProducts(){
        searchPage = new SearchPage(driver);
        searchPage.searchForProducts("pens");
        Assert.assertEquals(searchPage.getAssertionMessage(),"pens");
    }
}
