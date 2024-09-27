package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;


public class BaseTests {

    public WebDriver driver;
    protected HomePage homePage;

    public SoftAssert softAssert = new SoftAssert();

    //@BeforeClass // before each class
    @BeforeSuite
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(getChromeOptions());
        driver.get("https://www.demoblaze.com/index.html");
        homePage = new HomePage(driver);
    }


    @AfterSuite
    public void tearDown() throws InterruptedException {
        driver.quit();

        // report assertions
        softAssert.assertAll();

    }

    //@BeforeMethod
    public void goHome(){
        driver.get("https://www.demoblaze.com/index.html");
    }


    @AfterMethod
    public void recordFailure(ITestResult result) throws IOException {
        //gohome
        driver.findElement(By.partialLinkText("Home")).click();

        //record failure
        if (ITestResult.FAILURE== result.getStatus()){
            var camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            Files.move(screenshot.toPath(), new File("screenshots/"+result.getName()+".png").toPath());
        }
    }

    /**
     * handle for window manager
     */
    public WindowManager getWindowManager(){
        return new WindowManager(driver);
    }

    private ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        return options;
    }

    private void setCookie() {
        Cookie cookie = new Cookie.Builder ("tau", "12")
                .domain("the-internet.herokuapp.com")
                .build();
        driver.manage().addCookie(cookie);
    }


}