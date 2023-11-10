package HM2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Alert extends BaseTest {
    @Test
    public void Click_For_JS_ConfirmWithOK() throws InterruptedException {
        WebElement Button_Click_For_JS_Confirm = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        Button_Click_For_JS_Confirm.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        org.openqa.selenium.Alert alert = driver.switchTo().alert();
        alert.accept();
        Assert.assertEquals(driver.findElement(By.xpath("//p[@id='result']")).getText(), "You clicked: Ok");
    }
    @Test
    public void Click_For_JS_ConfirmWithCancel() throws InterruptedException {
        WebElement Button_Click_For_JS_Confirm = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        Button_Click_For_JS_Confirm.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        org.openqa.selenium.Alert alert = driver.switchTo().alert();
        alert.dismiss();
        Assert.assertEquals(driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).getText(), "Click for JS Confirm");
    }
    @Test
    public void Click_For_JS_PromtWithEnterName() throws InterruptedException {
        WebElement Button_Click_For_JS_Promt = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        Button_Click_For_JS_Promt.click();
        org.openqa.selenium.Alert alert = driver.switchTo().alert();
        alert.sendKeys("Alex");
        alert.accept();
        Assert.assertEquals(driver.findElement(By.xpath("//p[@id='result']")).getText(), "You entered: Alex");
    }
    @Test
    public void Click_For_JS_PromtWithEnterNameCancel() throws InterruptedException {
        WebElement Button_Click_For_JS_Promt = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        Button_Click_For_JS_Promt.click();
        org.openqa.selenium.Alert alert = driver.switchTo().alert();
        alert.sendKeys("Alex");
        alert.dismiss();
        Assert.assertEquals(driver.findElement(By.xpath("//p[@id='result']")).getText(), "You entered: null");
    }
}
