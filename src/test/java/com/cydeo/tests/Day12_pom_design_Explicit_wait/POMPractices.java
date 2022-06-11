package com.cydeo.tests.Day12_pom_design_Explicit_wait;

import com.cydeo.utilities.Driver;
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
        //5- Verify expected error is displayed:
        //Expected: This field is required.
        //NOTE: FOLLOW POM DESIGN PATTERN
    }
}
