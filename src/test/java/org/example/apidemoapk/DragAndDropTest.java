package org.example.apidemoapk;

import io.appium.java_client.TouchAction;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static io.appium.java_client.touch.offset.ElementOption.element;

public class DragAndDropTest extends Base {

    @Test
    public void dragAndDropTest() {
        getDriver().findElementByAndroidUIAutomator("text(\"Views\")").click();
        getDriver().findElement(By.xpath("//android.widget.TextView[@content-desc='Drag and Drop']")).click();

        WebElement source = getDriver().findElements(By.className("android.view.View")).get(0);
        WebElement target = getDriver().findElements(By.className("android.view.View")).get(2);

        TouchAction touchAction = new TouchAction(getDriver());
        touchAction.longPress(element(source)).moveTo(element(target)).release().perform();
    }
}
