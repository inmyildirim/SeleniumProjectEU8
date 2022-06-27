package com.cydeo.tests.Day13_review_and_practices;

import com.cydeo.pages.DynamicControlPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExplicitWaitPractices {

    @BeforeMethod
    public void setupMethod(){
        //TC #2: Explicit wait practice
        //1- Open a chrome browser
        //2- Go to: https://practice.cydeo.com/dynamic_controls
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_controls");
    }

    @Test
    public void remove_button_test(){

        //3- Click to a“Remove” button
        DynamicControlPage dynamicControlPage = new DynamicControlPage();
        dynamicControlPage.removeButton.click();

        //4- Wait until “loading bar disappears”
//        Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
//        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
//        wait.until(ExpectedConditions.invisibilityOf(dynamicControlPage.loadingBar));

        // We created new utility for explicit wait as u see below
        BrowserUtils.waitForInvisibilityOf(dynamicControlPage.loadingBar);

        //5- Verify:
        try{
            //a. Checkbox is not displayed
            Assert.assertTrue(!dynamicControlPage.checkBox.isDisplayed());
            Assert.assertFalse(dynamicControlPage.checkBox.isDisplayed());
        }catch (NoSuchElementException e){
            Assert.assertTrue(true);
        }

        //b. “It’s gone!” message is displayed.
        Assert.assertTrue(dynamicControlPage.message.isDisplayed());
        Assert.assertTrue(dynamicControlPage.message.getText().equals("It's gone!"));

        Driver.closeDriver();

        //NOTE: FOLLOW POM


    }

    @Test
    public void enable_button_test(){
        //TC #3: Explicit wait practice

        //3- Click to “Enable” button
        DynamicControlPage dynamicControlPage = new DynamicControlPage();

        dynamicControlPage.enableButton.click();

        System.out.println("dynamicControlPage.inputBox.isEnabled() = "
                + dynamicControlPage.inputBox.isEnabled());

        //4- Wait until “loading bar disappears”
        BrowserUtils.waitForInvisibilityOf(dynamicControlPage.loadingBar);

        System.out.println("dynamicControlPage.inputBox.isEnabled() = "
                + dynamicControlPage.inputBox.isEnabled());

        //5- Verify:
        //a. Input box is enabled.
        Assert.assertTrue(dynamicControlPage.inputBox.isEnabled());

        //b. “It’s enabled!” message is displayed.
        Assert.assertTrue(dynamicControlPage.message.getText().equals("It's enabled!"));
        //NOTE: FOLLOW POM
    }

}
