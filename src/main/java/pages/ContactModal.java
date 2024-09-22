package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactModal {
    private WebDriver driver;
    private By contactModalMessage =By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/h5[1]");
    private By contactEmailField =By.xpath("//input[@id='recipient-email']");
    private By contactNameField= By.xpath("//input[@id='recipient-name']");
    private By messageField=By.id("message-text");
    private By sendMessageButton= By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[3]/button[2]");

    public ContactModal(WebDriver driver) {
        this.driver = driver;
    }

    public String getContactModalMessage(){
        WebDriverWait wait = new WebDriverWait(driver ,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(contactModalMessage));
        return driver.findElement(contactModalMessage).getText();

    }

    public void setEmail(String email){driver.findElement(contactEmailField).sendKeys(email);
    }

    public void setName(String name){driver.findElement(contactNameField).sendKeys(name);
    }

    public void setContactMessage(String Message) {driver.findElement(messageField).sendKeys(Message);
    }

    public HomePage clickSendMessage(){
        driver.findElement(sendMessageButton).click();
        return new HomePage(driver);
    }

    public void AcceptAlert (){
        driver.switchTo().alert().accept();
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        // wait.until(ExpectedConditions.ale());
    }

    public String getAlertText(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert().getText();
    }



}
