package org.example.apidemoapk;

import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;

import org.example.Base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.appium.java_client.TouchAction;

public class GesturesTest extends BaseTest {
    @Test
    public void longTapTest() {
        getDriver().findElementByAndroidUIAutomator("text(\"Views\")").click();
        getDriver().findElement(By.xpath("//android.widget.TextView[@content-desc='Expandable Lists']")).click();
        getDriver().findElement(By.xpath("//android.widget.TextView[@content-desc='1. Custom Adapter']")).click();
        WebElement element1 = getDriver().findElement(By.xpath("//android.widget.TextView[@text='Dog Names']"));

        TouchAction touchActions = new TouchAction(getDriver());

        touchActions.longPress(new LongPressOptions().withElement(ElementOption.element(element1))).perform();

        String expectedString = "Sample menu";

        String actualString = getDriver().findElement(By
                .xpath("//android.widget.TextView[@resource-id='android:id/title' and @text='Sample menu']")).getText();

        Assertions.assertEquals(expectedString, actualString);
    }
}
