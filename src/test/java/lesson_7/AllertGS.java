package lesson_7;

import org.example.uitests.browser.WebDriwerHolder;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AllertGS extends BaseTest{

    @BeforeMethod
    public void BeforeMethod () {
        goToPart("javascript_alerts");

    }

    WebDriver driver = WebDriwerHolder.getInstance().getDriver();
    public String getResultJS() {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        return javascriptExecutor.executeScript("return document.getElementById('result').textContent").toString();
    }
    enum Buttons {
        ALERT("Click for JS Alert", "jsAlert()"),
        CONFIRM("Click for JS Confirm", "jsConfirm()"),
        PROMPT("Click for JS Prompt", "jsPrompt()");

        private String text;
        private String jsScript;

        Buttons(String s, String jsScript) {
            this.text = s;
            this.jsScript = jsScript;
        }

        public String getText() {
            return text;
        }
    }
    private void clickOnButton(Buttons button) {
        WebElement alertButton = driver.findElement(By.xpath("//button[contains(text(),'" + button.getText() + "')]"));
        alertButton.click();
    }
    public void clickPromptButton() {
        clickOnButton(Buttons.PROMPT);
    }
    public String workWithAlert(boolean accept, String... textToEnter) {
        Alert alert = driver.switchTo().alert();
        String text = alert.getText();
        if (textToEnter.length > 0) {
            alert.sendKeys(textToEnter[0]);
        }
        if (accept) {
            alert.accept();
        } else {
            alert.dismiss();
        }
        return text;
    }

    @Test
    public void promptTestOkJSResult() {
        String textToEnter = "TestString!";
        clickPromptButton();
        workWithAlert(true, textToEnter);
        String result = getResultJS();
        Assert.assertEquals(result, "You entered: " + textToEnter);
    }

}
