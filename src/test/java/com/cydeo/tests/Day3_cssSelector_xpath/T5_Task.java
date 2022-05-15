package com.cydeo.tests.Day3_cssSelector_xpath;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T5_Task {
    public static void main(String[] args) {
        //TC #5: NextBaseCRM, locators, getText(), getAttribute() practice
        //1- Open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes
        driver.navigate().to("https://login1.nextbasecrm.com/?forgot_password=yes");

        //3- Enter incorrect username into login box:
        WebElement inputBoxLogIn = driver.findElement(By.name("USER_LOGIN"));
        inputBoxLogIn.sendKeys("Serhat");

        //4- Click to `Reset password` button
        WebElement resetButton = driver.findElement(By.cssSelector("button[value='Reset password']"));
        resetButton.click();

        //5- Verify “error” label is as expected

        WebElement errorLabel = driver.findElement(By.className("errortext"));
        String actualErrorLabel = errorLabel.getText();
        String expectedErrorLabel = "Login or E-mail not found";

        if (actualErrorLabel.equals(expectedErrorLabel)){
            System.out.println("Error label verification PASSED!");
        }else{
            System.out.println("Error label verification FAILED!");
        }

        driver.close();

        //Expected: Login or E-mail not found
    }
}
