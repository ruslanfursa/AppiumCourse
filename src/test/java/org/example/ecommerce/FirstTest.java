package org.example.ecommerce;

import io.appium.java_client.android.AndroidElement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;


import java.util.List;

public class FirstTest extends EcommerceBase {

    @Test
    public void firstTest() {
        String shoesWantToBuy = "Jordan 6 Rings";
        login("Napoleon");

        String expectedHeader = "Products";
        String actualHeader = getDriver().findElement(By
                .xpath("//android.widget.TextView[@text ='Products']")).getText();

        Assertions.assertEquals(expectedHeader, actualHeader);

        getDriver().findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"));");

        List<AndroidElement> products = getDriver().findElements(By.id("com.androidsample.generalstore:id/productName"));

        for (int i = 0; i < products.size(); i++) {
            if (shoesWantToBuy.equals(products.get(i).getText())) {
                getDriver().findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
                break;
            }
        }

        openCart();

        List<AndroidElement> cart = getDriver().findElements(By
                .className("android.widget.TextView"));

        Assertions.assertTrue(isProductInCart(shoesWantToBuy, cart));

    }

    @Test
    public void checkSumInCart() {
        login("Gena");

        List<AndroidElement> products = getDriver().findElements(By.id("com.androidsample.generalstore:id/productAddCart"));

        for (AndroidElement product : products) {
            product.click();
        }

        openCart();

        Double expectedTotalPrice = calcTotalPrice();
        Double actualTotalPrice = Double.parseDouble(getDriver()
                .findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText().substring(2));

        Assertions.assertEquals(expectedTotalPrice, actualTotalPrice);
    }

    private boolean isProductInCart(String product, List<AndroidElement> list) {
        for (AndroidElement shoes : list) {
            if (product.equals(shoes.getText())) {
                return true;
            }
        }
        return false;
    }

    private void login(String name) {
        getWait10().findElement(By
                        .xpath("//android.widget.RadioButton[@resource-id='com.androidsample.generalstore:id/radioFemale']"))
                .click();
        getDriver().findElement(By.className("android.widget.Button")).click();
        String errorMessage = getDriver().findElement(By.xpath("//android.widget.Toast[@text ='Please enter your name']")).getText();

        Assertions.assertEquals("Please enter your name", errorMessage);

        getDriver().findElement(By.className("android.widget.EditText")).sendKeys(name);
        getDriver().findElement(By.id("android:id/text1")).click();
        getDriver().findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");
        getDriver().findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/text1' and @text='Argentina']")).click();
        getDriver().findElement(By.className("android.widget.Button")).click();
    }

    private void openCart() {
        getDriver().findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
    }

    private Double calcTotalPrice() {
        Double expectedSum = 0.0;

        List<AndroidElement> prices = getDriver().findElements(By.id("com.androidsample.generalstore:id/productPrice"));

        for (AndroidElement price : prices) {
            expectedSum += Double.parseDouble(price.getText().substring(1));
        }
        return expectedSum;
    }
}






