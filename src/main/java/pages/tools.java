package pages;

import com.google.common.collect.Maps;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.Map;

public class tools {
    public WebDriver driver;

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
        System.out.println("All cases executed");
    }

    public void enterValuesInSearchBox(String keyword) {
        driver.findElement(By.xpath("//*[@class=\"navbar__search--input\"]")).click();
        driver.findElement(By.xpath("//*[@class=\"navbar__search--input\"]")).sendKeys(keyword);
    }

    public void enterEachValuesInSearchBox(List<List<String>> keywords) {
        DataTable keyword = DataTable.create(keywords);
        int totalrows = keyword.cells().size();
        System.out.println("All Cells Data: "+keyword.cells());
        for (int ccount = 0; ccount < totalrows; ccount++) {
            System.out.println(keyword.cell(ccount,0));
            driver.findElement(By.xpath("//*[@class=\"navbar__search--input\"]")).click();
            driver.findElement(By.xpath("//*[@class=\"navbar__search--input\"]")).sendKeys(keyword.cell(ccount,0));
            driver.findElement(By.xpath("//*[@class=\"navbar__search--input\"]")).clear();
        }
    }

    public void enterEachValuesUsingMapsInSearchBox(DataTable keywords) {
        for(Map<String, String> keyword: keywords.asMaps(String.class,String.class)){
            System.out.println(keyword.get("QA")+" Vs "+keyword.get("DEV"));
            driver.findElement(By.xpath("//*[@class=\"navbar__search--input\"]")).click();
            driver.findElement(By.xpath("//*[@class=\"navbar__search--input\"]")).sendKeys(keyword.get("QA"));
            driver.findElement(By.xpath("//*[@class=\"navbar__search--input\"]")).clear();
            driver.findElement(By.xpath("//*[@class=\"navbar__search--input\"]")).click();
            driver.findElement(By.xpath("//*[@class=\"navbar__search--input\"]")).sendKeys(keyword.get("DEV"));
            driver.findElement(By.xpath("//*[@class=\"navbar__search--input\"]")).clear();
        }
    }
}