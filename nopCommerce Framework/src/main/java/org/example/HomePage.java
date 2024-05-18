package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends PageBase{
    public HomePage(WebDriver driver) {
        super(driver);
    }
   // @FindBy(linkText = "Register")
   // WebElement registerLink;
   WebElement registerLink=driver.findElement(By.linkText("Register"));

    public void clickOnRegister(){
        clickBtn(registerLink);
    }
    public void clickOnLogin(){
        WebElement loginLink=driver.findElement(By.linkText("Log in"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(loginLink));
        clickBtn(loginLink);
    }
}
