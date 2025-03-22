package pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage{
    public String Email = "toxelo6839@evluence.com";
    public String Password = "Wafilife@1234";
    public By Email_Locator = By.xpath("//input[@id='username']");
    public By Password_Locator = By.xpath("//input[@id='password']");
    public By Login_Locator = By.xpath("//input[@name='login']");
    public By Logout_Locator = By.xpath("//a[contains(text(),'লগআউট')]");

}
