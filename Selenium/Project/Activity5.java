package liveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Activity5 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/jobs");
        Thread.sleep(2000);
        driver.findElement(By.linkText("Jobs")).click();
        String jobTitle = driver.findElement(By.xpath("//h1[text()='Jobs']")).getText();

        Assert.assertEquals(jobTitle, "Jobs");

        driver.close();

    }
}
