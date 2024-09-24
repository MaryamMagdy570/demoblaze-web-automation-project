package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage {

    private WebDriver driver;

    private By carouselItems = By.cssSelector(".carousel-inner .carousel-item");
    private By activeSlide = By.cssSelector(".carousel-inner .carousel-item.active");
    //constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }



    // Method to get all carousel slides
    public List<WebElement> getAllSlides() {
        return driver.findElements(carouselItems);
    }

    // Method to get the active slide
    public WebElement getActiveSlide() {
        return driver.findElement(activeSlide);
    }

    // Method to get the 'alt' attribute of the active slide image
    public String getActiveSlideAltText() {
        return getActiveSlide().findElement(By.tagName("img")).getAttribute("alt");
    }

    // Method to verify only one active slide is present
    public boolean isSingleActiveSlide() {
        int activeCount = 0;
        for (WebElement slide : getAllSlides()) {
            if (slide.getAttribute("class").contains("active")) {
                activeCount++;
            }
        }
        return activeCount == 1;
    }



    // Method to check visibility of slides
    public boolean verifyOnlyOneSlideVisible() {
        int visibleSlideCount = 0;

        for (WebElement slide : getAllSlides()) {
            boolean isVisible = slide.isDisplayed();

            if (isVisible) {
                visibleSlideCount++;
                // Check if the image inside the visible slide is displayed
                WebElement img = slide.findElement(By.tagName("img"));
                if (!img.isDisplayed()) {
                    return false; // Image not displayed
                }
            }
        }
        return visibleSlideCount == 1;
    }
    /**
     * interact with Login Modal
     * @return a class of type LoginModal
     */
    public LoginModal clickLogin() {
        clickLink("Log in");
        By modalId = By.id("logInModal");
        WebDriverWait wait = new WebDriverWait(driver ,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(modalId)));
        return new LoginModal(driver);
    }

    public SignUpModal clickSignUp(){
        clickLink("Sign up");
        By SignUpModal=By.id("signInModal");
        WebDriverWait wait = new WebDriverWait(driver ,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(SignUpModal)));
        return new SignUpModal(driver);
    }


    /**
     * reading welcome message for user after login
     *
     * @return the welcome message
     */
    public String getWelcomeMessage() {
        WebDriverWait wait = new WebDriverWait(driver ,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser")));
        return driver.findElement(By.id("nameofuser")).getText();
    }


    public CartPage clickCart() {
        clickLink("Cart");
        return new CartPage(driver);
    }

    public ContactModal clickContact(){
        clickLink("Contact");
        return new ContactModal(driver);
    }


    public ProductPage clickProduct(String productLink) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
         wait.until(ExpectedConditions.elementToBeClickable(By.linkText(productLink)));
        clickLink(productLink);
        return new ProductPage(driver);
    }


    private void clickLink(String linkText) {
        driver.findElement(By.linkText(linkText)).click();
    }




}
