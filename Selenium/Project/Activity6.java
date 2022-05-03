package liveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity6 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://alchemy.hguy.co/jobs");
        Thread.sleep(2000);
        driver.findElement(By.linkText("Jobs")).click();
        driver.findElement(By.xpath("//input[@id='search_keywords']")).sendKeys("Banking");
        WebElement searchBtn = driver.findElement(By.xpath("//input[@type='submit']"));
        searchBtn.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[text()='Intelligence Business Machines'])[1]")));
        WebElement job1 = driver.findElement(By.xpath("(//*[text()='Intelligence Business Machines'])[1]"));
        job1.click();
        WebElement applyButton = driver.findElement(By.xpath("//input[@class='application_button button']"));
        applyButton.click();
        String emailDetails = driver.findElement(By.xpath("//*[@class='application_details']")).getText();
        System.out.println("Email details are: " + emailDetails);

        driver.close();

    }

}
