package com.cydeo.tests.Day4_findElements_checkBoxes_radio;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class T4_findElements {
    public static void main(String[] args) {

        //TC #4: FindElements Task
        //1- Open a chrome browser

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        // providing extra wait time for our driver before it throws NoSuchElement
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2- Go to: https://practice.cydeo.com/abtest
        driver.get("https://practice.cydeo.com/abtest");

        //3- Locate all the links in the page.
        //windows : alt+enter
        //max: option + enter
        List<WebElement> allList = driver.findElements(By.tagName("a"));

        //4- Print out the number of the links on the page.
        System.out.println("allList.size() = " + allList.size());

        //5- Print out the texts of the links.
        //6- Print out the HREF attribute values of the links

        for (WebElement each : allList) {
            System.out.println("Text of link: "+each.getText());
            System.out.println("href Value: "+each.getAttribute("href"));
        }



















    }
}

