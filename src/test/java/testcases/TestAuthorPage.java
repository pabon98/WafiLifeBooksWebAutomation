package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import pages.AuthorPage;
import pages.BookPage;
import pages.LoginPage;
import utilities.DriverSetUp;

import java.time.Duration;

public class TestAuthorPage extends DriverSetUp {
    AuthorPage authorPage = new AuthorPage();
    LoginPage loginPage = new LoginPage();
    BookPage bookPage = new BookPage();

    @AfterClass
    public void LogoutUser(){
        Actions logoutAction = new Actions(getDriver());
        WebElement logoutElement = loginPage.getElement(loginPage.Logout_Locator);
        logoutAction.moveToElement(logoutElement).build().perform();
        loginPage.clickOneElement(loginPage.my_account_locator);
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
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
    @Test
    public void GotoAuthorBook(){
        bookPage.clickOneElement(bookPage.book_locator);
        bookPage.clickOneElement(bookPage.Order_book_locator);
        WebDriverWait checkoutWait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
        checkoutWait.until(ExpectedConditions.textToBePresentInElementLocated(bookPage.checkout_popup_cart_title, "আপনি শপিং কার্টে একটি নতুন পণ্য যুক্ত করেছেন"));
        bookPage.clickOneElement(bookPage.checkout_order_button_locator);
    }
    @Test
    public void FillUpBookCheckoutForm() throws InterruptedException {

        WebElement selectDistrictElement = getDriver().findElement(By.tagName("select"));
        Select selectDistrict = new Select(selectDistrictElement);
        selectDistrict.selectByIndex(18);

        // waiting for attaching element to tho Dom
        Thread.sleep(2000);
        WebElement selectAreaElement = getDriver().findElement(By.xpath("//select[@id='billing_area']"));
        Select selectArea = new Select(selectAreaElement);
        selectArea.selectByIndex(4);

        bookPage.getElement(bookPage.full_address_locator).sendKeys("Chandona Chourasta, Gazipur sadar, Gazipur");
        bookPage.getElement(bookPage.order_others_information).sendKeys("please, deliver this book as soon as possible");

    }
}
