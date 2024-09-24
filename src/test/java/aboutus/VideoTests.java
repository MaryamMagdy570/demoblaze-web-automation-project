package aboutus;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.AboutUsModal;

import static org.testng.Assert.assertTrue;

public class VideoTests extends BaseTests {


    @Test
    public void videoTest() throws InterruptedException {
        AboutUsModal aboutusModal = homePage.clickAboutUs();

        aboutusModal.startVideo();


        aboutusModal.playVideo();
        Double timeBefore = aboutusModal.getVideoTime();
        Thread.sleep(5000);
        aboutusModal.pauseVideo();
        Double timeAfter = aboutusModal.getVideoTime();
        assertTrue(timeAfter>timeBefore," video is not playing");

    }
}
