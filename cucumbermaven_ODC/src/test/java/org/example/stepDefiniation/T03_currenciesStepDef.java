package org.example.stepDefiniation;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import org.checkerframework.checker.units.qual.C;
import org.example.pages.P03_homePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static org.example.stepDefiniation.Hocks.driver;

public class T03_currenciesStepDef {
    P03_homePage homePage = new P03_homePage();

    @When("user select Euro currency")
    public void currency() {


        Select dropCurrency = new Select(driver.findElement(By.name("customerCurrency")));
        dropCurrency.selectByIndex(1);

    }

    @And("check the Euro symbol is shown on the products")
    public void verify() {

        int size = driver.findElements(By.xpath("//div[@class=\"prices\"]//span[contains(text(),'')]")).size();
        System.out.println("The Size is = " +size);

        for (int i = 0; i < size; i++) {
            String text = driver.findElements(By.xpath("//div[@class=\"prices\"]//span[contains(text(),'')]")).get(i).getText();
            System.out.println(i);
            System.out.println(text);

            SoftAssert softAssert = new SoftAssert();
            softAssert.assertTrue(text.toLowerCase().contains("€"));
            softAssert.assertAll();

        }

    }
}

