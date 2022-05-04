package com.cydeo.tests.Day3_cssSelector_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_locators_getText {
    public static void main(String[] args) throws InterruptedException {
        //TC #1: NextBaseCRM, locators and getText() practice
        //1- Open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2- Go to: https://login1.nextbasecrm.com/
        driver.navigate().to("https://login1.nextbasecrm.com/");

        //3- Enter incorrect username: “incorrect”
        WebElement usernameInput = driver.findElement(By.name("USER_LOGIN"));
        usernameInput.sendKeys("incorrect");

        //4- Enter incorrect password: “incorrect”
        WebElement passwordInput = driver.findElement(By.name("USER_PASSWORD"));
        passwordInput.sendKeys("incorrect"+ Keys.ENTER);


        //5- Click to login button
        WebElement logInButton = driver.findElement(By.className("login-btn"));
        logInButton.click();

        //6- Verify error message text is as expected:
        WebElement errorMessage = driver.findElement(By.className("errortext"));

        //Expected: Incorrect login or password
        String actualMessage = errorMessage.getText();
        String expectedMessage = "Incorrect login or password";

        if (actualMessage.equals(expectedMessage)){
            System.out.println("Error message verification PASSED!");
        }else{
            System.out.println("Error message verification PASSED!");
        }

        driver.close();



    }
}
