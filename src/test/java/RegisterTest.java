import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import parent.BaseTest;
import java.util.List;
import static org.testng.Assert.assertEquals;

public class RegisterTest extends BaseTest {
    @Test
    public void zipCode4DigitsCheck() {
        browser.get("https://the-internet.herokuapp.com/add_remove_elements/");
        browser.findElement(By.xpath("//*[text()='Add Element']")).click();
        browser.findElement(By.xpath("//*[text()='Add Element']")).click();
        browser.findElement(By.xpath("//*[text()='Delete']")).click();
        List<WebElement> list = browser.findElements(By.xpath("//*[text()='Delete']"));
        assertEquals(list.size(), 1);
    }

    @Test
    public void dropDownCheck() {
        browser.get("https://the-internet.herokuapp.com/dropdown");
        WebElement dropdown = browser.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
        select.selectByIndex(1);
        assertEquals(select.getFirstSelectedOption().getText(), "Option 1");
    }
}
