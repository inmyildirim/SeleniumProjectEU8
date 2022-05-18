package com.cydeo.tests.Day3_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T4_cssSelector_getText {
    public static void main(String[] args) {

        //TC #4: NextBaseCRM, locators, getText(), getAttribute() practice
        //1- Open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes
        driver.navigate().to("https://login1.nextbasecrm.com/?forgot_password=yes");

        //3- Verify “Reset password” button text is as expected:
        //Expected: Reset password

        //Using class attribute and its value
        //WebElement resetButton = driver.findElement(By.cssSelector("button[class='login-btn']"));

        //Using value attribute and its value
        WebElement resetButton = driver.findElement(By.cssSelector("button[value='Reset password']"));

        String expectedResetButton = "Reset password";
        String actualResetButton = resetButton.getAttribute("value");

        if (actualResetButton.equals(expectedResetButton)){
            System.out.println("Reset button verification PASSED!");
        }else {
            System.out.println("Reset button verification FAILED!");
        }

        driver.close();

    }
}
