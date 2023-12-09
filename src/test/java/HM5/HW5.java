package HM5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HW5 extends BaseTest {
   private static WebDriver driver;
    private static final String USER_NAME = "performance_glitch_user";
    private static final String USER_PASS = "secret_sauce";
        @BeforeMethod
        public void beforeMethod() {
            goToPart("login");


            driver.get("https://www.saucedemo.com/v1/index.html");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            WebElement userNameField = driver.findElement(By.id("user-name"));
            userNameField.clear();
            userNameField.sendKeys(USER_NAME);
            WebElement userPasswordField = driver.findElement(By.id("password"));
            userPasswordField.clear();
            userPasswordField.sendKeys(USER_PASS);
            WebElement buttonLoggin = driver.findElement(By.xpath("//input[@id='login-button']"));
            buttonLoggin.click();
            Assert.assertTrue(driver.findElement(By.xpath("//div[@class='header_secondary_container']")).
                    getText().contains("Prod"));
        }

        @Test
    public void loginTestWithXpathPositiveAddToBasket() {
        howProductInBusket();
        Assert.assertTrue(howProductInBusket() == 0);
        addProductToBasket1(1);
        Assert.assertTrue(howProductInBusket() == 1);
        deleteProductInBasket(1);
        addProductToBasket1(2);
        Assert.assertTrue(howProductInBusket() == 2);
        deleteProductInBasket(2);
        addProductToBasket1(3);
        Assert.assertTrue(howProductInBusket() == 3);
        deleteProductInBasket(1);
        Assert.assertTrue(howProductInBusket() == 2);
        logOut();
    }

    public static int howProductInBusket() {
        WebElement buttonBusket = driver
                .findElement(By.xpath("\"//div[3]//div[3]//button[1]\"\"//div[3]//div[3]//button[1]\"\"//div[3]//div[3]//button[1]\"\"//div[3]//div[3]//button[1]\"')]"));
        buttonBusket.click();
        List<WebElement> item = driver.findElements(By.className("cart_item"));
        System.out.println("item.size:              " + item.size());
        int quantityProductInBusket = item.size();
        return quantityProductInBusket;
    }

    public static void addProductToBasket1(int quantityNumbers) {
        WebElement buttonSendwich = driver.findElement(By.xpath("//button[normalize-space()='Open Menu']"));
        WebElement buttonAllitems = driver.findElement(By.xpath("//a[@id='inventory_sidebar_link']"));
        buttonSendwich.click();
        buttonAllitems.click();
        WebElement buttonInFirstProduct = driver.findElement(By.
                xpath("//div[@class='inventory_list']//div[1]//div[3]//button[1]"));
        WebElement buttonInSecondProduct = driver.findElement(By.
                xpath("/html[1]/body[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[3]/button[1]"));
        WebElement buttonInThirtProduct = driver.findElement(By.
                xpath("//div[3]//div[3]//button[1]"));
        switch (quantityNumbers) {
            case 1:
                buttonInFirstProduct.click();
                break;
            case 2:
                buttonInFirstProduct.click();
                buttonInSecondProduct.click();
                break;
            case 3:
                buttonInFirstProduct.click();
                buttonInSecondProduct.click();
                buttonInThirtProduct.click();
                break;
            default:
                System.out.println("mistake");
                break;
        }
    }

    public static void deleteProductInBasket(int quantityNumberstoDelete) {
        WebElement buttonSendwich = driver.findElement(By.xpath("//button[normalize-space()='Open Menu']"));
        WebElement buttonAllitems = driver.findElement(By.xpath("//a[@id='inventory_sidebar_link']"));
        buttonSendwich.click();
        buttonAllitems.click();
        WebElement buttonDeleteInFirstProduct = driver.findElement(By.
                xpath("//div[@class='inventory_list']//div[1]//div[3]//button[1]"));
        WebElement buttonInDeleteSecondProduct = driver.findElement(By.
                xpath("/html[1]/body[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[3]/button[1]"));
        WebElement buttonInDeleteThirtProduct = driver.findElement(By.
                xpath("//div[3]//div[3]//button[1]"));
        switch (quantityNumberstoDelete) {
            case 1:
                buttonDeleteInFirstProduct.click();
                break;
            case 2:
                buttonDeleteInFirstProduct.click();
                buttonInDeleteSecondProduct.click();
                break;
            case 3:
                buttonDeleteInFirstProduct.click();
                buttonInDeleteSecondProduct.click();
                buttonInDeleteThirtProduct.click();
                break;
            default:
                System.out.println("mistake");
                break;
        }
    }
    public static void logOut() {
        WebElement buttonSendwich = driver.findElement(By.xpath("//button[normalize-space()='Open Menu']"));
        buttonSendwich.click();
        WebElement buttonLogOut = driver.findElement(By.xpath("//a[@id='logout_sidebar_link']"));
        buttonLogOut.click();
        WebElement buttonLoggin = driver.findElement(By.xpath("//input[@id='login-button']"));
        Assert.assertEquals(buttonLoggin.getAttribute("value"), "LOGIN");
    }
    public static void checkThatLogOutIsSucsessful() {
        WebElement buttonLoggin = driver.findElement(By.xpath("//input[@id='login-button']"));
        Assert.assertEquals(buttonLoggin.getAttribute("value"), "LOGIN");
    }
//    @AfterClass
//    public void afterClass() {
//        if (driver != null)
//            driver.quit();
//    }
}
