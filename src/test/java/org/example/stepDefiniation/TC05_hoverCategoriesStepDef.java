package org.example.stepDefiniation;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.example.pages.P04_hoverCategories;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.example.stepDefiniation.Hocks.driver;

public class TC05_hoverCategoriesStepDef {

//    P03_homePage hover = new P03_homePage();
//
//    @Given("user hover on the selected category and select one of the sub categories")
//    public void userHover() {
//
//        Actions actions=new Actions(driver);
//        List<WebElement> mainLinks = driver.findElements(By.cssSelector("ul[class=\"top-menu notmobile\"]"));
//
//        int count = mainLinks.size();
//        System.out.println("count is "+count);
//        int min = 0;
//        int max = count - 1;
//        int selectedCategory = (int)Math.floor(Math.random()*(max-min+1)+min);
//        actions.moveToElement(mainLinks.get(selectedCategory)).perform();
//        String selectedCategoryText = mainLinks.get(selectedCategory).getText();
//        System.out.println("to know which category is selected:   " +selectedCategoryText);
//
//
//        selectedCategory = selectedCategory+1;
//        String locator = "(ul[class=\"top-menu notmobile\"])["+selectedCategory+"]/li";
//        List<WebElement> subCategoryLinks = driver.findElements(By.xpath(locator));
//
//
//
//        String selectedSubCategoryText;
//        if(!subCategoryLinks.isEmpty()) {
//            int subCategoryCount = subCategoryLinks.size();
//            System.out.println("profile links " + subCategoryCount);
//            System.out.println(subCategoryLinks.get(0).getText());
//            System.out.println(subCategoryLinks.get(1).getText());
//            System.out.println(subCategoryLinks.get(2).getText());
//            int selectedSubCategory = (int) Math.floor(Math.random() * (max - min + 1) + min);
//            selectedSubCategoryText = subCategoryLinks.get(selectedSubCategory).getText();
//            System.out.println("The SelectedSubCategoryText Is : " +selectedSubCategoryText);
//            subCategoryLinks.get(selectedSubCategory).click();
//
//            String PageTitle= driver.findElement(By.xpath("//div[@class=\"page-title\"]//h1[contains(text(),\"\")]")).getText();
//            System.out.println("The Tile Page Is : " +PageTitle);
//
//
//
//
//            SoftAssert softAssert = new SoftAssert();
//            softAssert.assertFalse(PageTitle.toLowerCase().trim().equals(selectedSubCategoryText));
//            softAssert.assertAll();
//
//
//        }
//        else
//        {
//            mainLinks.get(selectedCategory).click();
//
//        }
//
//}


    P04_hoverCategories hovering = new P04_hoverCategories();
    @When("user hover on Apparel option and select clothes category")
    public void hover_on_Apparel_option() throws InterruptedException {
        //finding element
        hovering.apparel();
        //Instantiating Actions class
        Actions action = new Actions(Hocks.driver);
        //Hovering on apparel option
        action.moveToElement(hovering.apparel());
        Thread.sleep(4000);

        // Locating the element from Sub Menu
        hovering.sub_option_clothes();
        //To mouseover on sub menu
        action.moveToElement(hovering.sub_option_clothes());
        //build()- used to compile all the actions into a single step
        action.click().build().perform();
    }

    @Then("user move successfully to the clothes page")
    public void user_move_successfully()
    {
        String url = "https://demo.nopcommerce.com/clothing";
        Assert.assertEquals(Hocks.driver.getCurrentUrl(),url);
    }



}

