package com.cydeo.tests.Day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1_YahooTitleVerification {
    public static void main(String[] args) {

        // TC #1: Yahoo Title Verification

        // do setup for browser driver
        WebDriverManager.chromedriver().setup();

        // 1. Open Chrome browser
        WebDriver driver = new ChromeDriver();

        //Make your browser maximize
        driver.manage().window().maximize();

        // 2. Go to https://www.yahoo.com
        driver.get("https://www.yahoo.com");

        // 3. Verify title:
        // Expected: Yahoo | Mail, Weather, Search, Politics, News, Finance, Sports & Videos
        String expectedTitle = "Yahoo | Mail, Weather, Search, Politics, News, Finance, Sports & Videos";
        String actualTitle = driver.getTitle();

        if(expectedTitle.equals(actualTitle)){
            System.out.println("Title is as expected. Verification PASSED!");
        }else {
            System.out.println("Title is NOT as expected. Verification FAİLED!");
        }
        // for quit
        driver.quit();


    }
}
