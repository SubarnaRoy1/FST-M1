package liveProject;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
        caps.setCapability("appPackage", "com.android.chrome");
        caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
        caps.setCapability("noReset", "true");

        URL serverURL = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver<>(serverURL, caps);
        wait = new WebDriverWait(driver, 15);
    }

    @Test
    public void toDoList() {
        driver.get("https://www.training-support.net/selenium");
        driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).scrollForward(2).scrollTextIntoView(\"To-Do List\")")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.className("android.widget.EditText")));
        driver.findElementByClassName("android.widget.EditText").sendKeys("Add tasks to list");
        driver.findElementByXPath("//android.view.View/android.view.View[1]/android.widget.Button").click();
        driver.findElementByClassName("android.widget.EditText").sendKeys("Get number of tasks");
        driver.findElementByXPath("//android.view.View/android.view.View[1]/android.widget.Button").click();
        driver.findElementByClassName("android.widget.EditText").sendKeys("Clear the list");
        driver.findElementByXPath("//android.view.View/android.view.View[1]/android.widget.Button").click();

        driver.findElementByXPath("//android.view.View[2]/android.view.View[2]/android.widget.TextView").click();
        driver.findElementByXPath("//android.view.View[2]/android.view.View[3]/android.widget.TextView").click();
        driver.findElementByXPath("//android.view.View[2]/android.view.View[4]/android.widget.TextView").click();

        //Click Clear List button
        driver.findElementByXPath("//android.view.View/android.view.View[3]/android.widget.TextView[2]").click();

    }
    @AfterClass
    public void tearDown() {
        driver.quit();

    }
}