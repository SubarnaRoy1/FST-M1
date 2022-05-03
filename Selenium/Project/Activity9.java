package liveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity9 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://alchemy.hguy.co/jobs/wp-admin");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='user_login']")).sendKeys("root");
        driver.findElement(By.xpath("//*[@id='user_pass']")).sendKeys("pa$$w0rd");
        driver.findElement(By.xpath("//*[@id='wp-submit']")).click();

        driver.findElement(By.xpath("(//div[@class='wp-menu-name'])[6]")).click();
        driver.findElement(By.linkText("Add New")).click();
        driver.findElement(By.xpath("//button[@aria-label='Close dialog']")).click();

        //Fill in details
        driver.findElement(By.xpath("//div[@data-placeholder='Classic']")).click();
        WebElement position = driver.findElement(By.xpath("//div[@class='wp-block-freeform block-library-rich-text__tinymce mce-content-body html5-captions mce-edit-focus']"));
        position.sendKeys("This is a test job");
        WebElement compName = driver.findElement(By.xpath("//input[@name='_company_name']"));
        compName.sendKeys("Test");
        WebElement loc = driver.findElement(By.xpath("//input[@name='_job_location']"));
        loc.sendKeys("London");
        WebElement twitterUser = driver.findElement(By.xpath("//input[@name='_company_twitter']"));
        twitterUser.sendKeys("@YourComp");
        WebElement publishBtn1 = driver.findElement(By.xpath("//button[@class='components-button editor-post-publish-panel__toggle editor-post-publish-button__button is-primary']"));
        publishBtn1.click();
        WebElement publishBtn2 = driver.findElement(By.xpath("//button[@class='components-button editor-post-publish-button editor-post-publish-button__button is-primary']"));
        publishBtn2.click();

        //Verify job listing is created
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='components-button is-secondary']")));
        WebElement viewJob = driver.findElement(By.xpath("//a[@class='components-button is-secondary']"));
        viewJob.click();
        Thread.sleep(2000);
        System.out.println("Posted job description is: " + driver.findElement(By.xpath("//div[@class='job_description']")).getText());

        driver.close();

    }
}