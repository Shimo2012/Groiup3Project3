package Test_cases;

import Utilities.DriverClass;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _03_US303 extends DriverClass {
    /**
     * AC03:
     * 1. Find the "Pay Using Debit Card" option and click on the basket page.
     * 2. On the payment page, there should be areas where email, name and debt card information (card number, expiration date, CVC) on the card.
     * 3. Fill in compulsory areas (email, confirm email, name on card etc.) on the payment page.
     * 4. Enter "1111 1111 1111 1111" with an invalid credit card number during the payment process.
     * 5. Click the "Pay" button to complete the payment process.
     * 6. Verify that the message "Your card number is invalid" is displayed.
     **/


    @Test
    void invalidCard() {

        driver.get("https://shopdemo.e-junkie.com/");
        driver.findElement(By.cssSelector("button[onclick=\"return EJProductClick('1595015')\"]")).click();
        driver.switchTo().frame(driver.findElement(By.cssSelector("iFrame[class=\"EJIframeV3 EJOverlayV3\"]")));
        driver.findElement(By.cssSelector("button[class=\"Payment-Button CC\"]")).click();
        driver.findElement(By.cssSelector("input[placeholder=\"Email\"]")).sendKeys("abc@test.com");
        driver.findElement(By.cssSelector("input[placeholder=\"Confirm Email\"]")).sendKeys("abc@test.com");
        driver.findElement(By.cssSelector("input[placeholder=\"Name On Card\"]")).sendKeys("John Doe");
        driver.switchTo().frame(driver.findElement(By.cssSelector("iFrame[title=\"Secure card payment input frame\"]")));
        driver.findElement(By.cssSelector("input[data-elements-stable-field-name=\"cardNumber\"]")).sendKeys("1111111111111111");
        driver.switchTo().parentFrame();
        driver.findElement(By.cssSelector("button[class=\"Pay-Button\"]")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("div[id=\"SnackBar\"]>span")).getText().contains("Your card number is invalid"));
    }
}