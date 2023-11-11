package HM2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class FramesTests extends BaseTest {

    @Test
    public void switchToFram() {
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        driver.switchTo().frame("frame-bottom");

        String body = driver.findElement(By.xpath("//body")).getText();
        Assert.assertEquals(body, "BOTTOM");

        driver.switchTo().defaultContent();

//      Assert.assertEquals(driver.findElements(By.xpath("//frameset/frame")).size(), 2);
        List<WebElement> webElementList = driver.findElements(By.xpath("//frameset/frame"));
        Assert.assertEquals(webElementList.size(), 2);
    }

    @DataProvider
    public Object[][] createData() {
        return new Object[][]{
                {"LEFT", "frame_left"},
                {"MIDDLE", "frame_middle"},
                {"RIGHT", "frame_right"},
                {"BOTTOM", "frame-bottom"},
        };
    }
    @Test(dataProvider = "createData")
    public void switchToFramUniversal(String expResult, String frameName) {
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        if(!expResult.equals("B0TTON")){
         driver.switchTo().frame("frame-top");
        }

        driver.switchTo().frame(frameName);


        String body = driver.findElement(By.xpath("//body")).getText();
        Assert.assertEquals(body,expResult);

        driver.switchTo().defaultContent();

//      Assert.assertEquals(driver.findElements(By.xpath("//frameset/frame")).size(), 2);
        List<WebElement> webElementList = driver.findElements(By.xpath("//frameset/frame"));
        Assert.assertEquals(webElementList.size(), 2);

    }
    @Test
    public void switchToFramDuble() {
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        driver.switchTo().frame("frame-bottom");

        String body = driver.findElement(By.xpath("//body")).getText();
        Assert.assertEquals(body, "BOTTOM");

        driver.switchTo().defaultContent();

//      Assert.assertEquals(driver.findElements(By.xpath("//frameset/frame")).size(), 2);
        List<WebElement> webElementList = driver.findElements(By.xpath("//frameset/frame"));
        Assert.assertEquals(webElementList.size(), 2);

    }




}
