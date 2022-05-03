package liveProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Activity1 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/jobs");
        Thread.sleep(2000);
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, "Alchemy Jobs – Job Board Application");

        driver.close();

    }
}
