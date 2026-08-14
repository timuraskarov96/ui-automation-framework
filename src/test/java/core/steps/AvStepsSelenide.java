package core.steps;

import core.base.BaseTest;
import core.utils.FlightCartFactory;
import io.qameta.allure.Step;
import models.FlightCard;
import pages.aviakassa.selenide.SearchResultPageAvSelenide;

import static core.extensions.ScreenshotOnSteps.screenshot;
import static org.assertj.core.api.Assertions.assertThat;

public class AvStepsSelenide {

    protected static SearchResultPageAvSelenide searchResultPageAvSelenide = new SearchResultPageAvSelenide();
    public static FlightCard flightCard = FlightCartFactory.createFlightCard();

    @Step("Проверка открытия странциы поиска билетов")
    public  AvStepsSelenide checkOpenSearchPage(){
        assertThat(searchResultPageAvSelenide.isSearchResultPageOpened())
                .isTrue()
                .as("Страница результатов поиска не открылась");
        screenshot();
        return this;
    }

    @Step("Проверка отображения первой карточки билета")
    public  AvStepsSelenide checkFirstCardDisplayed(){
        assertThat(searchResultPageAvSelenide.getCards())
                .isGreaterThan(0)
                .as("Поиск не вернул ни одного билета");
        screenshot();
        return this;
    }

    @Step("Проверка наименования авиакомпании отправления в первой карточки билета")
    public  AvStepsSelenide checkAirlineNameFirstCard(){
        assertThat(searchResultPageAvSelenide.getFirstAirline())
                .isNotBlank()
                .as("Авиакомпания первого билета не отображается");
        screenshot();
        return this;
    }

    @Step("Проверка времени вылета в первой карточке билета")
    public  AvStepsSelenide checkDepartureTime(){
        assertThat(searchResultPageAvSelenide.getFirstDepartureTime())
                .matches("\\d{2}:\\d{2}")// регулярка "две цифры:две цифры" (17:15)
                .as("Время вылета первого билета не отображается");
        screenshot();
        return this;
    }

    @Step("Проверка даты вылета первого билета")
    public  AvStepsSelenide checkDepartureDate(){
        assertThat(searchResultPageAvSelenide.getFirstDepartureDate())
                .as("Дата вылета первого билета не отображается")
                .isNotBlank();
        screenshot();
        return this;
    }

    @Step("Проверка города отправления первого билета")
    public  AvStepsSelenide checkDeparturePlace(){
        assertThat(searchResultPageAvSelenide.getFirstDeparturePlace())
                .contains(flightCard.getDepartureCity())
                .as("Город отправления первого билета не отображается");
        screenshot();
        return this;
    }

    @Step("Проверка города прибывания первого билета")
    public  AvStepsSelenide checkArrivalPlace(){
        assertThat(searchResultPageAvSelenide.getFirstArrivalPlace())
                .contains(flightCard.getArrivalCity())
                .as("Город прибывания первого билета не отображается");
        screenshot();
        return this;
    }

    @Step("Провера что цена билета из первой карточки > 0")
    public  AvStepsSelenide checkFirstPrice(){
        assertThat(searchResultPageAvSelenide.getFirstPrice())
                .as("Цена первого билета должна быть больше 0")
                    .isGreaterThan(0);
        screenshot();
        return this;
    }
}
