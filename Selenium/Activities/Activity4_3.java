package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_3 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/target-practice");
        System.out.println("Page title is: " + driver.getTitle());
        WebElement thirdHeader = driver.findElement(By.xpath("//h3[@id='third-header']"));
        System.out.println("Third header text is: " + thirdHeader.getText());
        WebElement fifthHeader = driver.findElement(By.xpath("//h5[text()='Fifth header']"));
        System.out.println("Fifth header color is: " + fifthHeader.getCssValue("color"));
        WebElement violetBtn = driver.findElement(By.xpath("//button[text()='Violet']"));
        System.out.println("Attribute of violet button is: " + violetBtn.getAttribute("class"));
        WebElement greyBtn = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[2]/div[3]/button[2]"));
        System.out.println("Grey button text is: " + greyBtn.getText());

        driver.close();
    }
}