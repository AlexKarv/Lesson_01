package org.example.uitests.pages.busketpagehw;

import org.example.uitests.browser.WebDriwerHolder;
import org.example.uitests.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BusketPageHW extends BasePage {
    @FindBy(xpath = "//div[@class='subheader']")
    private WebElement busketPage;


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
