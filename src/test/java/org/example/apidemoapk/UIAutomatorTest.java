package org.example.apidemoapk;

import org.example.Base.BaseTest;
import org.junit.jupiter.api.Test;

public class UIAutomatorTest extends BaseTest {
    @Test
    public void UIAutoTest() {
        getDriver().findElementByAndroidUIAutomator("text(\"Views\")").click();
        getDriver().findElementByAndroidUIAutomator("text(\"Animation\")").click();
        System.out.println(getDriver().findElementsByAndroidUIAutomator("new UiSelector().clickable(true)").size());
    }
}
