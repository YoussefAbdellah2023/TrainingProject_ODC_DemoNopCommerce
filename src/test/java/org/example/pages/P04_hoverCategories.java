package org.example.pages;

import org.example.stepDefiniation.Hocks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class P04_hoverCategories {


    public WebElement apparel(){
        return Hocks.driver.findElement(By.cssSelector("ul[class=\"top-menu notmobile\"] a[href=\"/apparel\"]"));
    }

    public WebElement sub_option_clothes(){
        return Hocks.driver.findElement(By.cssSelector("ul[class=\"top-menu notmobile\"] a[href=\"/clothing\"]"));
    }
}

