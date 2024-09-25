package aboutus;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.AboutUsModal;

import static org.testng.Assert.assertTrue;

public class VideoTests extends BaseTests {


    @Test
    public void videoTest() throws InterruptedException {
        AboutUsModal aboutusModal = homePage.clickAboutUs();


        aboutusModal.clickVideoPlayButton();
        int minutesBefore = aboutusModal.getMinuteFromVideoTime();


       Thread.sleep(70000);


        aboutusModal.clickPlayPauseButton();

        int minutesAfter = aboutusModal.getMinuteFromVideoTime();


        assertTrue(minutesAfter<minutesBefore,"video is not played");


    }
}
