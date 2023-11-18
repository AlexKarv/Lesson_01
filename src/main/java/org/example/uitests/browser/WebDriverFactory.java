package org.example.uitests.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {
    private final static String BROWSER = System.getProperty("browser");
    private static WebDriver driver;


    private static WebDriver getDriver(Browser browser) {
        switch (browser) {
            case EDGE:
                return getEdgeDriwer();

            case CHROME:
                return getChromeDriwer();

            case FIREFOX:
                return getFirefoxDriwer();
            default:
                throw new IllegalArgumentException("Wrong type of browser provided. Choose are: chrome, firefox");
        }

    }

    public static WebDriver getDriver() {
//        driver = getDriver(Browser.valueOf(BROWSER.toUpperCase()));
//        return driver;
        Browser browser = null;
        try {
            browser = Browser.valueOf(System.getProperty("browser", "chrome").toUpperCase());
        } catch (IllegalArgumentException ex) {
            System.out.println("This driver is not supported.\nPlease choose: chrome, edge, firefox");
            System.exit(-1); // Щоб не йшло виконання далі
            }
            return getDriver(browser);


        }

    private static WebDriver getFirefoxDriwer() {
        if (driver == null)
            driver = new FirefoxDriver();
        return driver;
    }

    private static WebDriver getChromeDriwer() {
        if (driver == null)
            driver = new ChromeDriver();
        return driver;
    }

    private static WebDriver getEdgeDriwer() {
        if (driver == null)
            driver = new EdgeDriver();
        return driver;
    }

    public static void main(String[] args) {
        System.getProperties().forEach((k, v) -> System.out.println(k + "   " + v));
    }
}
