package org.example.uitests.pages.mainhw;

import org.example.uitests.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPageHW extends BasePage {
    @FindBy(xpath = "//div[@class='header_secondary_container']")
    private WebElement namePage;

    public MainPageHW() {
        super();
    }

    public String getNamePageText() {
        return namePage.getText();
    }
}