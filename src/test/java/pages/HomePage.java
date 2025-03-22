package pages;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import java.time.Duration;

public class HomePage extends BasePage{
    public String home_page_url = "https://www.wafilife.com/";
    public String home_page_title = "Buy Islamic Books - Online Book Shop in Bangladesh | Wafilife";
    public By Sign_In_Locator = By.xpath("//a[@title='আমার অ্যাকাউন্ট'][contains(text(),'লগইন / রেজিস্টার')]");


    public void NavigateToLoginPage(){
     LoadAnWebPage(home_page_url);
     getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     clickOneElement(Sign_In_Locator);
    }
}


