package com.cydeo.tests.Day5_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestNG_Selenium {

    WebDriver driver; ///-----------------------

    @BeforeMethod
    public void setupMethod(){
        // Do browser driver setup
        // Open browser
        driver = WebDriverFactory.getDriver("chrome");

        // Maximize the page
        driver.manage().window().maximize();
        // Implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void selenium_test(){
        // we moved the "driver setup" into the BeforeMethod but driver in Test gave us error so we initilized it under class.
        // and we moved the maximize codes and implicit wait to BeforeMethod because BeforeMethod executes just before any Test execution.

        // Get "https://google.com"
        driver.get("https://google.com");

        // Assert: title is "Google"
                                                                   // If assert false message is displayed
        Assert.assertEquals(driver.getTitle(),"Googlee", "Title is not matching here");

        //  -----SECOND WAY ----
        // String expected = "Google";
        // String actual = driver.getTitle();
        // Assert.assertEquals(actual,expected, Title is not matching here);

    }
}
