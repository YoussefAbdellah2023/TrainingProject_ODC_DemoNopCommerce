package org.example.stepDefiniation;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_register;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import static org.example.stepDefiniation.Hocks.driver;

public class TC01_registration {

    P01_register register = new P01_register();
    SoftAssert soft = new SoftAssert();

    Assertion assertion = new Assertion();


    @When("user press on register icon")
    public void registerButton(){
        register.icon().click();

    }

    @When("user fill valid data")
    public void FillValidData(){

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

        register.email().sendKeys("youssef1234@gmail.com");
        register.companyname().sendKeys("ODC");
        register.password().sendKeys("abc123");
        register.confirmpassword().sendKeys("abc123");




    }

    @And("user fill invalid and empty {string}, {string}, {string}, {string}, and {string}")
    public void EnterInvalidData(String firstname, String lastname, String email, String password, String confirmpassword){

        register.Gender().click();
        register.Fname().sendKeys(firstname);
        register.Lname().sendKeys(lastname);

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

        register.email().sendKeys(email);
        register.companyname().sendKeys("ODC");
        register.password().sendKeys(password);
        register.confirmpassword().sendKeys(confirmpassword);


    }


    @When("user press on register button")
    public void pressSubmit(){
        register.submitbtn().click();

    }

//    @And("alert message is display")
//    public void AlertMessage(){
//        Alert alert = driver.switchTo().alert();
//
//        String AlertSuccessMessage = driver.switchTo().alert().getText();
//        System.out.println("Success Message Register = " + AlertSuccessMessage);
//
//        driver.switchTo().alert().accept();
//    }

    @Then("registration done successfully with success message is displayed")
    public void registerSuccess(){

        String SuccessMsg = driver.findElement(By.cssSelector("div[class=\"result\"]")).getText();
        System.out.println("The Success Message  is = " + SuccessMsg);
        soft.assertTrue(SuccessMsg.contains("Your registration completed"));


        String rgb = driver.findElement(By.className("result")).getCssValue("color");
        System.out.println("The rgb is = "+rgb);
        soft.assertEquals(rgb,"rgba(76, 177, 124, 1)");

        String Hexcolor=Color.fromString(rgb).asHex();
        System.out.println(Hexcolor);
        soft.assertEquals(Hexcolor,"#4cb17c");

        soft.assertAll();
        register.ContinueBtn().click();

    }




@Then("registration error message is displayed")
    public void ErrorMessage(){

    List<WebElement> elements = driver.findElements(By.xpath("//span[@class=\"field-validation-error\"]"));
    int maxproducts = elements.size();
    System.out.println("The Number Of Error Message ="+maxproducts);
    for (int i = 0; i < elements.size(); i++) {
        String ErrorMessage = elements.get(i).getText();
        System.out.println("The Error Message Under For Each Field = "+ErrorMessage);

    }

    List<WebElement> elements2 = driver.findElements(By.xpath("//div[@class=\"message-error validation-summary-errors\"]"));
    int maxproducts2 = elements2.size();
    System.out.println("The Number Of Error Message ="+maxproducts2);
    for (int i = 0; i < elements2.size(); i++) {
        String ErrorMessage = elements2.get(i).getText();
        System.out.println("The Error Message Above All Fields = "+ErrorMessage);

    }



}}
