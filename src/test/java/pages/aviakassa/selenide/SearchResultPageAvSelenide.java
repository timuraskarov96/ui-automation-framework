package pages.aviakassa.selenide;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$$x;

// Страница результатов поиска авиабилетов
public class SearchResultPageAvSelenide extends BasePage {

                             // ЛОКАТОРЫ

    // Все карточки найденных билетов
    private final ElementsCollection cards =
            $$x("//div[@data-id='avia.results.recommendation']");

    // Авиакомпания карточек билета
    private final ElementsCollection airline =
            $$x("//span[@data-id='top-header.flight_info.segment.carrier-title']");

    // Время вылета
    private final ElementsCollection departureTime =
            $$x("//span[@data-id='top-header.flight_info.segment_departure_time']");

    // Дата вылета
    private final ElementsCollection departureDate =
            $$x("//span[@data-id='top-header.flight_info.segment_departure_date']");

    // Город отправления
    private final ElementsCollection departurePlace =
            $$x("//span[@data-id='top-header.flight_info.segment_departure.place']");

    // Город прибывания
    private final ElementsCollection arrivalPlace =
            $$x("//span[@data-id='top-header.flight_info.segment_arrival.place']");

    // Цена билета в карточке билета
    private final ElementsCollection price =
            $$x("//span[@data-id='avia_tariff_card.price']");



                             // МЕТОДЫ

    // Возвращает количество найденных билетов
    public int getCards(){
        return cards.size();
    }

    // Проверяет, что страница результатов поиска открылась
    public boolean isSearchResultPageOpened(){
        return getCards() > 0;
    }

    // Получаем элемент первой карточки билета
    public SelenideElement getFirstCard(){
        return cards.first();
    }

    // Возвращает авиакомпанию первого билета
    public String getFirstAirline(){
        return airline.first().getText();
    }

    // Возвращает время вылета первого билета
    public String getFirstDepartureTime() {
        return departureTime.first().getText();
    }

    // Возвращает дату вылета первого билета
    public String getFirstDepartureDate() {
        return departureDate.first().getText();
    }

    // Возвращает город отправления первого билета
    public String getFirstDeparturePlace() {
        return departurePlace.first().getText();
    }

    // Возвращает город прибывания первого билета
    public String getFirstArrivalPlace() {
        return arrivalPlace.first().getText();
    }

    // Возвращает цену первой карточки билета
    public int getFirstPrice(){
        return Integer.parseInt(price.first().getText().replaceAll(" ", ""));
    }



    // Ожидаем появления карточек билета на странице
    public void waitForSearchResultsS(){
        cards.shouldHave(sizeGreaterThan(0));
    }
}
