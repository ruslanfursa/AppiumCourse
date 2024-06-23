package org.example.chromeBrowser;

import org.example.Base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class ChromeTest extends BaseTest {

    @Test
    public void FirstTest() {
        getDriver().get("https://rahulshettyacademy.com/angularAppdemo/");
        getWait10(getDriver()).findElement(By.xpath("//span[@class = 'navbar-toggler-icon']")).click();
        getDriver().findElement(By.xpath("//a[text() = 'Products ']")).click();
        String actualProductName = getDriver().findElement(By.xpath("//a[@href = '/angularAppdemo/products/3']")).getText();

        Assertions.assertEquals("Devops", actualProductName);
    }
}
