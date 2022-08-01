package SelectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestDrpdownSorted {
    @Test
    public void runTestOnDocker() throws Exception {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://chercher.tech/practice/practice-dropdowns-selenium-webdriver");

        WebElement element = driver.findElement(By.xpath("//select[@id='animals']"));
        Select se = new Select(element);
        List<String> originalList = new ArrayList();
        List<String> tempList = new ArrayList();
        for (WebElement e : se.getOptions()) {
            originalList.add(e.getText());
            tempList.add(e.getText());
        }

        System.out.println("this is originalList before Sorting tempList"+ originalList);
        Collections.sort(tempList);
        System.out.println("this is originalList after sorting tempList"+ originalList);
        System.out.println("this is tempList"+ tempList);
        Assert.assertEquals(tempList, originalList);
    }
}
