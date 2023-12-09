package org.example.uitests.pages.busketpagehw;

import org.example.uitests.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BusketPageHW extends BasePage {
    @FindBy(xpath = "//div[@class='subheader']")
    private WebElement busketPage;

    public BusketPageHW() {
        super();
    }

    public WebElement getBusketPage() {
        return busketPage;
    }
}
