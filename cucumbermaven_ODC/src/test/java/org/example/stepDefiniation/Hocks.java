package org.example.stepDefiniation;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.commons.exec.CommandLine;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Hocks {

   public static WebDriver driver;

    @Before
    public void openBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demo.nopcommerce.com/");
    }

    @After
    public void quit() throws InterruptedException {
        Thread.sleep(3000);
       driver.quit();
    }
}
