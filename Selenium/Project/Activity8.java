package liveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Activity8 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/jobs/wp-admin");
        driver.findElement(By.xpath("//*[@id='user_login']")).sendKeys("root");
        driver.findElement(By.xpath("//*[@id='user_pass']")).sendKeys("pa$$w0rd");
        driver.findElement(By.xpath("//*[@id='wp-submit']")).click();
        Thread.sleep(2000);

        String dashboard = driver.findElement(By.xpath("//div/h1[text()='Dashboard']")).getText();
        Assert.assertEquals(dashboard, "Dashboard");
        System.out.println("Header title after logging in is: " + dashboard);

        driver.close();

    }
}
