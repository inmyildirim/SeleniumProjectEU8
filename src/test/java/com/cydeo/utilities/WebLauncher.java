package com.cydeo.utilities;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class WebLauncher {

    public static String webSiteLauncher(String link){

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get(link);

        return link;



    }
}
