package org.example.uitests.pages.mainhw;

import org.example.uitests.browser.WebDriverFactory;
import org.example.uitests.browser.WebDriwerHolder;
import org.example.uitests.pages.BasePage;
import org.example.uitests.pages.busketpagehw.BusketPageHW;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainPageHW extends BasePage {
    private int number;
    private String url;
    private String name;
    private String price;

    public MainPageHW(int number, String url, String name, String price) {
        this.number = number;
        this.url = url;
        this.name = name;
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public void RandomProduct () {


    }

//    public String randomProduct () {
//        MainPageHW product1 = new MainPageHW(1,"//div[normalize-space()='Sauce Labs Backpack']","Sauce Labs Backpack", 29.99);
//        MainPageHW product2 = new MainPageHW(2,"//div[normalize-space()='Sauce Labs Bike Light']","Sauce Labs Bike Light", 9.99);
//        MainPageHW product3 = new MainPageHW(3,"//div[normalize-space()='Sauce Labs Fleece Jacket']","Sauce Labs Bolt T-Shirt", 15.99);
//        MainPageHW product4 = new MainPageHW(4,"//div[normalize-space()='Sauce Labs Fleece Jacket']","Sauce Labs Fleece Jacket", 49.99);
//        MainPageHW product5 = new MainPageHW(5,"//div[normalize-space()='Sauce Labs Onesie']","Sauce Labs Onesie", 7.99);
//        MainPageHW product6 = new MainPageHW(4,"//div[normalize-space()='Test.allTheThings() T-Shirt (Red)']","Test.allTheThings() T-Shirt (Red)", 15.99);
//
//        ArrayList <MainPageHW> products = new ArrayList<>();
//        products.add(product1);
//        products.add(product2);
//        products.add(product3);
//        products.add(product4);
//        products.add(product5);
//        products.add(product6);
//
//        Random random = new Random();
//        int randomIndex = random.nextInt(products.size());
//        MainPageHW randomProduct = products.get(randomIndex);
//
//        return randomProduct.getUrl();
//    }

    public void clickButton(String path) {
        WebElement button = WebDriwerHolder.getInstance().getDriver().findElement(By.xpath(path));
        button.click();
    }


    @FindBy(className = "product_label")
    private WebElement namePage;

    @FindBy(xpath = "//*[name()='path' and contains(@fill,'currentCol')]")
    private WebElement buttonBusket;

    @FindBy(className = "inventory_item")
    private List<WebElement> products;

    public List<WebElement> getMyProducts() {
        return products;
    }

    public void clickRandomProduct() {

        // Выбираем случайный товар
        Random random = new Random();
        int productIndex = random.nextInt(products.size());
        WebElement product = products.get(productIndex);
       // Получаем название товара и цену
        WebElement nameProduct = product.findElement(By.className("inventory_item_name"));
        name = nameProduct.getText();
        WebElement priceElement = product.findElement(By.className("pricebar"));
        price = priceElement.getText();

        // WebElement buttonToClick = product.findElement(By.xpath("//button[contains(text(),'ADD TO CART')]"));
        WebElement buttonToClick = product.findElement(By.xpath(".//button[contains(text(),'ADD TO CART')]"));
        buttonToClick.click();


    }

//    public void click (String str) {
//        WebElement webElement = WebDriverFactory.getDriver().findElement(str);
//
//    }


    @FindBy(xpath = "//button[normalize-space()='Open Menu']")
    private WebElement buttonSendwich;
    @FindBy(xpath = "//a[@id='inventory_sidebar_link']")
    private WebElement buttonAllitems;
    @FindBy(xpath = "//div[@class='inventory_list']//div[1]//div[3]//button[1]")
    private WebElement buttonInFirstProduct;
    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[3]/button[1]")
    private WebElement buttonInSecondProduct;
    @FindBy(xpath = "//div[3]//div[3]//button[1]")
    private WebElement buttonInThirtProduct;

    @FindBy(xpath = "//div[4]//div[3]//button[1]")
    private WebElement buttonInFourProduct;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[5]/div[3]/button[1]")
    private WebElement buttonInFiveProduct;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[6]/div[3]/button[1]")
    private WebElement buttonInSixProduct;
//    @FindBy(xpath = "//span[@class='fa-layers-counter shopping_cart_badge']")
//    private WebElement productInABusket;


public BusketPageHW moveToBusketPage () {
    buttonBusket.click();
    return new BusketPageHW();
}

    public WebElement getNamePage() {
        return namePage;
    }

    public WebElement getButtonBusket() {
        return buttonBusket;
    }

    public WebElement getButtonSendwich() {
        return buttonSendwich;
    }

    public WebElement getButtonAllitems() {
        return buttonAllitems;
    }

    public WebElement getButtonInFirstProduct() {
        return buttonInFirstProduct;
    }

    public WebElement getButtonInSecondProduct() {
        return buttonInSecondProduct;
    }

    public WebElement getButtonInThirtProduct() {
        return buttonInThirtProduct;
    }

//    public WebElement getProductInABusket() {
//        return productInABusket;
//    }
    public MainPageHW addProductToBasket1(int quantityNumbers) {
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
        return this;
    }


    public MainPageHW() {
        super();
    }

    public String getNamePageText() {
        return namePage.getText();
    }
}