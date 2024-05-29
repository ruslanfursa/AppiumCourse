package org.example.ecommerce;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class FirstTest extends EcommerceBase{

    @Test
    public void firstTest() {
        getWait10().findElement(By
                .xpath("//android.widget.RadioButton[@resource-id='com.androidsample.generalstore:id/radioFemale']"))
                .click();
//        getWait10().findElement(By.xpath("*//[@text = 'Female']")).click();
        getDriver().findElement(By.className("android.widget.EditText")).sendKeys("Napoleon");
        getDriver().findElement(By.id("android:id/text1")).click();
        getDriver().findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");
        getDriver().findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/text1' and @text='Argentina']")).click();
        getDriver().findElement(By.className("android.widget.Button")).click();
    }

    @Test
    public void secondTest() {
        //test1

    }

}
