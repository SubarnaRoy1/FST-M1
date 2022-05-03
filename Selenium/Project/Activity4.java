package liveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Activity4 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/jobs");
        Thread.sleep(2000);
        String heading2 = driver.findElement(By.xpath("//*[text()='Quia quis non']")).getText();
        Assert.assertEquals(heading2, "Quia quis non");

        driver.close();

    }
}