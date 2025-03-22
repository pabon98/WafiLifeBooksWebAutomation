package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class DriverSetUp {
    private static final ThreadLocal <WebDriver> LOCAL_STORAGE = new ThreadLocal<>();

    public static void setDriver(WebDriver driver){
        DriverSetUp.LOCAL_STORAGE.set(driver);
    }
    public static WebDriver getDriver(){
        return LOCAL_STORAGE.get();

    }

    @BeforeSuite
    public void openABrowser(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        setDriver(driver);


    }
    @AfterSuite
    public void closeABrowser(){
     getDriver().quit();
    }
}
