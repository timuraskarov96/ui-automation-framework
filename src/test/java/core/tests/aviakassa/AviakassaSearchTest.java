package core.tests.aviakassa;

import core.base.BaseTest;
import core.driver.DriverManager;
import core.steps.AvStepsSelenide;
import core.utils.FlightCartFactory;
import io.qameta.allure.Attachment;
import lombok.Builder;
import models.FlightCard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static core.driver.DriverManager.driver;
import static core.steps.AvSteps.*;
import static org.assertj.core.api.Assertions.assertThat;


public class AviakassaSearchTest extends BaseTest {

    @Test
    public void shouldSearchFlights() throws InterruptedException{

//        SELENIUM TEST:
        homePageAv.openHomePage();
        homePageAv.searchFlight(flightCard);

        attachText("URL страницы результатов", driver.getCurrentUrl());
        attachText("Количество найденных билетов", String.valueOf(searchResultPageAv.getCards()));

        checkOpenSearchPage();
        checkFirstCardDisplayed();
        checkAirlineNameFirstCard();
        checkDepartureTime();
        checkDepartureDate();
        checkDeparturePlace();
        checkArrivalPlace();
        checkFirstPrice();


//        SELENIDE TEST:
//        homePageAvSelenide.openHomePageS();
//        homePageAvSelenide.searchFlightS(flightCard);
//        searchResultPageAvSelenide.waitForSearchResultsS();
//
//        avStepsSelenide.
//        checkOpenSearchPage()
//                .checkFirstCardDisplayed()
//                .checkAirlineNameFirstCard()
//                .checkDepartureTime()
//                .checkDepartureDate()
//                .checkDeparturePlace()
//                .checkArrivalPlace()
//                .checkFirstPrice();
    }
}