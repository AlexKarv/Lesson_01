package lesson_7;

import org.example.uitests.browser.WebDriwerHolder;
import org.example.uitests.utils.ConfigProvider;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected WebDriver driver;


    @BeforeClass
    public void beforeClass() {
        driver = WebDriwerHolder.getInstance().getDriver();
        driver.manage().window().maximize();
        System.out.println("before class");
    }

    public void goToUrl(String url) {
        WebDriwerHolder.getInstance().getDriver().get(url);

    }

    public void goToUrl() {
        goToUrl(ConfigProvider.getInstance().getProperty("app.base.url"));

    }

    public void goToPart(String part) {
        goToUrl(ConfigProvider.getInstance().getProperty("app.base.url") + part);
    }


    @AfterClass
    public void afterClass() {
        WebDriwerHolder.getInstance().driverQuite();
        System.out.println("after class");
    }


}
