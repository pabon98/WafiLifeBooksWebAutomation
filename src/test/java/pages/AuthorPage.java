package pages;

import org.openqa.selenium.By;

public class AuthorPage extends BasePage{
    public String author_page_url = "https://www.wafilife.com/cat/books/author";
    public By Writer_Locator = By.xpath("//li[44]");
    public By page_number_2_locator = By.xpath("//a[normalize-space()='2']");
}
