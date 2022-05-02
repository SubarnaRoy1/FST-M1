package activities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Activity5 {
    AndroidDriver<MobileElement> driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceId", "013973f6");
        caps.setCapability("platformName", "android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.oneplus.mms");
        caps.setCapability("appActivity", "com.android.mms.ui.ConversationList");
        caps.setCapability("noReset", "true");

        URL serverURL = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver<>(serverURL, caps);
        wait = new WebDriverWait(driver, 15);
    }

    @Test
    public void smsTest() {
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Start new conversation")));
        driver.findElementByAccessibilityId("Start new conversation").click();
        String contactBoxLocator = "resourceId(\"com.oneplus.mms:id/recipient_text_view\")";
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(contactBoxLocator)));
        driver.findElement(MobileBy.AndroidUIAutomator(contactBoxLocator)).sendKeys("7798297884");
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));

        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("compose_message_text")));
        driver.findElement(MobileBy.id("compose_message_text")).sendKeys("Hi");
        driver.findElement(MobileBy.AndroidUIAutomator("description(\"Send Message\")")).click();

        String sentMessageText = driver.findElementByXPath("//android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView").getText();
        Assert.assertEquals(sentMessageText, "Hi");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}