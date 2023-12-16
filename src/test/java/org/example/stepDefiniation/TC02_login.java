package org.example.stepDefiniation;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_login;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

import static org.example.stepDefiniation.Hocks.driver;

public class TC02_login {
    P02_login login = new P02_login();
    SoftAssert soft = new SoftAssert();
    @Given("user go to login page")
    public void LoginPage(){
        login.icon().click();
    }

    @When("user login with valid data")
    public void FIllValidData(){
        login.Email().sendKeys("youssef@gmail.com");
        login.Password().sendKeys("abc123");
    }

    @When("user login with invalid data {string} and {string}")
    public void FillInvalidData(String email, String password){
        login.Email().sendKeys(email);
        login.Password().sendKeys(password);
    }
    @And("user press on login button")
    public void PressBtnLogin(){
        login.PressLogin().click();
    }
    @Then("user login to the system successfully and logout")
    public void success(){

        soft.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/");
        login.LogoutBtn().click();
        soft.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/");

        soft.assertAll();
    }




    @Then("display error message")
    public void ErrorMessagesLogin() {


        List<WebElement> elements = driver.findElements(By.xpath("//span[@class=\"field-validation-error\"]"));
        int maxproducts = elements.size();
        System.out.println("The Number Of Error Message ="+maxproducts);

        for (int i = 0; i < elements.size(); i++) {
            String ErrorMessage = elements.get(i).getText();
            System.out.println("The Error Message Under For Each Field = "+ErrorMessage);
            String rgb =elements.get(i).getCssValue("color");
            System.out.println("The Color Is = "+rgb);
            soft.assertEquals(rgb,"rgba(228, 67, 75, 1)");
            String HexColor= Color.fromString(rgb).asHex();
            System.out.println("The Hex Color is = "+HexColor);
            soft.assertEquals(HexColor,"#e4434b");
            soft.assertAll();

        }

        List<WebElement> elements2 = driver.findElements(By.xpath("//div[@class=\"message-error validation-summary-errors\"]"));
        int maxproducts2 = elements2.size();
        System.out.println("The Number Of Error Message ="+maxproducts2);

        for (int i = 0; i < elements2.size(); i++) {
            String ErrorMessage2 = elements2.get(i).getText();
            System.out.println("The Error Message Under For Each Field = "+ErrorMessage2);
            String rgb =elements2.get(i).getCssValue("color");
            System.out.println("The Color Is = "+rgb);
            soft.assertEquals(rgb,"rgba(228, 67, 75, 1)");
            String HexColor= Color.fromString(rgb).asHex();
            System.out.println("The Hex Color is = "+HexColor);
            soft.assertEquals(HexColor,"#e4434b");
            soft.assertAll();
        }

    }
    }

