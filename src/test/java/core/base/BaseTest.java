package core.base;

import com.codeborne.selenide.Configuration;
import core.driver.DriverManager;
import core.extensions.ScreenshotOnFailureExtension;
import core.steps.AvStepsSelenide;
import core.utils.FlightCartFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import models.FlightCard;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.aviakassa.selenide.HomePageAvSelenide;
import pages.aviakassa.selenide.SearchResultPageAvSelenide;
import pages.aviakassa.selenium.HomePageAv;
import pages.aviakassa.selenium.SearchResultPageAv;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Configuration.browser;


@ExtendWith(ScreenshotOnFailureExtension.class)
public class BaseTest {

    protected static HomePageAv homePageAv;
    protected static HomePageAvSelenide homePageAvSelenide;
    protected static SearchResultPageAv searchResultPageAv;
    protected static SearchResultPageAvSelenide searchResultPageAvSelenide;
    public static FlightCard flightCard = FlightCartFactory.createFlightCard();






    @BeforeAll
    public static void downloadDriver(){
        WebDriverManager.chromedriver().setup();
    }

    // Выполняется перед каждым тестом
@BeforeEach
public void setUp(){
    DriverManager.initDriver();
    homePageAv = new HomePageAv();
    homePageAvSelenide = new HomePageAvSelenide();
    searchResultPageAv = new SearchResultPageAv();
    searchResultPageAvSelenide = new SearchResultPageAvSelenide();
}

    // Выполняется после каждого теста
@AfterEach
    public void tearDown(){
    DriverManager.quitDriver();
}


    // добавляет текст в Allure отчет
    protected void attachText(String name, String content) {
        Allure.addAttachment(name, content);
    }
}
