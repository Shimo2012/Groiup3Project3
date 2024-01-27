package Test_cases;

import Utilities.DriverClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

public class _08_US308 extends DriverClass {

    //As a customer, I want to access a video that I can learn from the e-junkie homepage. So I can quickly learn about this e-commerce site.
    @Test
    public void test8() throws AWTException {

        driver.get("https://shopdemo.e-junkie.com/");

        actions.click(driver.findElement(By.className("EJ-ShopLink"))).perform();
        WebElement seeHowItWorksBtn = driver.findElement(By.cssSelector("div[class=\"banner_btn\"] a"));
        seeHowItWorksBtn.click();

        Robot robot = new Robot();

        for (int i = 0; i < 15; i++) {
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
        }


        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);


        quitDriver();
    }
}
