package org.example.Base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {


    private AndroidDriver<AndroidElement> capabilities() throws MalformedURLException {

        File appDirectory = new File("src");

        File apkFile = new File(appDirectory, "ApiDemos-debug.apk");

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        capabilities.setCapability(MobileCapabilityType.APP, apkFile.getAbsolutePath());
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        return new AndroidDriver<>(new URL("http://127.0.0.1:4723/"),
                capabilities);
    }

    private AndroidDriver<AndroidElement> chromeCapabilities() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        return new AndroidDriver<>(new URL("http://127.0.0.1:4723/"),
                capabilities);
    }

    //    protected AndroidDriver<AndroidElement> getDriver() {
//        try {
//            return capabilities();
//        } catch (MalformedURLException e) {
//            throw new RuntimeException(e);
//        }
//    }
    private AndroidDriver<AndroidElement> driver;

    {
        try {
//            driver = capabilities();
            driver = chromeCapabilities();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    protected AndroidDriver<AndroidElement> getDriver() {
        return driver;
    }


    protected AndroidDriver<AndroidElement> getWait10(AndroidDriver<AndroidElement> driver) {
        AndroidDriver<AndroidElement> getWait10 = driver;
        getWait10.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return getWait10;
    }
}