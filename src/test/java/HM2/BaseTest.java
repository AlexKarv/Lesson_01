package HM2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public WebDriver driver;
    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }


    @AfterClass
    public void afterClass() {
        if (driver != null)
            driver.quit();
    }




}
