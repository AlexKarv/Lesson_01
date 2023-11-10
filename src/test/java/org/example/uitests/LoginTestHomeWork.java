package org.example.uitests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTestHomeWork {
    private WebDriver driver;
    private static final String USER_NAME = "performance_glitch_user";
    private static final String USER_PASS = "secret_sauce";
    private static final String USER_PASS_NEG = "secret_sauc";

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get("https://www.saucedemo.com/v1/index.html");
    }

    @Test
    public void loginTestWithXpathPositive() {
        WebElement userNameField = driver.findElement(By.id("user-name"));
        userNameField.clear();
        userNameField.sendKeys(USER_NAME);
        WebElement userPasswordField = driver.findElement(By.id("password"));
        userPasswordField.clear();
        userPasswordField.sendKeys(USER_PASS);
        WebElement buttonLoggin = driver.findElement(By.xpath("//input[@id='login-button']"));
        buttonLoggin.click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='header_secondary_container']")).getText().contains("Prod"));
    }
    @Test
    public void loginTestWithXpathNegarive() {
        WebElement userNameField = driver.findElement(By.id("user-name"));
        userNameField.clear();
        userNameField.sendKeys(USER_NAME);
        WebElement userPasswordField = driver.findElement(By.id("password"));
        userPasswordField.clear();
        userPasswordField.sendKeys(USER_PASS_NEG);
        WebElement buttonLoggin = driver.findElement(By.xpath("//input[@id='login-button']"));
        buttonLoggin.click();
        Assert.assertTrue(driver.findElement(By.xpath("//h3[@data-test='error']")).getText().contains("servic"));
    }
    @AfterClass
    public void afterClass() {
        if (driver != null)
            driver.quit();
    }
}
