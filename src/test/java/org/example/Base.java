package org.example;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Base {


    private AndroidDriver<AndroidElement> capabilities() throws MalformedURLException {

        File appDirectory = new File("src");

        File apkFile = new File(appDirectory, "ApiDemos-debug.apk");

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        capabilities.setCapability(MobileCapabilityType.APP, apkFile.getAbsolutePath());
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        return new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),
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
            driver = capabilities();
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




//    {"platformName": "Android",
//            "platformVersion": "11",
//            "app": "/Users/ruslanfursa/IdeaProjects/AppiumCourse/src/ApiDemos-debug.apk",
//            "deviceName": "emulator-5554",
//            "automationName": "UiAutomator2"}

}