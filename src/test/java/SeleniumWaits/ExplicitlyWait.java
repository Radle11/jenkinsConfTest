package SeleniumWaits;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExplicitlyWait {

    WebDriver driver;

    @Test
    public void test1(){
       // System.setProperty("driver","location");
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");

        WebElement removeButton=driver.findElement(By.xpath("//button[.='Remove']"));
        removeButton.click();

        // it takes two argument, one is driver, another one is int num of sec
        // explicitly wait will wait for specific element and provided condition
        WebDriverWait wait=new WebDriverWait(driver,10);
        WebElement message= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        String actualText=message.getText();
        String expectedText="It's gone!";
        Assert.assertEquals(actualText,expectedText);

        WebElement addButton=driver.findElement(By.xpath("//button[.='Add']"));
        addButton.click();
        // explicitly wait for loading
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.id("loading"))));

        String actualBackMessage=driver.findElement(By.id("message")).getText();
        String expectedBackMessage="It's back!";
        Assert.assertEquals(actualBackMessage,expectedBackMessage);

        // What will happen if I use 10 sec for implicitly wait
        // and use 20 sec for explicitly wait
        // According to Selenium documentation/website the result will be unpredictable.


    }


    @Test
    public void test2(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");

        WebElement removeButton=driver.findElement(By.xpath("//button[.='Remove']"));
        removeButton.click();

        WebElement message= BrowserUtils.visibilityOfElementLocated(driver,10,By.id("message"));
        System.out.println(message.getText());

    }
}
