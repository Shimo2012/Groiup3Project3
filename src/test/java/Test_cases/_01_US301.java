package Test_cases;

import Utilities.DriverClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class _01_US301 extends DriverClass {

    @Test
    void addingEbookToBasket() {

        String targetURL = ("https://shopdemo.e-junkie.com/");
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, targetURL, "URL is not correct");

        actions.click(driver.findElement(By.cssSelector("button[onclick=\"return EJProductClick('1595015')\"]"))).perform();

        driver.switchTo().frame(driver.findElement(By.cssSelector("iFrame[class=\"EJIframeV3 EJOverlayV3\"]")));

        Assert.assertTrue(driver.findElement(By.cssSelector("div[class=\"Product-Image\"]")).isDisplayed());

        actions.click(driver.findElement(By.xpath("//button[text()=\"Add Promo Code\"]"))).perform();

        actions.click(driver.findElement(By.cssSelector("input[class=\"Promo-Code-Value\"]"))).sendKeys("0000").perform();

        actions.click(driver.findElement(By.cssSelector("button[class=\"Promo-Apply\"]"))).perform();

       wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class=\"Overlay\"]")));

      //  WebElement inValidPromoCode = driver.findElement(By.cssSelector("div[class=\"Overlay\"]"));

     //  Assert.assertEquals(inValidPromoCode.getText(), "Invalid promo code.");

      //  System.out.println("Test Passed: Invalid Promo code Message is displayed");


    }

}
