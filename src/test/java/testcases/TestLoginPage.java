package testcases;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utilities.DriverSetUp;

public class TestLoginPage extends DriverSetUp {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @BeforeClass
    public void setup_class(){
     homePage.NavigateToLoginPage();
    }
    @AfterClass
    public void LogoutUser(){
        loginPage.clickOneElement(loginPage.Logout_Locator);
    }
    @Test
    public void SignInWithEmailAndPassword(){
      loginPage.getElement(loginPage.Email_Locator).sendKeys(loginPage.Email);
      loginPage.getElement(loginPage.Password_Locator).sendKeys(loginPage.Password);
      loginPage.clickOneElement(loginPage.Login_Locator);
      Assert.assertTrue(loginPage.getElement(loginPage.Logout_Locator).isDisplayed());
    }
}
