package liveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Activity7 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        JavascriptExecutor js = (JavascriptExecutor)driver;

        driver.get("https://alchemy.hguy.co/jobs");
        Thread.sleep(2000);
        driver.findElement(By.linkText("Post a Job")).click();

        //signing in
        WebElement signIn = driver.findElement(By.xpath("//*[text()='Sign in']"));
        signIn.click();
        driver.findElement(By.xpath("//*[@id='user_login']")).sendKeys("root");
        driver.findElement(By.xpath("//*[@id='user_pass']")).sendKeys("pa$$w0rd");
        driver.findElement(By.xpath("//*[@id='wp-submit']")).click();

        //filling all details
        WebElement jobTitle = driver.findElement(By.xpath("//*[@id='job_title']"));
        jobTitle.sendKeys("Testing job");
        WebElement scrollToDesc = driver.findElement(By.xpath("//label[text()='Description']"));
        js.executeScript("arguments[0].scrollIntoView();", scrollToDesc);

        WebElement descType = driver.findElement(By.xpath("//iframe[@id='job_description_ifr']"));
        descType.click();
        descType.sendKeys("This is a test, please ignore");
        WebElement companyName = driver.findElement(By.xpath("//*[@id='company_name']"));
        companyName.clear();
        companyName.sendKeys("Testing");
        WebElement website = driver.findElement(By.xpath("//*[@id='company_website']"));
        website.clear();
        website.sendKeys("http://www.test11.com");
        WebElement twitterUser = driver.findElement(By.xpath("//*[@id='company_twitter']"));
        twitterUser.clear();
        twitterUser.sendKeys("@YourC");
        WebElement previewBtn = driver.findElement(By.xpath("//*[@name='submit_job']"));
        previewBtn.click();
        Thread.sleep(5000);
        WebElement submitListing = driver.findElement(By.id("job_preview_submit_button"));
        wait.until(ExpectedConditions.elementToBeClickable(submitListing));
        submitListing.click();

        //Verify job is posted
        driver.findElement(By.linkText("Jobs")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Testing job']")));
        WebElement postedJob = driver.findElement(By.xpath("//*[text()='Testing job']"));
        System.out.println(postedJob.getText());

        driver.close();

    }
}