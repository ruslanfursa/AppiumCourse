package org.example.apidemoapk;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;


public class FirstTest extends Base {
    @Test
    public void newTest() {
//        AndroidDriver<AndroidElement> driver = getDriver();
//        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Preference']")).click();
//        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
//        driver.findElement(By.id("android:id/checkbox")).click();
//        driver.findElement(By
//                .xpath("//android.widget.ListView[@resource-id='android:id/list']/android.widget.LinearLayout[2]/android.widget.RelativeLayout")).click();
//        driver.findElement(By.className("android.widget.EditText")).sendKeys("Hello");
//        driver.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']")).click();

        getDriver().findElement(By.xpath("//android.widget.TextView[@content-desc='Preference']")).click();
        getDriver().findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
        getDriver().findElement(By.id("android:id/checkbox")).click();
        getDriver().findElement(By
                .xpath("//android.widget.ListView[@resource-id='android:id/list']/android.widget.LinearLayout[2]/android.widget.RelativeLayout")).click();
        getDriver().findElement(By.className("android.widget.EditText")).sendKeys("Hello");
        getDriver().findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']")).click();

    }

}

