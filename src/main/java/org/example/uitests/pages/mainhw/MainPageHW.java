package org.example.uitests.pages.mainhw;

import org.example.uitests.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPageHW extends BasePage {
    @FindBy(xpath = "//div[@class='header_secondary_container']")
    private WebElement namePage;

    @FindBy(xpath = "//*[name()='path' and contains(@fill,'currentCol')]")
    private WebElement buttonBusket;
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
//    @FindBy(xpath = "//span[@class='fa-layers-counter shopping_cart_badge']")
//    private WebElement productInABusket;


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

    public WebElement getProductInABusket() {
        return productInABusket;
    }
//    public static void addProductToBasket1(int quantityNumbers) {
//        switch (quantityNumbers) {
//            case 1:
//                .click();
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


    public MainPageHW() {
        super();
    }

    public String getNamePageText() {
        return namePage.getText();
    }
}