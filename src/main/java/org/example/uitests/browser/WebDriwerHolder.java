package org.example.uitests.browser;

import org.openqa.selenium.WebDriver;

public class WebDriwerHolder {
    private static WebDriwerHolder instance = null;
    private WebDriver driver;
    WebDriwerHolder () {
        driver = WebDriverFactory.getDriver();

    }
    public static WebDriwerHolder getInstance() {
        if(instance == null) {
            instance = new WebDriwerHolder();
        }
        return instance;
    }

    public WebDriver getDriver() {
        return driver;
    }
    public void driverQuite () {
        if(driver!=null) {
         driver.quit();
        }
    }
}
