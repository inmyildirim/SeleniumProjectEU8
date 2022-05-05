package com.cydeo.tests.Day3_cssSelector_xpath;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T3_getAttribute_cssSelector {
    public static void main(String[] args) {
        //TC #3: NextBaseCRM, locators, getText(), getAttribute() practice
        //1- Open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2- Go to: https://login1.nextbasecrm.com/
        driver.navigate().to("https://login1.nextbasecrm.com/");

        //3- Verify “Log in” button text is as expected:
        //Expected: Log In
                                                               // tagName[attribute='value']
                                                               //   input[class='login-btn']
        // LOCATED USING "CLASS ATTRIBUTE"
        //WebElement logInButton = driver.findElement(By.cssSelector("input[class='login-btn']"));
        // LOCATED USING "TYPE ATTRIBUTE"
        //WebElement logInButton = driver.findElement(By.cssSelector("input[type='submit']"));
        // LOCATED USING "VALUE ATTRIBUTE"
        WebElement logInButton = driver.findElement(By.cssSelector("input[value='Log In']"));

        System.out.println(logInButton.getText());
        String expectedLogInButton = "Log In";
        String actualLogInButton = logInButton.getAttribute("value");

        if (actualLogInButton.equals(expectedLogInButton)){
            System.out.println("Log In Text verification PASSED!");
        }else{
            System.out.println("Log In Text verification FAILED!");
        }

        driver.close();


    }
}
