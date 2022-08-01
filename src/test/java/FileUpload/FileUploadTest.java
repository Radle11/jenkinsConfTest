package FileUpload;

import Tests.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class FileUploadTest extends TestBase {

    // when I extend this class with TestBase, I need to provide the parameter
    // If I need to provide the parameter, I should use the xml file to run my class
    @Test
    public void test1(){

        driver.get("https://the-internet.herokuapp.com/upload");
        // for file upload in Selenium, we need to send the key as a path of the file
        // which we want to upload.
        // to Upload the file tag of element should be "input" and type should be "file"
        WebElement chooseFile=driver.findElement(By.id("file-upload"));
        chooseFile.sendKeys("/Users/techotrialadmin/Desktop/FileUploadTest.png");
       //WINDOWS USER DOUBLE SLASH-->chooseFile.sendKeys("C:\\Users\\ismai\\Desktop\\FileUploadTest.png");
        WebElement uploadButton=driver.findElement(By.id("file-submit"));
        uploadButton.submit();

        WebElement textMessage=driver.findElement(By.id("uploaded-files"));
        String actualText=textMessage.getText();
        String expectedText="FileUploadTest.png";

        softAssert.assertEquals(actualText,expectedText);
        softAssert.assertAll();

    }

    @Test
    public void test2() throws InterruptedException {
        driver.navigate().to("http://demo.guru99.com/test/upload/");
        WebElement chooseFile=driver.findElement(By.id("uploadfile_0"));
        chooseFile.sendKeys("/Users/techotrialadmin/Desktop/TechtorialAcademy.png");
        WebElement submitButton=driver.findElement(By.id("submitbutton"));
        submitButton.click();

        String expectedText="1 file\n" +
                "has been successfully uploaded.";
        Thread.sleep(2000);
        String actualMessage=driver.findElement(By.id("res")).getText();

        softAssert.assertEquals(actualMessage,expectedText);
        softAssert.assertAll();

    }
}
