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

public class Activity1 {
    AndroidDriver<MobileElement> driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceId", "013973f6");
        caps.setCapability("platformName", "android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.google.android.apps.tasks");
        caps.setCapability("appActivity", ".ui.TaskListsActivity");
        caps.setCapability("noReset", "true");

        URL serverURL = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver<>(serverURL, caps);
        wait = new WebDriverWait(driver, 15);
    }

    @Test
    public void addTask() {
        MobileElement addTaskbtn = driver.findElementByAccessibilityId("Create new task");
        addTaskbtn.click();
        MobileElement enterTask = driver.findElementByXPath("//android.widget.LinearLayout/android.widget.EditText");
        enterTask.sendKeys("Complete Activity with Google Tasks");
        driver.findElementById("add_task_done").click();

        addTaskbtn.click();
        String addTask2 = "resourceId(\"com.google.android.apps.tasks:id/add_task_title\")";
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AndroidUIAutomator(addTask2)));
        driver.findElement(MobileBy.AndroidUIAutomator(addTask2)).sendKeys("Complete Activity with Google Keep");
        driver.findElementById("add_task_done").click();

        addTaskbtn.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AndroidUIAutomator(addTask2)));
        driver.findElement(MobileBy.AndroidUIAutomator(addTask2)).sendKeys("Complete the second Activity Google Keep");
        driver.findElementById("add_task_done").click();
    }
    @AfterClass
    public void tearDown() {
        driver.quit();

    }
}
