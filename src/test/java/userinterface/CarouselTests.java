package userinterface;

import base.BaseTests;
import org.openqa.selenium.Dimension;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CarouselTests extends BaseTests {


    @Test
    public void verifyCarouselFunctionality() throws InterruptedException {
        // Wait for the first slide to be visible
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));

        // Verify first slide is active
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Wait for up to 10 seconds for elements to be found
        String firstSlideAlt = homePage.getActiveSlideAltText();
        System.out.println("First active slide: " + firstSlideAlt);
        assertEquals(firstSlideAlt, "First slide", "First slide is not correct");
        assertTrue(homePage.isSingleActiveSlide(), "More than one slide is active at the start!");

        // Wait for the second slide to be active
        Thread.sleep(7000);
        String secondSlideAlt = homePage.getActiveSlideAltText();
        System.out.println("Second active slide: " + secondSlideAlt);
        assertEquals(secondSlideAlt, "Second slide", "Second slide is not correct");
        assertTrue(homePage.isSingleActiveSlide(), "More than one slide is active after first transition!");

        // Wait for the third slide to be active
        Thread.sleep(8000);
        String thirdSlideAlt = homePage.getActiveSlideAltText();
        System.out.println("Third active slide: " + thirdSlideAlt);
        assertEquals(thirdSlideAlt, "Third slide", "Third slide is not correct");
        assertTrue(homePage.isSingleActiveSlide(), "More than one slide is active after second transition!");

        boolean isSingleSlideVisible = homePage.verifyOnlyOneSlideVisible();
        Assert.assertTrue(isSingleSlideVisible, "Either more than one slide is visible or an image is not displayed.");

    }


    @Test
    public void verifyCarouselFunctionalityWithMin() throws InterruptedException {
        // Wait for the first slide to be visible
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));

        // Verify first slide is active
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Wait for up to 10 seconds for elements to be found
        String firstSlideAlt = homePage.getActiveSlideAltText();
        System.out.println("First active slide: " + firstSlideAlt);
        assertEquals(firstSlideAlt, "First slide", "First slide is not correct");
        assertTrue(homePage.isSingleActiveSlide(), "More than one slide is active at the start!");


        boolean isSingleSlideVisible = homePage.verifyOnlyOneSlideVisible();
        Assert.assertTrue(isSingleSlideVisible, "Either more than one slide is visible or an image is not displayed.");

        // Wait for the second slide to be active
        Thread.sleep(7000);
        String secondSlideAlt = homePage.getActiveSlideAltText();
        System.out.println("Second active slide: " + secondSlideAlt);
        assertEquals(secondSlideAlt, "Second slide", "Second slide is not correct");
        assertTrue(homePage.isSingleActiveSlide(), "More than one slide is active after first transition!");


        driver.manage().window().setSize(new Dimension(700, 768));

        // Wait for the third slide to be active
        Thread.sleep(7000);
        String thirdSlideAlt = homePage.getActiveSlideAltText();
        System.out.println("Third active slide: " + thirdSlideAlt);
        assertEquals(thirdSlideAlt, "Third slide", "Third slide is not correct");
        assertTrue(homePage.isSingleActiveSlide(), "More than one slide is active after second transition!");


         isSingleSlideVisible = homePage.verifyOnlyOneSlideVisible();
        Assert.assertTrue(isSingleSlideVisible, "Either more than one slide is visible or an image is not displayed.");
    }




}
