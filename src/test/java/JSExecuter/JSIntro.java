package JSExecuter;

import Tests.TestBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class JSIntro extends TestBase {


    @Test(enabled = false)
    public void test1() throws InterruptedException {
        driver.get("http://www.techtorialacademy.com/");
        // first we need to cast our driver to JSexecutor
        JavascriptExecutor jsExecutor=(JavascriptExecutor)driver;// casting our driver to JavascriptExecutor
        String title=jsExecutor.executeScript("return document.title;").toString();

        System.out.println(title);
        WebElement browseCourse=driver.findElement(By.xpath("//a[.='Browse Course']"));

        jsExecutor.executeScript("arguments[0].click()",browseCourse);

        title=jsExecutor.executeScript("return document.title;").toString();
        System.out.println(title);

        jsExecutor.executeScript("alert('Techtorial Academy JSExecutor Test')");

        Alert alert=driver.switchTo().alert();
        alert.accept();
        WebElement getStarted=driver.findElement(By.xpath("//h4[.='On-Campus Course']/following-sibling::div/a"));
        Thread.sleep(2000);
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);",getStarted);

    }

    @Test
    public void test2() throws InterruptedException {

        driver.get("http://www.techtorialacademy.com/");

        // I want to refresh my page.
        // driver.navigate().refresh();--> it will refresh the website
        JavascriptExecutor executor=(JavascriptExecutor)driver;
        executor.executeScript("history.go(0)");

        // Using JSExecutor We want to scroll the page until end of it.
        // window.scrollTo(X,Y);
        Thread.sleep(2000);
        executor.executeScript("window.scrollTo(0,document.body.scrollHeight)");

        WebElement onlineCourse=driver.findElement(By.xpath("//a[.='Online Course']"));

        Point point=onlineCourse.getLocation(); // get Location will return Point object
        int xcord=point.getX();// it will return x coordinate of element on the page
        int ycord=point.getY();// it will return y coordinate of element on the page
        System.out.println(xcord);
        System.out.println(ycord);
        //window.scrollBy(x,y)
        executor.executeScript("window.scrollTo("+xcord+","+ycord+")");
        Thread.sleep(2000);
        executor.executeScript("window.scrollBy(0,1000)");

        executor.executeScript("window.scrollTo("+xcord+","+ycord+")");

       // executor.executeScript("arguments[0].setAttribute('style','background:red; border:3px solid black');",onlineCourse);
        executor.executeScript("arguments[0].setAttribute('style','border:3px solid red');",onlineCourse);
        // get html from website using selenium.
        // get all cookies
        // delete cookies

    }

    
}
