package Tests.com.Sentrifugo;

import Pages.LoginPage;
import Tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    // we want to make sure before the Test Annotation My object from LoginPage is instantiated
    LoginPage page;
    @BeforeClass
    public void pageSetup(){
        // WebDriver
        page=new LoginPage(driver);
    }

    // All test annotations will be implemented in this class
    // When you provide more than one parameter, you need to give them inside curly braces { } .
    @Parameters({"username","password"})
    @Test
    public void loginTest1(String username, String password){
        // Provide two parameter for username and password.
        // The values will come from the xml runner class.
        // Update the smokeRunner class to run sentrifugo login test.
        driver.get("http://demo.sentrifugo.com/index.php/");
        page.username.sendKeys(username);
        page.password.sendKeys(password);
        page.loginButton.click();
        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="http://demo.sentrifugo.com/index.php/index/welcome";
        Assert.assertEquals(actualUrl,expectedUrl);
    }

}
