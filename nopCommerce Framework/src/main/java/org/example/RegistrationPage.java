package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage extends PageBase{
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }
    WebElement regGenBtn=driver.findElement(By.id("gender-male"));
    WebElement regFirstName=driver.findElement(By.id("FirstName"));
    WebElement regLastName=driver.findElement(By.id("LastName"));
    WebElement regEmail=driver.findElement(By.id("Email"));
    WebElement regPassword=driver.findElement(By.id("Password"));
    WebElement regConfirmPassword=driver.findElement(By.id("ConfirmPassword"));
    WebElement regButton=driver.findElement(By.id("register-button"));

    public void regDetails(String firstName, String lastName, String email, String password){
        clickBtn(regGenBtn);
        setTextElement(regFirstName,firstName);
        setTextElement(regLastName,lastName);
        setTextElement(regEmail,email);
        setTextElement(regPassword,password);
        setTextElement(regConfirmPassword,password);
        clickBtn(regButton);
    }
    public String confirmReg(){
        WebElement regResult=driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]"));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(regResult));
        return driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]")).getText();
    }
    public void logOut(){
        WebElement logOutLink=driver.findElement(By.linkText("Log out"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(logOutLink));
        clickBtn(logOutLink);
    }
    public void clickOnMyAccount(){
        WebElement myAccLink=driver.findElement(By.cssSelector("body > div.master-wrapper-page > div.header > div.header-upper > div.header-links-wrapper > div.header-links > ul > li:nth-child(1) > a"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(myAccLink));
        clickBtn(myAccLink);
    }
}
