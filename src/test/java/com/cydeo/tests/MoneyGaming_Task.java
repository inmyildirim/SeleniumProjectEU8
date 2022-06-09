package com.cydeo.tests;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MoneyGaming_Task {
    public WebDriver driver;
    @BeforeMethod
    public void startBrowser() throws InterruptedException {
        //1-Open the browser
        String browserType = ConfigurationReader.getProperty("browser");
        driver = WebDriverFactory.getDriver(browserType);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2-Navigate to https://moneygaming.qa.gameaccount.com/
        String navigate = ConfigurationReader.getProperty("webpage");
        driver.navigate().to(navigate);

        Thread.sleep(1000);

    }
    @Test
    public void test(){
        WebElement element = driver.findElement(By.xpath("//a[@class='newUser green']"));
        element.click();

        WebElement selectedTitle = driver.findElement(By.xpath("//div/form/fieldset//select[@name = 'map(title)']//option[@value='Miss']"));
        selectedTitle.click();

        WebElement name = driver.findElement(By.xpath("//div/form/fieldset//input[@name= 'map(firstName)']"));
        name.sendKeys("Mehmet");

        WebElement surname = driver.findElement(By.xpath("//div/form/fieldset//input[@name= 'map(lastName)']"));
        surname.sendKeys("Yıldırım");

        WebElement checkBox = driver.findElement(By.xpath("//div/form/fieldset/input[@class='required checkbox terms']"));
        checkBox.click();

        WebElement joinButton = driver.findElement(By.xpath("//div/form/fieldset/input[@class='promoReg green']"));
        joinButton.click();

        WebElement validationBelowBirth = driver.findElement(By.xpath("//div/form/fieldset//label[@for='dob']"));
        validationBelowBirth.isDisplayed();


    }

}

/*
Task 2:
1. Navigate to: https://moneygaming.qa.gameaccount.com/
2. Click the JOIN NOW button to open the registration page
3. Select a title value from the dropdown
4. Enter your first name and surname in the form

5. Check the tick box with text 'I accept the Terms and Conditions and certify that I am over
the age of 18.'

6. Submit the form by clicking the JOIN NOW button

7. Validate that a validation message with text ‘ This field is required’ appears under the date of
birth box

 */
