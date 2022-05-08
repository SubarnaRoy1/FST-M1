package activities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;

public class Activity1 {
        AndroidDriver<MobileElement> driver;

        @BeforeClass
        public void setUp() throws MalformedURLException {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("deviceId", "013973f6");
            caps.setCapability("platformName", "android");
            caps.setCapability("automationName", "UiAutomator2");
            caps.setCapability("appPackage", "com.oneplus.calculator");
            caps.setCapability("appActivity", ".Calculator");
            caps.setCapability("noReset", "true");

            URL serverURL = new URL("http://localhost:4723/wd/hub");
            driver = new AndroidDriver<>(serverURL, caps);
        }

        @Test
        public void multiply() {
            driver.findElementById("digit_5").click();
            driver.findElementById("op_mul").click();
            driver.findElementByXPath("//android.widget.Button[@text='9']").click();
            driver.findElementById("eq").click();
            String result = driver.findElement(MobileBy.id("result")).getText();
            System.out.println(result);

            Assert.assertEquals(result, "45");
            Assert.assertTrue(result.contains("45"));
        }

        @AfterClass
        public void tearDown() {
            driver.quit();
        }

    }
