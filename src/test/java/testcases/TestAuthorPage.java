package testcases;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import pages.AuthorPage;
import pages.LoginPage;
import utilities.DriverSetUp;

public class TestAuthorPage extends DriverSetUp {
    AuthorPage authorPage = new AuthorPage();
    LoginPage loginPage = new LoginPage();
    @AfterClass
    public void LogoutUser(){
        loginPage.clickOneElement(loginPage.my_account_locator);
        loginPage.clickOneElement(loginPage.Logout_Locator);
    }
    @Test
    public void GoToAuthorPage(){
        authorPage.LoadAnWebPage(authorPage.author_page_url);
    }
    @Test
    public void GoToNextPage(){
        WebElement nextPage = authorPage.getElement(authorPage.page_number_2_locator);
        Actions actions = new Actions(getDriver());
        actions.scrollToElement(nextPage).build().perform();
        nextPage.click();
    }
    @Test
    public void selectOneWriter(){
        Actions writerAction = new Actions(getDriver());
        WebElement MasudRanaAuthor = authorPage.getElement(authorPage.Writer_Locator);
        writerAction.moveToElement(MasudRanaAuthor).build().perform();
        MasudRanaAuthor.click();
    }
}
