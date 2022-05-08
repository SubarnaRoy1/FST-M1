package liveProject;

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

public class Activity3 {
    AndroidDriver<MobileElement> driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceId", "013973f6");
        caps.setCapability("platformName", "android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.google.android.keep");
        caps.setCapability("appActivity", ".activities.BrowseActivity");
        caps.setCapability("noReset", "true");

        URL serverURL = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver<>(serverURL, caps);
        wait = new WebDriverWait(driver, 15);
    }

    @Test
    public void addTask() {
        driver.findElementByAccessibilityId("New text note").click();
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("editable_title")));
        driver.findElementById("editable_title").sendKeys("New Note Title");
        driver.findElementById("edit_note_text").sendKeys("This is a new note created by appium");

        //select reminder button
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id("menu_reminder")));
        driver.findElementById("menu_reminder").click();

        //pick date and time
        driver.findElementByXPath("//android.widget.LinearLayout[1]/android.widget.TextView").click();
        String time = "resourceId(\"com.google.android.keep:id/time_spinner\")";
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(time)));
        driver.findElement(MobileBy.AndroidUIAutomator(time)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id("reminder_time_evening"))).click();
        driver.findElementById("save").click();

        driver.findElementByAccessibilityId("Open navigation drawer").click();

        //Switch to Reminders page
        driver.findElementByAccessibilityId("Open navigation drawer").click();
        String reminderTab = "resourceId(\"com.google.android.keep:id/drawer_navigation_reminders\")";
        driver.findElement(MobileBy.AndroidUIAutomator(reminderTab)).click();

        String actualValue = driver.findElementById("index_note_title").getText();
        Assert.assertEquals(actualValue, "New Note Title");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();

    }
}