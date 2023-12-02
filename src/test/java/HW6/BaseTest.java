package HW6;

import org.example.uitests.browser.WebDriwerHolder;
import org.example.uitests.utils.ConfigProvider;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    private static WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = WebDriwerHolder.getInstance().getDriver();
        driver.manage().window().maximize();

    }
    public void goToUrl(String url) {
        WebDriwerHolder.getInstance().getDriver().get(url);

    }

    public void goToUrl() {
        goToUrl(ConfigProvider.getInstance().getProperty("app1.base.url"));

    }

    public void goToPart(String part) {
        goToUrl(ConfigProvider.getInstance().getProperty("app1.base.url") + part);
    }


    @AfterClass
    public void afterClass() {
        WebDriwerHolder.getInstance().driverQuite();
        System.out.println("after class");
    }

//    @BeforeMethod
//    public void beforeMethod() {
//
//        driver.get("https://www.saucedemo.com/v1/index.html");
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        WebElement userNameField = driver.findElement(By.id("user-name"));
//        userNameField.clear();
//        userNameField.sendKeys(USER_NAME);
//        WebElement userPasswordField = driver.findElement(By.id("password"));
//        userPasswordField.clear();
//        userPasswordField.sendKeys(USER_PASS);
//        WebElement buttonLoggin = driver.findElement(By.xpath("//input[@id='login-button']"));
//        buttonLoggin.click();
//        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='header_secondary_container']")).
//                getText().contains("Prod"));
//    }





//    public static void logOut() {
//        WebElement buttonSendwich = driver.findElement(By.xpath("//button[normalize-space()='Open Menu']"));
//        buttonSendwich.click();
//        WebElement buttonLogOut = driver.findElement(By.xpath("//a[@id='logout_sidebar_link']"));
//        buttonLogOut.click();
    //}
}
