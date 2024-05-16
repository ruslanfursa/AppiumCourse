package org.example;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

public class SwipeTest extends Base {

    @Test
    public void swipeTest() {
        getDriver().findElementByAndroidUIAutomator("text(\"Views\")").click();
        getDriver().findElement(By.xpath("//android.widget.TextView[@content-desc='Date Widgets']")).click();
        getDriver().findElement(By.xpath("//android.widget.TextView[@content-desc='2. Inline']")).click();
        WebElement first = getDriver().findElement(By
                .xpath("//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc='3']"));
        WebElement second = getDriver().findElement(By
                .xpath("//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc='9']"));

        TouchAction touchAction = new TouchAction(getDriver());

//        touchAction.longPress(LongPressOptions.longPressOptions().withElement(element(first))
//                .withDuration(ofSeconds(1))).moveTo(element(second)).release().perform();
        touchAction.longPress(LongPressOptions.longPressOptions().withElement(element(first))).moveTo(element(second)).release().perform();

    }
}
