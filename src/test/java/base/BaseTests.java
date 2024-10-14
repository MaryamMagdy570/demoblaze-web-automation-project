package base;

import dev.failsafe.internal.util.Durations;
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
import java.time.Duration;


public class BaseTests {

    protected static WebDriver driver;
    protected HomePage homePage;

    public SoftAssert softAssert = new SoftAssert();

    @BeforeSuite
    public void setUpSuite() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(getChromeOptions());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://www.demoblaze.com/index.html");
    }

    @BeforeClass
    public void setUp() throws InterruptedException {
        homePage = new HomePage(driver);
    }

    @AfterSuite
    public void tearDownSuite() {
        if (driver != null) {
            driver.quit();
        }
        softAssert.assertAll();
    }


    @AfterMethod
    public void recordFailure(ITestResult result) throws IOException {
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