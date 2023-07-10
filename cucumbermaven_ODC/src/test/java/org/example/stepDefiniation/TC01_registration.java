package org.example.stepDefiniation;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pages.P01_register;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import static org.example.stepDefiniation.Hocks.driver;

public class TC01_registration {

    P01_register register = new P01_register();
    @And("user go to url")
    public void url(){
        driver.navigate().to("https://demo.nopcommerce.com/");

    }

    @And("user press on register icon")
    public void registerButton(){
        register.icon().click();




    }

    @And("user fill all required data")
    public void fillData(){

        register.Gender().click();
        register.Fname().sendKeys("Youssef");
        register.Lname().sendKeys("abdellah");

        WebElement listofday = driver.findElement(By.name("DateOfBirthDay"));
        Select selectDay = new Select(listofday);
        // int random_int = (int) Math.floor(Math.random()*(max-min+1)+min) ;
        int random_int = (int) Math.floor(Math.random()*(32-1+1)+1) ;
        selectDay.selectByIndex(random_int);

        WebElement listofmonth = driver.findElement(By.name("DateOfBirthMonth"));
        Select selectMonth = new Select(listofmonth);
        // int random_int = (int) Math.floor(Math.random()*(max-min+1)+min) ;
        int random_intMonth = (int) Math.floor(Math.random()*(12-1+1)+1) ;
        selectMonth.selectByIndex(random_intMonth);


        WebElement listofyear = driver.findElement(By.name("DateOfBirthYear"));
        Select selectYear = new Select(listofyear);
        // int random_int = (int) Math.floor(Math.random()*(max-min+1)+min) ;
        int random_intYear = (int) Math.floor(Math.random()*(111-1+1)+1) ;
        selectYear.selectByIndex(random_intYear);

        register.email().sendKeys("youssef1425@gmail.com");
        register.companyname().sendKeys("ODC");
        register.password().sendKeys("123456789");
        register.confirmpassword().sendKeys("123456789");


    }

    @And("user press on register button")
    public void pressSubmit(){
        register.submitbtn().click();

    }

    @Then("registration done successfully with success message is displayed")
    public void registerSuccess(){

        SoftAssert softAssert = new SoftAssert();
        String SuccessMsg = driver.findElement(By.className("result")).getText();
        softAssert.assertTrue(SuccessMsg.contains("Your registration completed"));
        softAssert.assertAll();

        String rgb = driver.findElement(By.className("result")).getCssValue("color");
        System.out.println(rgb);
        softAssert.assertEquals(rgb,"rgba(76, 177, 124, 1)");


//      String Hexcolor=Color.fromString(rgb).asHex();
//        System.out.println(Hexcolor);
//        softAssert.assertEquals(Hexcolor,"#e4434b");

    }





}
