package lesson_14_sort;

import org.example.uitests.pages.loginhw.LoginPageHW;
import org.example.uitests.pages.mainhw.MainPageHW;
import org.example.uitests.utils.ConfigProvider;
import org.testng.annotations.BeforeMethod;

public class SortTest extends  BaseTest {

    //Зайти на сайт https://www.saucedemo.com/v1/index.html, залогиниться.

    private static final String USER_NAME = ConfigProvider.getInstance().getProperty("loginHW.tests.username");

    private static final String USER_PASS = ConfigProvider.getInstance().getProperty("loginHW.tests.password");

    @BeforeMethod
    public void beforeMethod() {
        goToPart("index.html");

        LoginPageHW loginPageHW = new LoginPageHW();
        MainPageHW mainPageHW = loginPageHW.successfulLogin(USER_NAME, USER_PASS);
    }





}
