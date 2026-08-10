package core.base;

import core.driver.DriverManager;
import core.extensions.ScreenshotOnFailureExtension;
import core.utils.FlightCartFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import models.FlightCard;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.aviakassa.HomePageAv;
import pages.aviakassa.SearchResultPageAv;


@ExtendWith(ScreenshotOnFailureExtension.class)
public class BaseTest {

    protected static HomePageAv homePageAv;
    protected static SearchResultPageAv searchResultPageAv;
    public static FlightCard flightCard = FlightCartFactory.createFlightCard();


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
    searchResultPageAv = new SearchResultPageAv();
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
