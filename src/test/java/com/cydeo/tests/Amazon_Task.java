package com.cydeo.tests;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Amazon_Task {

    public WebDriver driver;
    @BeforeMethod
    public void startBrowser() throws InterruptedException {
        //1-Open the browser
        String browserType = ConfigurationReader.getProperty("browser");
        driver = WebDriverFactory.getDriver(browserType);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2-Navigate to https://www.amazon.com/
        String navigate = ConfigurationReader.getProperty("webpage");
        driver.navigate().to(navigate);

        Thread.sleep(1000);

    }

    @Test (priority = 1)
    public void countOfDropDownElements() throws InterruptedException {
        //3-Write "selenium" in the search box
        String searchTerm = ConfigurationReader.getProperty("material");
        WebElement inputBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        inputBox.click();
        Thread.sleep(1000);
        inputBox.sendKeys(searchTerm);
        Thread.sleep(1000);

        // List the dropdown elements
        List<WebElement> listOfDropDown = driver.findElements(By.xpath("//div[@class='s-suggestion-container']"));
        Thread.sleep(1000);

        //4-Verify that you see 10 suggestions as dropdown
        int expectedCount = 11;
        Assert.assertEquals(listOfDropDown.size(),expectedCount);

        //5-Verify that all 10 suggesstions contain your search term
        List<WebElement> listOfDropDown2 = driver.findElements(By.xpath("//div[@class='s-suggestion-container']"));
        Thread.sleep(1000);

        for (WebElement eachElement : listOfDropDown2) {
            System.out.println(eachElement.getText()); // isimleri yazdırıyormu diye baktım.
            Assert.assertTrue(eachElement.getText().contains("selenium"));    //ConfigurationReader.getProperty("material")

        }

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}

//Here follow the steps:
//1-Open the browser
//2-Navigate to https://www.amazon.com/
//3-Write "selenium" in the search box
//4-Verify that you see 10 suggesstions as dropdown
//5-Verify that all 10 suggesstions contain your search term
//Optional:
//6-Verify the same steps with the search term "java" (here you need to make your code dynamic)
//Optional 2:
//Follow the same steps for each of the browser types with same steps. Here, you will make your code more dynamic.
//You will do the same test for each of the browser types but you will use the same code only.