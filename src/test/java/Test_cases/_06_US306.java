package Test_cases;

import Utilities.DriverClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _06_US306 extends DriverClass {


    @Test
    void contactUsTest(){

        actions.click(driver.findElement(By.cssSelector("a[class=\"contact\"]"))).perform();
        actions.click(driver.findElement(By.cssSelector("input[id=\"sender_name\"]"))).sendKeys("John Smith").perform();
        actions.click(driver.findElement(By.cssSelector("input[id=\"sender_email\"]"))).sendKeys("johnsmith2020@gmail.com").perform();
        actions.click(driver.findElement(By.cssSelector("input[id=\"sender_subject\"]"))).sendKeys("E_junkie Book").perform();
        actions.click(driver.findElement(By.cssSelector("textarea[name=\"sender_message\"]"))).sendKeys(" Nice product").perform();
     //   actions.click(driver.findElement(By.cssSelector("div[role=\"presentation\"]"))).perform();
        actions.click(driver.findElement(By.cssSelector("button[id=\"send_message_button\"]"))).perform();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();

        // Get the text from the alert
        String alertMessage = alert.getText();

        // Assert that the alert message is as expected
        Assert.assertEquals(alertMessage, "Recaptcha didn't match");

        // Accept the alert (close it)
        alert.accept();


    }
}
