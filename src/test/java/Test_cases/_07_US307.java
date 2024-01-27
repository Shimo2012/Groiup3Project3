package Test_cases;

import Utilities.DriverClass;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _07_US307 extends DriverClass {
    //As a customer, I would like to access the e-junkie homepage from Shopdemo.e-Junkie.com  page.
    // So I can quickly learn about this e-commerce site.

    @Test
    void homepage(){
        driver.get("https://shopdemo.e-junkie.com/");

        actions.click(driver.findElement(By.className("EJ-ShopLink"))).perform();

        Assert.assertEquals(driver.getCurrentUrl(),"https://www.e-junkie.com/","URL");
    }
}
