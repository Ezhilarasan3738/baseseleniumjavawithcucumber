package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class tools {
    WebDriver driver;
    public void loadTools() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://toolsqa.com/");
        System.out.println("Hello World");
    }

    public void clickIcon() {
        driver.findElement(By.xpath("//*[@class=\"navbar__tutorial-menu--text\"]")).click();
    }

    public void checkSearchBox() {
        driver.findElement(By.xpath("//*[@class=\"row mega-menu--wrapper\"]")).isDisplayed();
    }

    public void closeWindow() {
        driver.close();
    }
}