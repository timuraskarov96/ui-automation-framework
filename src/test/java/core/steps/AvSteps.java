package core.steps;

import core.base.BaseTest;
import io.qameta.allure.Step;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static core.extensions.ScreenshotOnSteps.screenshot;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.PATH;

public class AvSteps extends BaseTest {


    @Step("Проверка открытия странциы поиска билетов")
    public static void checkOpenSearchPage(){
        assertThat(searchResultPageAv.isSearchResultPageOpened())
                .isTrue()
                .as("Страница результатов поиска не открылась");
        screenshot();
    }

    @Step("Проверка отображения первой карточки билета")
    public static void checkFirstCardDisplayed(){
        assertThat(searchResultPageAv.getCards())
                .isGreaterThan(0)
                .as("Поиск не вернул ни одного билета");
        screenshot();
    }

    @Step("Проверка наименования авиакомпании отправления в первой карточки билета")
    public static void checkAirlineNameFirstCard(){
        assertThat(searchResultPageAv.getFirstAirline())
                .isNotBlank()
                .as("Авиакомпания первого билета не отображается");
        screenshot();
    }

    @Step("Проверка времени вылета в первой карточке билета")
    public static void checkDepartureTime(){
        assertThat(searchResultPageAv.getFirstDepartureTime())
                .matches("\\d{2}:\\d{2}")// регулярка "две цифры:две цифры" (17:15)
                .as("Время вылета первого билета не отображается");
        screenshot();
    }

    @Step("Проверка даты вылета первого билета")
    public static void checkDepartureDate(){
        assertThat(searchResultPageAv.getFirstDepartureDate())
                .as("Дата вылета первого билета не отображается")
                .isNotBlank();
        screenshot();
    }

    @Step("Проверка города отправления первого билета")
    public static void checkDeparturePlace(){
        assertThat(searchResultPageAv.getFirstDeparturePlace())
                .contains(flightCard.getDepartureCity())
                .as("Город отправления первого билета не отображается");
        screenshot();
    }

    @Step("Проверка города прибывания первого билета")
    public static void checkArrivalPlace(){
        assertThat(searchResultPageAv.getFirstArrivalPlace())
                .contains(flightCard.getArrivalCity())
                .as("Город прибывания первого билета не отображается");
        screenshot();
    }

    @Step("Провера что цена билета из первой карточки > 0")
    public static void checkFirstPrice(){
        assertThat(searchResultPageAv.getFirstPrice())
                .as("Цена первого билета должна быть больше 0")
                    .isGreaterThan(1000000);
        screenshot();
    }
}
