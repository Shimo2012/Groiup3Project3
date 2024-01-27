package Test_cases;

import Utilities.DriverClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _04_US304 extends DriverClass {

    @Test
    void paymentTest(){

        actions.click(driver.findElement(By.cssSelector("button[onclick=\"return EJProductClick('1595015')\"]"))).perform();
        driver.switchTo().frame(driver.findElement(By.cssSelector("iFrame[class=\"EJIframeV3 EJOverlayV3\"]")));
        actions.click(driver.findElement(By.cssSelector("button[class=\"Payment-Button CC\"]"))).perform();
       // driver.switchTo().frame(driver.findElement(By.cssSelector("iFrame[name=\"__privateStripeMetricsController2670\"]")));
        actions.click(driver.findElement(By.cssSelector("input[placeholder=\"Email\"]"))).sendKeys("leen2020@gmail.com").perform();
        actions.click(driver.findElement(By.cssSelector("input[placeholder=\"Confirm Email\"]"))).sendKeys("leen2020@gmail.com").perform();
        actions.click(driver.findElement(By.cssSelector("input[placeholder=\"Name On Card\"]"))).sendKeys("Leen Adam").perform();
        actions.click(driver.findElement(By.cssSelector("input[placeholder=\"Card number\"]"))).sendKeys("4242 4242 4242 4242", "12 / 24", "000").perform();
        actions.click(driver.findElement(By.cssSelector("button[class=\"Pay-Button\"]"))).perform();


        String  orderConfirmed = driver.findElement(By.cssSelector("div[class=\"green_bar\"]")).getText();
        Assert.assertEquals("Leen, your order is confirmed", orderConfirmed);



    }

}
