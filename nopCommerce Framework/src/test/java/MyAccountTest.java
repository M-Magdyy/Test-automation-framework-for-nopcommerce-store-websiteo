import org.example.HomePage;
import org.example.LoginPage;
import org.example.MyAccountPage;
import org.example.RegistrationPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class MyAccountTest extends TestBase{
    HomePage homePage;
    RegistrationPage registrationPage;
    LoginPage loginPage;
    MyAccountPage myAccountPage;
    String fname="Muhammed";
    String lname="Magdy";
    String email="mas88sss5glsds@yahoo.com";
    String password="Aa12345";
    String newPassword="Aa123456";

    @Test(priority = 1)
    public void userCanRegister(){
        homePage= new HomePage(driver);
        homePage.clickOnRegister();
        registrationPage=new RegistrationPage(driver);
        registrationPage.regDetails(fname,lname
                ,email,password);
        Assert.assertTrue(registrationPage.confirmReg().contains("Your registration completed")
                , "The message isn't the same");

        registrationPage.clickOnMyAccount();

    }
    @Test(priority = 2)
    public void userCanChangeAccPass(){
        myAccountPage=new MyAccountPage(driver);
        myAccountPage.clickChangePass();
        myAccountPage.changePassword(password,newPassword);
       // Assert.assertTrue(myAccountPage.waitForMessage().contains("Password was changed")
              //  ,"this isn't true");
    }
    @Test(priority = 3)
    public void userCanLogOut(){
        myAccountPage.closeX();
        registrationPage.logOut();
    }
    @Test(priority = 4)
    public void userCanLogin(){
        homePage.clickOnLogin();
        loginPage= new LoginPage(driver);
        loginPage.login(email,newPassword);
    }

}
