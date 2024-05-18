package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends PageBase{
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    WebElement loginEmail=driver.findElement(By.id("Email"));
    WebElement loginPassword= driver.findElement(By.id("Password"));
    WebElement loginBtn= driver.findElement(By.cssSelector("button.button-1.login-button"));
    public void login(String email,String password){
        setTextElement(loginEmail,email);
        setTextElement(loginPassword,password);
        clickBtn(loginBtn);
    }
}
