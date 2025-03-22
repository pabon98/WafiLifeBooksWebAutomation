package pages;

import org.openqa.selenium.By;

public class BookPage extends BasePage{
    public By book_locator = By.xpath("//div[@class='product_item_wrapper']");
    public By book_title_locator = By.xpath("//h1[contains(text(),'Akkharpatra Information and Communication Technolo')]");
    public By Order_book_locator = By.xpath("//button[@class='single_add_to_cart_button button alt ']");
    public By checkout_order_button_locator = By.xpath("//a[@title='checkout']");
    public By checkout_popup_cart_title = By.xpath("//span[@class='title']");
    public By full_address_locator = By.xpath("//textarea[@id='billing_address_1']");
    public By order_others_information = By.xpath("//textarea[@id='order_comments']");



}
