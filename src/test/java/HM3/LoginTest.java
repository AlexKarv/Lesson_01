package HM3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LoginTest {
    private WebDriver driver;
    private static final String USER_NAME = "performance_glitch_user";
    private static final String USER_PASS = "secret_sauce";
    private static final String USER_PASS_NEG = "secret_sauc";

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
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
    }

//    @BeforeMethod
//    public void beforeMethod() {
//        driver.get("https://www.saucedemo.com/v1/index.html");
//    }

    @Test
    public void loginTestWithXpathPositive() {
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='header_secondary_container']")).
                getText().contains("Prod"));
    }

    @Test
    public void loginTestWithXpathPositiveAddToBasket() throws InterruptedException {
        //Assert.assertTrue(driver.findElement(By.xpath("//div[@class='header_secondary_container']")).getText().contains("Prod"));
        WebElement buttonBusket = driver.findElement(By.xpath("//*[name()='path' and contains(@fill,'currentCol')]"));

        buttonBusket.click();
        //Thread.sleep(5000);
//        WebElement buttonRemove = driver.findElement(By.xpath("//button[@class='btn_secondary cart_button']"));
        WebElement buttonSendwich = driver.findElement(By.xpath("//button[normalize-space()='Open Menu']"));
        WebElement buttonAllitems = driver.findElement(By.xpath("//a[@id='inventory_sidebar_link']"));

//        if (buttonRemove.isDisplayed()) {
//            while (true) {
//                buttonRemove.click();
//            }
//        }
//        if (!buttonRemove.isDisplayed()) {
        buttonSendwich.click();
        //Thread.sleep(5000);
        buttonAllitems.click();
        //Thread.sleep(5000);
        List<WebElement> products = driver.findElements(By.xpath("//div[@class='inventory_item']"));
//        for (WebElement product : products) {
//
//            System.out.println("Наименование товара: " + product.getText());
//        }
        WebElement selectedProduct = null;
        if (!products.isEmpty()) {
            selectedProduct = products.get(0);
            WebElement buttonInFirstProduct = driver.findElement(By.
                    xpath("//div[@class='inventory_list']//div[1]//div[3]//button[1]"));
            //WebElement buttonInFirstProduct1 = selectedProduct.findElement(By.tagName("button"));
            buttonInFirstProduct.click();
            //  Thread.sleep(5000);
        } else {
            System.out.println("Not found products");
        }
        //System.out.println("Selected product" + selectedProduct.getText());
        driver.navigate().refresh();
        Thread.sleep(5000);
        buttonBusket = driver.findElement(By.xpath("//*[name()='path' and contains(@fill,'currentCol')]"));
        buttonBusket.click();
        Thread.sleep(5000);
        WebElement productInBusket = driver.findElement(By.xpath("//div[@class='inventory_item_name']"));
        //System.out.println("Product in busket   " + productInBusket.getText());
        String selProd = "";
        String buskProd = "";
//        if (selectedProduct != null) {
//            selProd = selectedProduct.getText();
//            System.out.println("Selected product: " + selProd);
//        } else {
//            System.out.println("no such element");
//        }

        if (productInBusket != null) {

            buskProd = productInBusket.getText();

            System.out.println("Selected product: " + buskProd);
        } else {
            System.out.println("no such element");
        }







        Assert.assertTrue(selProd.contains(buskProd));

    }


//    @AfterClass
//    public void afterClass() {
//        if (driver != null)
//            driver.quit();
//    }
}