package HM3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
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
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='header_secondary_container']")).
                getText().contains("Prod"));
    }

    @Test
    public void loginTestWithXpathPositiveAddToBasket() throws InterruptedException {

        //Assert.assertTrue(driver.findElement(By.xpath("//div[@class='header_secondary_container']")).getText().contains("Prod"));
        WebElement buttonBusket = driver.findElement(By.xpath("//*[name()='path' and contains(@fill,'currentCol')]"));
        buttonBusket.click();
        Thread.sleep(5000);
        //List<WebElement> car_items = driver.findElements(By.xpath(//div[@class='cart_item']));

        // WebElement buttonRemove = null;
//        try {
//            buttonRemove = driver.findElement(By.xpath("//button[@class='btn_secondary cart_button']"));
//            while (buttonRemove.isDisplayed()) {
//                buttonRemove.click();
//            }
//        } catch (Exception e) {
//            throw new NoSuchElementException();
//        }



        WebElement buttonSendwich = driver.findElement(By.xpath("//button[normalize-space()='Open Menu']"));
        WebElement buttonAllitems = driver.findElement(By.xpath("//a[@id='inventory_sidebar_link']"));


        //WebElement cart_list = driver.findElement(By.xpath(//div[@class='cart_list']));


//        cart_list = driver.find_element(By.XPATH, "//div[@class='cart_list']")
//
//# Находим все элементы cart_item внутри cart_list с использованием XPath
//                cart_items = cart_list.find_elements(By.XPATH, "//div[@class='cart_item']")
//
//# Помещаем все элементы cart_item в список
//        cart_items_list = list(cart_items)

//        if (buttonRemove.isDisplayed()) {
//            while (true) {
//                buttonRemove.click();
//            }
//        }
//        if (!buttonRemove.isDisplayed()) {
        buttonSendwich.click();
        buttonAllitems.click();
        List<WebElement> products = driver.findElements(By.xpath("//div[@class='inventory_item']"));

        WebElement selectedProduct = null;
        if (!products.isEmpty()) {
            selectedProduct = products.get(0);
            WebElement buttonInFirstProduct = driver.findElement(By.
                    xpath("//div[@class='inventory_list']//div[1]//div[3]//button[1]"));
            buttonInFirstProduct.click();
        } else {
            System.out.println("Not found products");
        }
        String selProd = "";
        if (selectedProduct != null) {
            selProd = selectedProduct.getText();
        } else {
            System.out.println("no such element");
        }
        WebElement findSeldPrice = driver.findElement(By.xpath("//div[@class='inventory_item_price']"));
        String findSeldPriceWithout$ = findSeldPrice.getText().toString().replace("$", "");
        System.out.println("findSeldPriceWithout$ :" + findSeldPriceWithout$);

        buttonBusket = driver.findElement(By.xpath("//*[name()='path' and contains(@fill,'currentCol')]"));
        buttonBusket.click();
        WebElement productInBusket = driver.findElement(By.xpath("//div[@class='inventory_item_name']"));
        String buskProd = "";
        if (productInBusket != null) {
            buskProd = productInBusket.getText();
        } else {
            System.out.println("no such element");
        }
        WebElement findBuskProd = driver.findElement(By.xpath("//div[@class='inventory_item_price']"));
        String findBuskProdPrice = findBuskProd.getText();
        System.out.println("findBuskProdPrice: " + findBuskProdPrice);

        Assert.assertTrue(selProd.contains(buskProd));
        Assert.assertEquals(findSeldPriceWithout$, findBuskProdPrice);
        buttonSendwich = driver.findElement(By.xpath("//button[normalize-space()='Open Menu']"));
        buttonSendwich.click();
        WebElement buttonLogOut = driver.findElement(By.xpath("//a[@id='logout_sidebar_link']"));
        buttonLogOut.click();
        WebElement buttonLoggin = driver.findElement(By.xpath("//input[@id='login-button']"));
        Assert.assertEquals(buttonLoggin.getAttribute("value"), "LOGIN");
    }

    @AfterClass
    public void afterClass() {
        if (driver != null)
            driver.quit();
    }
}