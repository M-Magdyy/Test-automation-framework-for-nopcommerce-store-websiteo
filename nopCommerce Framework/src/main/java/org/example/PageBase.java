package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageBase {
    protected WebDriver driver;
    public PageBase(WebDriver driver){
        this.driver=driver;
    }
    protected void clickBtn(WebElement btn){
        btn.click();
    }
    protected void setTextElement(WebElement txtElement,String txt){
        txtElement.sendKeys(txt);
    }
}
