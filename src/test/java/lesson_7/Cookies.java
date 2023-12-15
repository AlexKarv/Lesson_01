package lesson_7;

import org.example.uitests.browser.WebDriwerHolder;
import org.example.uitests.pages.login.LoginPage;
import org.example.uitests.utils.ConfigProvider;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Cookies extends BaseTest{

    String userName = ConfigProvider.getInstance().getProperty("login.tests.username");
    String userPassword = ConfigProvider.getInstance().getProperty("login.tests.password");
    @BeforeMethod
    public void BeforeMetgodTest () {
        goToPart("login");
    }

    @Test
    public void CookiesTest () {
        LoginPage loginPage = new LoginPage();
        loginPage.login(userName,userPassword);


        WebDriver driver = WebDriwerHolder.getInstance().getDriver();
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.manage().deleteAllCookies();
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        goToPart("login");
        loginPage.login(userName,userPassword);

        for(Cookie cookie : driver.manage().getCookies()) {
            System.out.println(cookie.getName() + " --- " + cookie.getValue());
        }


        System.out.println();
        Cookie cookie = new Cookie("SomeCookie", "some val");
        driver.manage().addCookie(cookie);

        Cookie cookieSome = driver.manage().getCookieNamed("SomeCookie");
        System.out.println(cookie.getName() + " --- " + cookie.getValue());
        driver.manage().deleteCookieNamed("SomeCookie");

        cookieSome = driver.manage().getCookieNamed("SomeCookie");
        System.out.println(cookieSome);
    }
    
    
}
