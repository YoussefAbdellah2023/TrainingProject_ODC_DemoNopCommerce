package org.example.pages;

import org.example.stepDefiniation.Hocks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class P02_login {

  public WebElement icon(){return Hocks.driver.findElement(By.className("ico-login"));}
    public WebElement Email(){return Hocks.driver.findElement(By.cssSelector("input[id=\"Email\"]"));}
    public WebElement Password(){return Hocks.driver.findElement(By.cssSelector("input[id=\"Password\"]"));}
    public WebElement PressLogin(){return Hocks.driver.findElement(By.cssSelector("button[class=\"button-1 login-button\"]"));}




}
