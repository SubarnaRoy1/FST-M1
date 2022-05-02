package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_2 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/simple-form");
        System.out.println(driver.getTitle());
        WebElement fname = driver.findElement(By.xpath("//*[@id='firstName']"));
        fname.sendKeys("Subarna");
        WebElement lname = driver.findElement(By.xpath("//*[@id='lastName']"));
        lname.sendKeys("Roy");
        WebElement email = driver.findElement(By.xpath("//*[@id='email']"));
        email.sendKeys("test1@test.com");
        WebElement number = driver.findElement(By.xpath("//*[@id='number']"));
        number.sendKeys("9000000000");
        WebElement message = driver.findElement(By.xpath("//textarea[@rows='2']"));
        message.sendKeys("Hi");

        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@value='submit']")).click();

    }
}