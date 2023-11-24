//package HM5;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//
//public class HW5_old {
//    private static WebDriver driver;
//
//    private static final String USER_NAME = "performance_glitch_user";
//    private static final String USER_PASS = "secret_sauce";
//    private static final String USER_PASS_NEG = "secret_sauc";
//
//
//    @BeforeClass
//    public void beforeClass() {
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
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
//
//    @Test
//    public void loginTestWithXpathPositiveAddToBasket() {
//        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='header_secondary_container']")).getText().contains("Prod"));
//        //howProductInBusket();
//       // Assert.assertTrue(howProductInBusket()==0);
//        addProductToBasket(0,0);
//        //Assert.assertTrue(howProductInBusket()==1);
//        addProductToBasket(1,1);
//        //Assert.assertTrue(howProductInBusket()==2);
//        addProductToBasket(2,2);
//        //Assert.assertTrue(howProductInBusket()==3);
//        WebElement findSeldPrice = driver.findElement(By.xpath("//div[@class='inventory_item_price']"));
//        String findSeldPriceWithout$ = findSeldPrice.getText().toString().replace("$", "");
//        System.out.println("findSeldPriceWithout$ :" + findSeldPriceWithout$);
//
//        WebElement findBuskProd = driver.findElement(By.xpath("//div[@class='inventory_item_price']"));
//        String findBuskProdPrice = findBuskProd.getText();
//        System.out.println("findBuskProdPrice: " + findBuskProdPrice);
//
//        //Assert.assertTrue(addFirstProductToBasket().contains(prodInBusket));
//        Assert.assertEquals(findSeldPriceWithout$, findBuskProdPrice);
//        logOut();
//
//    }
//
//    public static int howProductInBusket () {
//        WebElement buttonBusket = driver.findElement(By.xpath("//*[name()='path' and contains(@fill,'currentCol')]"));
//        buttonBusket.click();
//        List<WebElement>item = driver.findElements(By.className("cart_item"));
//        System.out.println("item.size:              " + item.size());
//        int quantityProductInBusket = item.size();
//        return quantityProductInBusket;
//    }
//
//    public static String addProductToBasket(int numbersOfProduct,int quantityNumbers) {
//        WebElement buttonSendwich = driver.findElement(By.xpath("//button[normalize-space()='Open Menu']"));
//        WebElement buttonAllitems = driver.findElement(By.xpath("//a[@id='inventory_sidebar_link']"));
//        buttonSendwich.click();
//        buttonAllitems.click();
//        List<WebElement> products = driver.findElements(By.xpath("//div[@class='inventory_item']"));
//
//        WebElement selectedProduct = null;
//        if (!products.isEmpty()) {
//            selectedProduct = products.get(numbersOfProduct);
//            WebElement buttonInFirstProduct = driver.findElement(By.
//                    xpath("//div[@class='inventory_list']//div[1]//div[3]//button[1]"));
//            for(int i = 0; i<=quantityNumbers; i++){
//            buttonInFirstProduct.click();}
//        } else {
//            System.out.println("Not found products");
//        }
//        String selProd = "";
//        if (selectedProduct != null) {
//            selProd = selectedProduct.getText();
//        } else {
//            System.out.println("no such element");
//        }
//        return selProd;
//
//    }
//
//    public static String checkProductInBusket() {
//        WebElement buttonBusket = driver.findElement(By.xpath("//*[name()='path' and contains(@fill,'currentCol')]"));
//        buttonBusket.click();
//        WebElement productInBusket = driver.findElement(By.xpath("//div[@class='inventory_item_name']"));
//        String buskProd = "";
//        if (productInBusket != null) {
//            buskProd = productInBusket.getText();
//        } else {
//            System.out.println("no such element");
//        }
//        return buskProd;
//    }
//
//    public static void logOut() {
//        WebElement buttonSendwich = driver.findElement(By.xpath("//button[normalize-space()='Open Menu']"));
//        buttonSendwich.click();
//        WebElement buttonLogOut = driver.findElement(By.xpath("//a[@id='logout_sidebar_link']"));
//        buttonLogOut.click();
//        WebElement buttonLoggin = driver.findElement(By.xpath("//input[@id='login-button']"));
//        Assert.assertEquals(buttonLoggin.getAttribute("value"), "LOGIN");
//
//    }
//public static void checkThatLogOutIsSucsessful () {
//    WebElement buttonLoggin = driver.findElement(By.xpath("//input[@id='login-button']"));
//    Assert.assertEquals(buttonLoggin.getAttribute("value"), "LOGIN");
//
//}
//
//
//    @AfterClass
//    public void afterClass() {
//        if (driver != null)
//            driver.quit();
//    }
//
//
//}
