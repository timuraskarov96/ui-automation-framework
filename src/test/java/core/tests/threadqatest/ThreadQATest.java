package core.tests.threadqatest;

import core.base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.threadqa.selenide.ThreadQAPageSelenide;
import pages.threadqa.selenium.ThreadQAPage;

public class ThreadQATest extends BaseTest {

    @Test
    public void threadQATestSelenium(){
        new ThreadQAPage()
                .openPage()
                .enterText()
                .enterEmail()
                .enterPassword()
                .enterArea()
                .testDropdown()
                .clickCheckbox()
                .clickRadio()
                .buttonMainIsDisplayed()
                .buttonSecondaryIsDisplayed()
                .buttonSuccessIsDisplayed()
                .buttonDangerIsDisplayed()
                .checkDisplayedInformMessage()
                .checkModalWindow()
                .checkToastNotification()
                .checkExternalLink();
    }

    @Test
    public void threadQATestSelenide(){
        new ThreadQAPageSelenide()
                .openPage()
                .enterText()
                .enterEmail()
                .enterPassword()
                .enterArea()
                .testDropdown()
                .clickCheckbox()
                .clickRadio()
                .buttonMainIsDisplayed()
                .buttonSecondaryIsDisplayed()
                .buttonSuccessIsDisplayed()
                .buttonDangerIsDisplayed()
                .checkDisplayedInformMessage()
                .checkModalWindow()
                .checkToastNotification()
                .checkExternalLink();
    }

    @Test
    public void advancedElementsSelenium(){
        new ThreadQAPage()
                .openPage()
                .clickAdvancedElements()
                .clickLaunchButton()
                .progressMeaningIsDisplayed()
                .progressBarIsDisplayed()
                .readyIsDisplayed()
                .actionDragAndDrop()
                .uploadFile()
                .downloadFile();
    }
}
