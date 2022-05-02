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

public class Activity4 {
    AndroidDriver<MobileElement> driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceId", "013973f6");
        caps.setCapability("platformName", "android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.oneplus.dialer");
        caps.setCapability("appActivity", "com.android.dialer.oneplus.activity.OPDialtactsActivity");
        caps.setCapability("noReset", "true");

        URL serverURL = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver<>(serverURL, caps);
        wait = new WebDriverWait(driver, 15);
    }
    @Test
    public void addContact() {

        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("menu_add_contact")));
        driver.findElementById("menu_add_contact").click();
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("First name")));
        MobileElement firstName = driver.findElementByAccessibilityId("First name");
        firstName.sendKeys("Subarna");
        MobileElement lastName = driver.findElementByXPath("//android.widget.EditText[@content-desc='Last name']");
        lastName.sendKeys("R");

        driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).scrollForward(4).scrollDescriptionIntoView(\"Phone\")"));
        MobileElement phoneNumber = driver.findElementByXPath("//android.widget.EditText[@content-desc='Phone']");
        phoneNumber.sendKeys("7798297665");
        driver.findElementByAccessibilityId("Save").click();

        //wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView")));
        //String contactName = driver.findElementByXPath("android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView").getText();
        //Assert.assertEquals(contactName, "Subarna R");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}