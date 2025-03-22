package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.DriverSetUp;

public class TestHomePage extends DriverSetUp {
    HomePage homePage = new HomePage();
    @Test
    public void TestHomePageUrl(){
      homePage.LoadAnWebPage(homePage.home_page_url);
        Assert.assertEquals(getDriver().getCurrentUrl(), homePage.home_page_url);
    }
    @Test
    public void TestHomePageTitle(){
        homePage.LoadAnWebPage(homePage.home_page_url);
        Assert.assertEquals(getDriver().getTitle(), homePage.home_page_title);
    }

}
