package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.example.stepDefiniation.Hocks.driver;

public class P03_homePage {

    public WebElement HeaderBtn = driver.findElement(By.cssSelector("[class=\"header-upper\"]"));
    public WebElement LogoAndSearch = driver.findElement(By.cssSelector("[class=\"header-lower\"]"));
    public WebElement MenuProducts = driver.findElement(By.cssSelector("[class=\"header-menu\"]"));

}