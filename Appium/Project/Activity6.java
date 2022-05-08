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

public class Activity6 {
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
    public void validLogin() {
        driver.get("https://www.training-support.net/selenium");
        driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).scrollForward(2).scrollTextIntoView(\"Popups\")")).click();
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.view.View/android.view.View/android.widget.Button")));
        MobileElement signInButton = driver.findElementByXPath("//android.view.View/android.view.View/android.widget.Button" );
        signInButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.view.View/android.widget.EditText[1]")));
        driver.findElementByXPath("//android.view.View/android.widget.EditText[1]").sendKeys("admin");
        driver.findElementByXPath("//android.view.View/android.widget.EditText[2]").sendKeys("password");
        driver.findElementByXPath("//android.view.View[2]/android.view.View/android.view.View/android.view.View/android.widget.Button").click();

        String loginmsg = "resourceId(\"action-confirmation\")";
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AndroidUIAutomator(loginmsg)));
        String text = driver.findElement(MobileBy.AndroidUIAutomator(loginmsg)).getText();
        Assert.assertEquals(text, "Welcome Back, admin");
        System.out.println(text);
    }

    @Test
    public void invalidLogin() {
        driver.get("https://www.training-support.net/selenium");
        driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).scrollForward(2).scrollTextIntoView(\"Popups\")")).click();
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.view.View/android.view.View/android.widget.Button")));
        MobileElement signInButton = driver.findElementByXPath("//android.view.View/android.view.View/android.widget.Button" );
        signInButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.view.View/android.widget.EditText[1]")));
        driver.findElementByXPath("//android.view.View/android.widget.EditText[1]").sendKeys("admin1");
        driver.findElementByXPath("//android.view.View/android.widget.EditText[2]").sendKeys("password1");
        driver.findElementByXPath("//android.view.View[2]/android.view.View/android.view.View/android.view.View/android.widget.Button").click();

        String loginmsg1 = "resourceId(\"action-confirmation\")";
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AndroidUIAutomator(loginmsg1)));
        String text1 = driver.findElement(MobileBy.AndroidUIAutomator(loginmsg1)).getText();
        Assert.assertEquals(text1, "Invalid Credentials");
        System.out.println(text1);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();

    }
}