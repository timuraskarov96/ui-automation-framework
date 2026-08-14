package core.base;

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
import pages.aviakassa.selenide.HomePageAvSelenide;
import pages.aviakassa.selenide.SearchResultPageAvSelenide;
import pages.aviakassa.selenium.HomePageAv;
import pages.aviakassa.selenium.SearchResultPageAv;


@ExtendWith(ScreenshotOnFailureExtension.class)
public class BaseTest {

    protected static HomePageAv homePageAv;
    protected static HomePageAvSelenide homePageAvSelenide;
    protected static SearchResultPageAv searchResultPageAv;
    protected static SearchResultPageAvSelenide searchResultPageAvSelenide;
    public static FlightCard flightCard = FlightCartFactory.createFlightCard();
    public AvStepsSelenide avStepsSelenide = new AvStepsSelenide();


    @BeforeAll
    public static void downloadDriver(){
        WebDriverManager.chromedriver().setup();
        // Настраивает подходящий ChromeDriver и настраивает окружение так, чтобы Selenium мог его запустить.
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
