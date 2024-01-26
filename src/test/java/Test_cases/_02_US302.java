package Test_cases;

import Utilities.DriverClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _02_US302 extends DriverClass {

    /**
     * 1. I should successfully access the e-junkie demo site.
     * 2. Find the "Add Demo E-Book to Cart" button and click.
     * 3. Verify that the demo e-book is successfully added to the basket.
     * 4. Find the "Pay Using Debit Card" option and click on the basket page.
     * 5. There should be areas where email, name and debt card information (card number, expiration date, CVC) can be entered on the payment page.
     * 6. Leave the e-mail address and other fields blank on the payment page.
     * 7. Click the "Pay" button to complete the payment process.
     * 8. Verify that during the payment process, "Invalid email" and "Invalid Billing Name" errors are displayed at the same time.
     **/
    @Test
    void payWithDebitCard() throws InterruptedException {

        driver.get("https://shopdemo.e-junkie.com/");
        String expectedUrl = "https://shopdemo.e-junkie.com/";

        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);

        driver.findElement(By.cssSelector("button[onclick=\"return EJProductClick('1595015')\"]")).click();



        driver.switchTo().frame(driver.findElement(By.cssSelector("iFrame[class=\"EJIframeV3 EJOverlayV3\"]")));

        Assert.assertTrue(driver.findElement(By.cssSelector("div[class=\"Col2 Product-Desc\"]")).getText().contains("Demo eBook"));

        driver.findElement(By.cssSelector("button[class=\"Payment-Button CC\"]")).click();
        driver.findElement(By.cssSelector("button[class=\"Pay-Button\"]")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector("div[id=\"SnackBar\"]>span")).getText().contains("Invalid Email"));
        Assert.assertTrue(driver.findElement(By.cssSelector("div[id=\"SnackBar\"]>span")).getText().contains("Invalid Billing Name"));

    }
}
