import org.openqa.selenium.By;
import org.testng.annotations.Test;
import parent.BaseTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FirstTest extends BaseTest {

    @Test
    public void zipCode4DigitsCheck() {
        browser.get("https://sharelane.com/cgi-bin/register.py");
        browser.findElement(By.xpath("//*[@name='zip_code']")).sendKeys("1234");
        browser.findElement(By.xpath("//*[@value='Continue']")).click();
        assertEquals(browser.findElement(By.cssSelector(".error_message")).getText(),
                "Oops, error on page. ZIP code should have 5 digits");
    }

    @Test
    public void zipCode5DigitsCheck() {
        browser.get("https://sharelane.com/cgi-bin/register.py");
        browser.findElement(By.xpath("//*[@name='zip_code']")).sendKeys("12345");
        browser.findElement(By.xpath("//*[@value='Continue']")).click();
        boolean regBtnIsPresent = browser.findElement(By.xpath("//input[@value='Register']")).isDisplayed();
        assertTrue(regBtnIsPresent);
    }
}