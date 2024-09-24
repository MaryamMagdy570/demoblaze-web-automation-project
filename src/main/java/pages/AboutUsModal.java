package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class AboutUsModal {

    private WebDriver driver;
    private By video = By.xpath("//video[@id='example-video_html5_api']");


    public AboutUsModal(WebDriver driver) {
        this.driver = driver;
    }


    public void startVideo(){
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("vjs-poster")));
        driver.findElement(By.className("vjs-poster")).click();
    }

    public void playVideo(){
         JavascriptExecutor js = (JavascriptExecutor) driver;
         js.executeScript("arguments[0].play();", driver.findElement(video));
    }

    public void pauseVideo(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("return arguments[0].paused;", driver.findElement(video));
    }

    public Double getVideoTime() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (Double) js.executeScript("return arguments[0].currentTime;", driver.findElement(video));
    }

}
