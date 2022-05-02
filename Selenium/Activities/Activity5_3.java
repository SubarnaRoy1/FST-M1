package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5_3 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/dynamic-controls");
        System.out.println("Page title is: " + driver.getTitle());
        WebElement textBox = driver.findElement(By.xpath("//*[@id='dynamicText']"));
        System.out.println(textBox.isEnabled());
        driver.findElement(By.xpath("//button[@id='toggleInput']")).click();

        Thread.sleep(2000);
        System.out.println(textBox.isEnabled());

        driver.close();

    }
}
