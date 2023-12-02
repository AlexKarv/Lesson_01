package org.example.uitests.pages.loginhw;

import org.example.uitests.pages.BasePage;
import org.example.uitests.pages.mainhw.MainPageHW;
import org.example.uitests.utils.ConfigProvider;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageHW extends BasePage {

    private static final String USER_NAME = ConfigProvider.getInstance().getProperty("loginHW.tests.username");

    private static final String USER_PASS = ConfigProvider.getInstance().getProperty("loginHW.tests.password");
    @FindBy(id = "user-name")
    private WebElement userInput;

    @FindBy(id = "password")
    private WebElement passInput;

    @FindBy(xpath = "//input[@id='login-button']")
    private WebElement buttonLogin;

    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement errorMessage;


    private LoginPageHW setName() {
        userInput.clear();
        userInput.sendKeys(USER_NAME);
        return this;
    }

    private LoginPageHW setPass() {
        passInput.clear();
        passInput.sendKeys(USER_PASS);
        return this;
    }

    private void clickButtonLogin() {
        buttonLogin.click();
    }

    public MainPageHW successfulLogin() {
        setName()
                .setPass()
                .clickButtonLogin();
        return new MainPageHW();
    }
    public LoginPageHW unSuccessfulLogin() {
        setName()
                .setPass()
                .clickButtonLogin();
        return this;
    }

    public String getErrorMassageTextUnSucces () {
        return errorMessage.getText();
    }


//    @FindBy(id = "username")
//    private WebElement userInput;
//
//    @FindBy(css ="#password")
//    private WebElement passwordInput;
//
//    @FindBy(xpath = "//i[@class='fa fa-2x fa-sign-in']")
//    private WebElement loginButton;
//
//    @FindBy(id = "flash")
//    private WebElement errorMessage;
//
//    public LoginPageHW() {
//        super();
//    }
//
//    private LoginPageHW setUserName(String userName) {
//        return enterValueToWebElement(userInput, userName);
//    }
//
//    private LoginPageHW setUserPassword(String userPassword) {
//        return enterValueToWebElement(passwordInput, userPassword);
//    }
//
//    private LoginPageHW enterValueToWebElement(WebElement element, String value) {
//        element.clear();
//        element.sendKeys(value);
//        return this;
//    }
//
//    private void clickLoginButton() {
//        loginButton.click();
//    }
//
//    public MainPage login(String userName, String userPassword) {
//        setUserName(userName)
//                .setUserPassword(userPassword)
//                .clickLoginButton();
//        return new MainPage();
//    }
//
//    public LoginPageHW unsuccessfulLogin(String userName, String userPassword) {
//        setUserName(userName)
//                .setUserPassword(userPassword + "1")
//                .clickLoginButton();
//        return new LoginPageHW();
//    }
//
//    public String getErrorMessageText() {
//        return errorMessage.getText();
//    }
}
