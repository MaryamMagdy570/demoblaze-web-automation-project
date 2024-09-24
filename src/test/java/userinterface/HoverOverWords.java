package userinterface;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotEquals;

public class HoverOverWords extends BaseTests {

    @Test
    public void testingWordsColours(){
        var colorBeforeHover = homePage.getWordColor("Contact");
        homePage.hoverOverLink("Contact");
        var colorAfterHover = homePage.getWordColor("Contact");
        assertNotEquals(colorBeforeHover,colorAfterHover,"color is the same with hover");

    }
}
