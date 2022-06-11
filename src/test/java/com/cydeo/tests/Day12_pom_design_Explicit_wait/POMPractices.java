package com.cydeo.tests.Day12_pom_design_Explicit_wait;

import com.cydeo.pages.LibraryLoginPage;
import com.cydeo.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class POMPractices {

    @Test
    public void required_field_error_message_text(){
        //TC #1: Required field error message test
        //1- Open a chrome browser
        //2- Go to: https://library1.cydeo.com
        Driver.getDriver().get("https://library1.cydeo.com");


        //3- Do not enter any information
        //4- Click to “Sign in” button
        LibraryLoginPage libraryLoginPage = new LibraryLoginPage();
        libraryLoginPage.signInButton.click();


        //5- Verify expected error is displayed:
        Assert.assertTrue(libraryLoginPage.fieldRequiredErrorMessage.isDisplayed());



        //Expected: This field is required.
        //NOTE: FOLLOW POM DESIGN PATTERN
    }
}
