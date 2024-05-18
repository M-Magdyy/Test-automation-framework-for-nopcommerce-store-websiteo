package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class MyAccountPage extends PageBase{
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }
    private WebElement getChangePassLink() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return driver.findElement(By.cssSelector("#main > div > div.side-2 > div > div.listbox > ul > li.change-password.inactive > a"));
    }

    private WebElement getOldPassword() {
        return driver.findElement(By.id("OldPassword"));
    }
    private WebElement getNewPassword() {
        return driver.findElement(By.id("NewPassword"));
    }

    private WebElement getConfirmPassword() {
        return driver.findElement(By.id("ConfirmNewPassword"));
    }

    private WebElement getChangePassBtn() {
        return driver.findElement(By.cssSelector("button.button-1.change-password-button"));
    }
    public void clickChangePass(){
        clickBtn(getChangePassLink());
    }
    public void changePassword(String oldPass,String newPass){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(getOldPassword()));
        setTextElement(getOldPassword(),oldPass);
        setTextElement(getNewPassword(),newPass);
        setTextElement(getConfirmPassword(),newPass);
        clickBtn(getChangePassBtn());
    }
    /*
    public String waitForMessage(){
        WebElement msgLink=driver.findElement(By.cssSelector("p.content"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


       return wait.until(ExpectedConditions.visibilityOf(msgLink)).getText();
    }*/

    public void closeX(){
        WebElement btnn= driver.findElement(By.cssSelector("#bar-notification > div > span"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(btnn));
        clickBtn(btnn);
    }
}
