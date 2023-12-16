package org.example.stepDefiniation;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Random;

import static org.example.stepDefiniation.Hocks.driver;

public class TC03_HomePage {
    WebDriver driver;
    SoftAssert softAssert = new SoftAssert();
    P03_homePage homePage = new P03_homePage();
    @When("User click any button at header go to page")
    public void HeaderBtn(){

      String text=  homePage.HeaderBtn.getAttribute("class");
        System.out.println(text);
        softAssert.assertTrue(homePage.HeaderBtn.isDisplayed());

        List<WebElement> HeaderLinks =Hocks.driver.findElements(By.cssSelector(".header-links li"));
        int MaxBtnLinks = HeaderLinks.size();
        System.out.println("The Button Size ="+MaxBtnLinks);


        for (int i = 0; i < HeaderLinks.size(); i++) {
            String ButtonHeaderLink = HeaderLinks.get(i).getText();
            System.out.println("The Button is = "+ButtonHeaderLink);
    }
        Random random = new Random();
        int RandomButton = random.nextInt(MaxBtnLinks);
        HeaderLinks.get(RandomButton).click();
        String Url = Hocks.driver.getCurrentUrl();
        System.out.println("URL = " +Url);
        Hocks.driver.navigate().back();
        softAssert.assertAll();
}

  @Given("User must see logo page and field search")
    public void LogoAndSearch(){
        softAssert.assertTrue(homePage.LogoAndSearch.isDisplayed());
        softAssert.assertAll();
  }

  @Given("User must see menu of products")
    public void HeaderMenu(){
        softAssert.assertTrue(homePage.MenuProducts.isDisplayed());
        softAssert.assertAll();

      List<WebElement> HeaderMenuProducts =Hocks.driver.findElements(By.cssSelector("ul[class=\"top-menu notmobile\"]"));
//      int MaxBtnProducts = HeaderMenuProducts.size();
//      System.out.println("The Button Size ="+MaxBtnProducts);


      for (int i = 0; i < HeaderMenuProducts.size(); i++) {
          String ButtonHeaderMenuProducts = HeaderMenuProducts.get(i).getText();
          System.out.println(ButtonHeaderMenuProducts );
          int count = HeaderMenuProducts.size();
          System.out.println(count);
      }
//      Random random = new Random();
//      int RandomButton = random.nextInt(MaxBtnProducts);
//      HeaderMenuProducts.get(RandomButton).click();
//      String Url = Hocks.driver.getCurrentUrl();
//      System.out.println("URL = " +Url);
//      Hocks.driver.navigate().back();
      softAssert.assertAll();
  }
}
