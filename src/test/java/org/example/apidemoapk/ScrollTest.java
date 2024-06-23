package org.example.apidemoapk;

import io.appium.java_client.android.AndroidElement;
import org.example.Base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.util.List;


public class ScrollTest extends BaseTest {
    @Test
    public void scrollTest() {
        getDriver().findElementByAndroidUIAutomator("text(\"Views\")").click();
        List<AndroidElement> tabs = getDriver().findElements(By.id("android:id/text1"));

        Assertions.assertEquals(15, tabs.size());

        getDriver().findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView3\"));");
    }
}
