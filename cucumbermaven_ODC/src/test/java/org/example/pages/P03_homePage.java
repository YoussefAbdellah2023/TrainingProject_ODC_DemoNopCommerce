package org.example.pages;

import org.example.stepDefiniation.Hocks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.example.stepDefiniation.Hocks.driver;

public class P03_homePage {

    public WebElement searchpro() {
        return driver.findElement(By.cssSelector("input[class=\"search-box-text ui-autocomplete-input\"][id=\"small-searchterms\"]"));

    }

    public WebElement btnsearch() {
        return driver.findElement(By.cssSelector("button[class=\"button-1 search-box-button\"]"));
    }

    public WebElement clickproductafterresult() {
        return driver.findElement(By.xpath("//div[@class=\"item-box\"]"));
    }

    public List<WebElement> mainLinks() { return
        driver.findElements(By.xpath("//ul[@class=\"top-menu notmobile\"]/li"));
    }
}