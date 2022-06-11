package com.cydeo.tests.Day11_actions_jsexecutor_pratice;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_Circle_Drag_N_Drop {
    @Test
    public void drag_and_drop(){
        //TC #: Drag and drop
        //1. Go to https://demos.telerik.com/kendo-ui/dragdrop/index
        Driver.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        //Locate "Accept Cookies" button and click it.
        WebElement acceptCookiesButton = Driver.getDriver().findElement(By.id("onetrust-accept-btn-handler"));
        acceptCookiesButton.click();

        //2. Drag and drop the small circle to bigger circle.
       WebElement dragObject = Driver.getDriver().findElement(By.id("draggable"));
       WebElement dropTarget = Driver.getDriver().findElement(By.id("droptarget"));

        Actions actions = new Actions(Driver.getDriver());
        //actions.dragAndDrop(dragObject,dropTarget).perform(); //first way
        actions.clickAndHold(dragObject)
                .pause(2000)
                .moveToElement(dropTarget)
                .pause(2000)
                .release().perform();


        //3. Assert:
        //-Text in big circle changed to: “You did great!”

        String actualDrogTargetText = dropTarget.getText();
        String expectedText = "You did great!";

        Assert.assertEquals(actualDrogTargetText,expectedText);

    }

}
