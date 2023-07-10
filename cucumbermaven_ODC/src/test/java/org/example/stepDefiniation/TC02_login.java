package org.example.stepDefiniation;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_login;
import org.openqa.selenium.By;
import org.openqa.selenium.support.Color;
import org.testng.asserts.SoftAssert;

import java.awt.*;

import static org.example.stepDefiniation.Hocks.driver;

public class TC02_login {
    P02_login login = new P02_login();
    @Given("user go to login page")
    public void loginpage(){
        login.icon().click();
    }
    @When("user login with valid data")
    public void filldata(){
        login.Email().sendKeys("youssef1425@gmail.com");
        login.Password().sendKeys("123456789");
    }
    @And("user press on login button")
    public void pressbtnlogin(){
        login.PressLogin().click();
    }
    @Then("user login to the system successfully")
    public void success(){

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(Hocks.driver.getCurrentUrl(),"https://demo.nopcommerce.com/");
        boolean tabaccount = driver.findElement(By.cssSelector("a[class=\"ico-account\"]")).isDisplayed();
        softAssert.assertTrue(tabaccount);
        softAssert.assertAll();

    }


    @When("user login with invalid data")
    public void fillinvaliddata(){
        login.Email().sendKeys("youssef1515@gmail.com");
        login.Password().sendKeys("12345678");
    }
    @Then("user could not login to the system")
    public void unsuccess() {

        SoftAssert softAssert = new SoftAssert();
        String unSuccessMsg = driver.findElement(By.cssSelector("div[class=\"message-error validation-summary-errors\"]")).getText();
        softAssert.assertTrue(unSuccessMsg.contains("Login was unsuccessful."));

        String rgb = driver.findElement(By.cssSelector("div[class=\"message-error validation-summary-errors\"]")).getCssValue("color");
        System.out.println(rgb);
        softAssert.assertEquals(rgb,"rgba(228, 67, 75, 1)");
        String Hexcolor= Color.fromString(rgb).asHex();
        System.out.println(Hexcolor);
        softAssert.assertEquals(Hexcolor,"#e4434b");



        softAssert.assertAll();



    }
    }

