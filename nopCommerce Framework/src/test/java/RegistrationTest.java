import org.example.HomePage;
import org.example.LoginPage;
import org.example.RegistrationPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class RegistrationTest extends TestBase{
    HomePage homePage;
    RegistrationPage registrationPage;
    LoginPage loginPage;
    @Test(priority = 1)
    public void userCanRegister(){
        homePage= new HomePage(driver);
        homePage.clickOnRegister();
        registrationPage=new RegistrationPage(driver);
        registrationPage.regDetails("Muhammed","Magdy"
                ,"m1234@yahoo.com","Aa12345");
        Assert.assertTrue(registrationPage.confirmReg().contains("Your registration completed"), "The message isn't the same");
    }
    @Test(dependsOnMethods = {"userCanRegister"})
    public void userCanLogOut(){
        registrationPage.logOut();
    }
    @Test(dependsOnMethods = {"userCanLogOut"})
    public void userCanLogin(){
        homePage.clickOnLogin();
        loginPage= new LoginPage(driver);
        loginPage.login("m1234@yahoo.com","Aa12345");
    }
}
