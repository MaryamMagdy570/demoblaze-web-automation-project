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
    private By videoPlayButton = By.xpath("//body/div[@id='videoModal']/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[4]/button[1]");
    private By videoTime = By.className("vjs-remaining-time-display");
    private By videoElement=By.className("vjs-poster");

    public AboutUsModal(WebDriver driver) {
        this.driver = driver;
    }

    public String getVideoTime (){
        return driver.findElement(videoTime).getText();
    }

    public void clickVideoPlayButton(){
        driver.findElement(videoElement).click();
    }


    public int getMinuteFromVideoTime() {
        String time = getVideoTime(); // Get the time from the video
        String minuteString = time.substring(0, 2); // Extract the minutes (first two characters)
        return Integer.parseInt(minuteString); // Convert to integer
    }

    public void clickPlayPauseButton (){
        driver.findElement(videoPlayButton).click();

    }
}



