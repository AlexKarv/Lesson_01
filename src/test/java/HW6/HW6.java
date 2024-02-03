package HW6;

import org.example.uitests.pages.busketpagehw.BusketPageHW;
import org.example.uitests.pages.loginhw.LoginPageHW;
import org.example.uitests.pages.mainhw.MainPageHW;
import org.example.uitests.utils.ConfigProvider;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HW6 extends BaseTest {
    //    private static WebDriver driver;
//    private static final String USER_NAME = "performance_glitch_user";
//    private static final String USER_PASS = "secret_sauce";

    private static final String USER_NAME = ConfigProvider.getInstance().getProperty("loginHW.tests.username");

    private static final String USER_PASS = ConfigProvider.getInstance().getProperty("loginHW.tests.password");

    @BeforeMethod
    public void beforeMethod() {
        goToPart("index.html");

    }

    @Test
    public void successfulLogin() {
        LoginPageHW loginPageHW = new LoginPageHW();
        MainPageHW mainPageHW = loginPageHW.successfulLogin(USER_NAME, USER_PASS);
        Assert.assertTrue(mainPageHW.getNamePageText().contains("Prod"));

//        (driver.findElement(By.xpath("//div[@class='header_secondary_container']")).
//           getText().contains("Prod"));
    }

    @Test
    public void unSuccessfulLogin() {
        LoginPageHW loginPageHW = new LoginPageHW();
        loginPageHW.unSuccessfulLogin(USER_NAME, USER_PASS);
        Assert.assertTrue(loginPageHW.getErrorMassageTextUnSucces().contains("Epic"));
    }

    @Test
    public void addProductToBusket() {
        LoginPageHW loginPageHW = new LoginPageHW();
        MainPageHW mainPageHW = loginPageHW.successfulLogin(USER_NAME, USER_PASS);
        mainPageHW.addProductToBasket1(2);
        BusketPageHW busketPageHW = new BusketPageHW();
        busketPageHW = mainPageHW.moveToBusketPage();
        int count = busketPageHW.howProductInBusket();
        Assert.assertEquals(count,2);
    }
    @Test
    public void chooseRandomProduct() {
        MainPageHW mainPageHW = new MainPageHW();



    }



//    @Test
//    public void checkProductsInBusket() {
//        LoginPageHW loginPageHW = new LoginPageHW();
//        MainPageHW mainPageHW = loginPageHW.successfulLogin(USER_NAME, USER_PASS);
//        try {
//            Assert.assertFalse();
//        } catch (NoSuchElementException e) {
//        }
//    }


//    @Test
//    public void loginTestWithXpathPositiveAddToBasket() {
//        howProductInBusket();
//        Assert.assertTrue(howProductInBusket() == 0);
//        addProductToBasket1(1);
//        Assert.assertTrue(howProductInBusket() == 1);
//        deleteProductInBasket(1);
//        addProductToBasket1(2);
//        Assert.assertTrue(howProductInBusket() == 2);
//        deleteProductInBasket(2);
//        addProductToBasket1(3);
//        Assert.assertTrue(howProductInBusket() == 3);
//        deleteProductInBasket(1);
//        Assert.assertTrue(howProductInBusket() == 2);
//        logOut();
//    }
//
//    public static int howProductInBusket() {
//        WebElement buttonBusket = driver.findElement(By.xpath("//*[name()='path' and contains(@fill,'currentCol')]"));
//        buttonBusket.click();
//        List<WebElement> item = driver.findElements(By.className("cart_item"));
//        System.out.println("item.size:              " + item.size());
//        int quantityProductInBusket = item.size();
//        return quantityProductInBusket;
//    }
//
//    public static void addProductToBasket1(int quantityNumbers) {
//        WebElement buttonSendwich = driver.findElement(By.xpath("//button[normalize-space()='Open Menu']"));
//        WebElement buttonAllitems = driver.findElement(By.xpath("//a[@id='inventory_sidebar_link']"));
//        buttonSendwich.click();
//        buttonAllitems.click();
//        WebElement buttonInFirstProduct = driver.findElement(By.
//                xpath("//div[@class='inventory_list']//div[1]//div[3]//button[1]"));
//        WebElement buttonInSecondProduct = driver.findElement(By.
//                xpath("/html[1]/body[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[3]/button[1]"));
//        WebElement buttonInThirtProduct = driver.findElement(By.
//                xpath("//div[3]//div[3]//button[1]"));
//        switch (quantityNumbers) {
//            case 1:
//                buttonInFirstProduct.click();
//                break;
//            case 2:
//                buttonInFirstProduct.click();
//                buttonInSecondProduct.click();
//                break;
//            case 3:
//                buttonInFirstProduct.click();
//                buttonInSecondProduct.click();
//                buttonInThirtProduct.click();
//                break;
//            default:
//                System.out.println("mistake");
//                break;
//        }
//    }
//
//    public static void deleteProductInBasket(int quantityNumberstoDelete) {
//        WebElement buttonSendwich = driver.findElement(By.xpath("//button[normalize-space()='Open Menu']"));
//        WebElement buttonAllitems = driver.findElement(By.xpath("//a[@id='inventory_sidebar_link']"));
//        buttonSendwich.click();
//        buttonAllitems.click();
//        WebElement buttonDeleteInFirstProduct = driver.findElement(By.
//                xpath("//div[@class='inventory_list']//div[1]//div[3]//button[1]"));
//        WebElement buttonInDeleteSecondProduct = driver.findElement(By.
//                xpath("/html[1]/body[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[3]/button[1]"));
//        WebElement buttonInDeleteThirtProduct = driver.findElement(By.
//                xpath("//div[3]//div[3]//button[1]"));
//        switch (quantityNumberstoDelete) {
//            case 1:
//                buttonDeleteInFirstProduct.click();
//                break;
//            case 2:
//                buttonDeleteInFirstProduct.click();
//                buttonInDeleteSecondProduct.click();
//                break;
//            case 3:
//                buttonDeleteInFirstProduct.click();
//                buttonInDeleteSecondProduct.click();
//                buttonInDeleteThirtProduct.click();
//                break;
//            default:
//                System.out.println("mistake");
//                break;
//        }
//    }
//
//    public static void logOut() {
//        WebElement buttonSendwich = driver.findElement(By.xpath("//button[normalize-space()='Open Menu']"));
//        buttonSendwich.click();
//        WebElement buttonLogOut = driver.findElement(By.xpath("//a[@id='logout_sidebar_link']"));
//        buttonLogOut.click();
//        WebElement buttonLoggin = driver.findElement(By.xpath("//input[@id='login-button']"));
//        Assert.assertEquals(buttonLoggin.getAttribute("value"), "LOGIN");
//    }
//
//    public static void checkThatLogOutIsSucsessful() {
//        WebElement buttonLoggin = driver.findElement(By.xpath("//input[@id='login-button']"));
//        Assert.assertEquals(buttonLoggin.getAttribute("value"), "LOGIN");
//    }
//    @AfterClass
//    public void afterClass() {
//        if (driver != null)
//            driver.quit();
//    }
}
