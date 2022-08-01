package ActionPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class KeyboardEvents {
    @Test
    void test() {
        WebDriverManager.chromedriver().setup();
        // Initialize ChromeDriver
        // Here we assume that the ChromeDriver path has been set in the System Global variables
        WebDriver driver = new ChromeDriver();

        //Navigate to the demo site
        driver.get("https://demoqa.com/text-box");

        // Enter the Full Name
        WebElement fullName = driver.findElement(By.id("userName"));
        fullName.sendKeys("Mr.Peter Haynes");

        //Enter the Email
        WebElement email = driver.findElement(By.id("userEmail"));
        email.sendKeys("PeterHaynes@toolsqa.com");

        // Enter the Current Address
        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys("43 School Lane London EC71 9GO");

        // Copy the Current Address
        currentAddress.sendKeys(Keys.CONTROL + "A");
        currentAddress.sendKeys(Keys.CONTROL + "C");

        //Press the TAB Key to Switch Focus to Permanent Address
        currentAddress.sendKeys(Keys.TAB);

        //Paste the Address in the Permanent Address field
        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
        permanentAddress.sendKeys(Keys.CONTROL + "V");

        //Compare Text of current Address and Permanent Address
        assertEquals(currentAddress.getAttribute("value"), permanentAddress.getAttribute("value"));

        driver.close();

    }

    @Test
    void test2() {
        WebDriverManager.chromedriver().setup();

        // Initialize ChromeDriver
        // Here we assume that the ChromeDriver path has been set in the System Global variables
        WebDriver driver = new ChromeDriver();

        //Navigate to the demo site
        driver.get("https://demoqa.com/text-box");

        //Create object of the Actions class
        Actions actions = new Actions(driver);


        // Enter the Full Name
        WebElement fullName = driver.findElement(By.id("userName"));
        fullName.sendKeys("Mr.Peter Haynes");

        //Enter the Email
        WebElement email = driver.findElement(By.id("userEmail"));
        email.sendKeys("PeterHaynes@toolsqa.com");


        // Enter the Current Address
        WebElement currentAddress = driver.findElement(By.id("currentAddress"));

        currentAddress.sendKeys("43 School Lane London EC71 9GO");


        // Select the Current Address using CTRL + A
        actions.keyDown(Keys.CONTROL);
        actions.sendKeys("a");
        actions.keyUp(Keys.CONTROL);
        actions.build().perform();

        // Copy the Current Address using CTRL + C
        actions.keyDown(Keys.CONTROL);
        actions.sendKeys("c");
        actions.keyUp(Keys.CONTROL);
        actions.build().perform();

        //Press the TAB Key to Switch Focus to Permanent Address
        actions.sendKeys(Keys.TAB);
        actions.build().perform();

        //Paste the Address in the Permanent Address field using CTRL + V
        actions.keyDown(Keys.CONTROL);
        actions.sendKeys("v");
        actions.keyUp(Keys.CONTROL);
        actions.build().perform();


        //Compare Text of current Address and Permanent Address
        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
        assertEquals(currentAddress.getAttribute("value"), permanentAddress.getAttribute("value"));


        driver.close();

    }

    @Test
    void test3(){
        WebDriverManager.chromedriver().setup();

        // Initialize ChromeDriver
        // Here we assume that the ChromeDriver path has been set in the System Global variables
        WebDriver driver=new ChromeDriver();

        //Navigate to the demo site
        driver.get("https://demoqa.com/text-box");

        //Create object of the Actions class
        Actions actions = new Actions(driver);


        // Enter the Full Name
        WebElement fullName = driver.findElement(By.id("userName"));
        fullName.sendKeys("Mr.Peter Haynes");

        //Enter the Email
        WebElement email=driver.findElement(By.id("userEmail"));
        email.sendKeys("PeterHaynes@toolsqa.com");


        // Enter the Current Address
        WebElement currentAddress=driver.findElement(By.id("currentAddress"));

        currentAddress.sendKeys("43 School Lane London EC71 9GO");

        // Select the Current Address
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
        // Copy the Current Address
        actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();

        //Press the TAB Key to Switch Focus to Permanent Address
        actions.sendKeys(Keys.TAB).build().perform();

        //Paste the Address in the Permanent Address field
        actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();


        //Compare Text of current Address and Permanent Address
        WebElement permanentAddress=driver.findElement(By.id("permanentAddress"));
        assertEquals(currentAddress.getAttribute("value"),permanentAddress.getAttribute("value"));


        driver.close();
    }
}
