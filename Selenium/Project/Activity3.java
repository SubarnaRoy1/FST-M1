package liveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/jobs");
        Thread.sleep(2000);
        WebElement image = driver.findElement(By.xpath("//img[@class='attachment-large size-large wp-post-image']"));
        String url = image.getAttribute("src");
        System.out.println("URL1 of header image is " + url);

        driver.close();

    }
}
