package HM5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseTest {
    private static WebDriver driver;
    public static void logOut () {
        WebElement buttonSendwich = driver.findElement(By.xpath("//button[normalize-space()='Open Menu']"));
        buttonSendwich.click();
        WebElement buttonLogOut = driver.findElement(By.xpath("//a[@id='logout_sidebar_link']"));
        buttonLogOut.click();
    }
}
