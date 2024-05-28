package org.example.apidemoapk;

import org.junit.jupiter.api.Test;

public class UIAutomatorTest extends Base {
    @Test
    public void UIAutoTest() {
        getDriver().findElementByAndroidUIAutomator("text(\"Views\")").click();
        getDriver().findElementByAndroidUIAutomator("text(\"Animation\")").click();
        System.out.println(getDriver().findElementsByAndroidUIAutomator("new UiSelector().clickable(true)").size());
    }
}
