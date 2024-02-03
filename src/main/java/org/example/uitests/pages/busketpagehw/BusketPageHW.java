package org.example.uitests.pages.busketpagehw;

import org.example.uitests.browser.WebDriwerHolder;
import org.example.uitests.pages.BasePage;
import org.example.uitests.pages.mainhw.MainPageHW;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.xml.bind.Element;
import java.util.List;

public class BusketPageHW extends BasePage {

    private int number;
    private String url;
    private String name;
    private String price;

    public void MainPageHW(int number, String url, String name, String price) {
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


    @FindBy(xpath = "//div[@class='subheader']")
    private WebElement busketPage;

    @FindBy(className = "cart_item")
    private List<WebElement> productsInBusket;

    @FindBy(xpath = "//button[normalize-space()='Open Menu']")
    private WebElement buttonSandwich;

    @FindBy(xpath = "//a[@id='inventory_sidebar_link']")
    private WebElement buttonAllItems;

    public WebElement getButtonSandwich() {
        return buttonSandwich;
    }

    public WebElement getButtonAllItems() {
        return buttonAllItems;
    }

    public void whatIsTheProductInBusket() {
        if (!productsInBusket.isEmpty()) {
            WebElement element = productsInBusket.get(0);
            System.out.println("элемент в корзине: " + element);
            WebElement nameProduct = element.findElement(By.className("inventory_item_name"));
            name = nameProduct.getText();
            System.out.println(name);
            WebElement priceProduct = element.findElement(By.className("inventory_item_price"));
            price = priceProduct.getText();

        } else {
            System.out.println("нет выбранных элементов");
        }

    }

    public MainPageHW moveToMainPage () {
        buttonSandwich.click();
        buttonAllItems.click();
        return new MainPageHW();
    }

    public int howProductInBusket() {

        List<WebElement> item = WebDriwerHolder.getInstance().getDriver().findElements(By.className("cart_item"));
        System.out.println("item.size:              " + item.size());
        int quantityProductInBusket = item.size();
        return quantityProductInBusket;
    }


    public BusketPageHW() {
        super();
    }

    public WebElement getBusketPage() {
        return busketPage;
    }
}
