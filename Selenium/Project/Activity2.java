package liveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Activity2 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/jobs");
        Thread.sleep(2000);
        String heading = driver.findElement(By.xpath("//*[text()='Welcome to Alchemy Jobs']")).getText();
        Assert.assertEquals(heading, "Welcome to Alchemy Jobs");

        driver.close();

    }
}
