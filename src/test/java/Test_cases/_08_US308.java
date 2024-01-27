package Test_cases;

import Utilities.DriverClass;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.InputEvent;

public class _08_US308 extends DriverClass {

    @Test
    void watchVideo() throws InterruptedException, AWTException {
        driver.get("https://www.e-junkie.com/");
        driver.findElement(By.cssSelector("a[class=\"blue_btn\"]")).click();
        Thread.sleep(3000);
        driver.switchTo().frame(driver.findElement(By.cssSelector("iFrame[src=\"https://www.youtube.com/embed/kODFTdj9Ifc\"]")));

        Robot robot = new Robot();
        robot.mouseMove(950, 600);


        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(1000);

        robot.mouseMove(500, 500);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(10000);

        robot.mouseMove(500, 500);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        driver.quit();



    }
}
