package org.example.stepDefiniation;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import static org.example.stepDefiniation.Hocks.driver;


public class TC04_searchStepDef {

    P03_homePage search = new P03_homePage();
    @When("user go to url search")
    public void urlsearch(){
        Hocks.driver.navigate().to("https://demo.nopcommerce.com/search?q=");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(Hocks.driver.getCurrentUrl(),"https://demo.nopcommerce.com/search?q=");
        softAssert.assertAll();
    }



   @And("user write product name in search")
    public void writesearch() {
//       search.searchpro().sendKeys("laptop");
//       search.btnsearch().click();


       int size = driver.findElements(By.xpath("//h2[@class=\"product-title\"]//a[contains(text(),\"\")]")).size();
       System.out.println("The Size is = " + size);

       for (int i = 0; i < size; i++) {
           String text = driver.findElements(By.xpath("//h2[@class=\"product-title\"]//a[contains(text(),\"\")]")).get(i).getText();
           System.out.println(i);
           System.out.println(text);

           SoftAssert softAssert = new SoftAssert();
           softAssert.assertTrue(text.toLowerCase().contains("laptop"));
           softAssert.assertAll();
       }
   }

       @And("user search with SKU")
               public void sku(){
//           search.searchpro().sendKeys("AS_551_LP");
//           search.btnsearch().click();
//          search.clickproductafterresult().click();

          String skushown =Hocks.driver.findElement(By.xpath("//div[@class=\"sku\"]//span[contains(text(),'AS')]")).getText();
           System.out.println("The SKU Shown is " +skushown);

          SoftAssert softAssert = new SoftAssert();
          softAssert.assertTrue(skushown.contains("AS_551_LP"));
          softAssert.assertAll();


       }


   }

