package org.example.pages;

import org.example.stepDefiniation.Hocks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class P01_register {

    public WebElement icon(){
        WebElement registerIcon = Hocks.driver.findElement(By.className("ico-register"));
        return registerIcon;
    }

    public WebElement Gender(){
        return Hocks.driver.findElement(By.id("gender-male"));
    }
    public WebElement Fname(){
        return Hocks.driver.findElement(By.id("FirstName"));
    }
    public WebElement Lname(){
        return Hocks.driver.findElement(By.id("LastName"));
    }
    public WebElement email(){
        return Hocks.driver.findElement(By.id("Email"));
    }
    public WebElement companyname(){return Hocks.driver.findElement(By.id("Company"));}
    public WebElement password(){
        return Hocks.driver.findElement(By.name("Password"));
    }
    public WebElement confirmpassword(){
        return Hocks.driver.findElement(By.id("ConfirmPassword"));
    }
    public WebElement submitbtn(){
        return Hocks.driver.findElement(By.id("register-button"));
    }

}
