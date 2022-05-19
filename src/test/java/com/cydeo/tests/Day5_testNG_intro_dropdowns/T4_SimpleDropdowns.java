package com.cydeo.tests.Day5_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T4_SimpleDropdowns {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        //1. Open Chrome browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2. Go to https://practice.cydeo.com/dropdown
        driver.get("https://practice.cydeo.com/dropdown");
    }

    @Test
    public void SimpleDropdownTest(){
        //TC#4: Verifying “Simple dropdown” and “State selection” dropdown
        //default values

        //3. Verify “Simple dropdown” default selected value is correct
        //Expected: “Please select an option”
        Select simpleDropdown = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));

        WebElement currentlySelectedOption = simpleDropdown.getFirstSelectedOption();

        String actualSimpleDropdown = currentlySelectedOption.getText();
        String expectedSimpleDropdown = "Please select an option";


        //4. Verify “State selection” default selected value is correct
        Select stateDropdown = new Select(driver.findElement(By.xpath("//select[@id='state']")));

        //Expected: “Select a State”
        //WebElement currentlyStateSelection = stateDropdown.getFirstSelectedOption();    (IT IS NOT ONLY WAY)

        String actualStateDropdown = stateDropdown.getFirstSelectedOption().getText();      // WE CAN DO IT AT THE SAME LINE
        String expectedStateDropdown = "Select a State";

        Assert.assertEquals(actualStateDropdown,expectedStateDropdown);                                 // 1,
        // Assert.assertEquals(stateDropdown.getFirstSelectedOption().getText(),"Select a State");      // 2,





    }




}
