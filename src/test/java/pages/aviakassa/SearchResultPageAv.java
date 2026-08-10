package pages.aviakassa;

import core.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.PublicKey;
import java.time.Duration;
import java.util.List;

// Страница результатов поиска авиабилетов
public class SearchResultPageAv extends BasePage {

                             // ЛОКАТОРЫ

    // Все карточки найденных билетов
    private final By cards =
            By.cssSelector("[data-id='avia.results.recommendation']");

    // Авиакомпания карточек билета
    private final By airline =
            By.cssSelector("[data-id='top-header.flight_info.segment.carrier-title']");

    // Время вылета
    private final By departureTime =
            By.cssSelector("[data-id='top-header.flight_info.segment_departure_time']");

    // Дата вылета
    private final By departureDate =
            By.cssSelector("[data-id='top-header.flight_info.segment_departure_date']");

    // Город отправления
    private final By departurePlace =
                By.xpath("//span[@data-id='top-header.flight_info.segment_departure.place']");

    // Город прибывания
    private final By arrivalPlace =
            By.xpath("//span[@data-id='top-header.flight_info.segment_arrival.place']");

    // Цена билета в карточке билета
    private final By price =
            By.xpath("//span[@data-id='avia_tariff_card.price']");



                             // МЕТОДЫ

    // Возвращает количество найденных билетов
    public int getCards(){

        List<WebElement> def = driver.findElements(cards);

        int abc =  def.size();
        return abc;
    }

    // Проверяет, что страница результатов поиска открылась
    public boolean isSearchResultPageOpened(){
        return getCards() > 0;
    }

    // Получаем элемент первой карточки билета
    public WebElement getFirstCard(){
        return findElements(cards).get(0);
    }

    // Возвращает авиакомпанию первого билета
    public String getFirstAirline(){
        return getFirstCard().findElement(airline).getText();
    }

    // Возвращает время вылета первого билета
    public String getFirstDepartureTime() {
        return getFirstCard().findElement(departureTime).getText();
    }

    // Возвращает дату вылета первого билета
    public String getFirstDepartureDate() {
        return getFirstCard().findElement(departureDate).getText();
    }

    // Возвращает город отправления первого билета
    public String getFirstDeparturePlace() {
        return getFirstCard().findElement(departurePlace).getText();
    }

    // Возвращает город прибывания первого билета
    public String getFirstArrivalPlace() {
        return getFirstCard().findElement(arrivalPlace).getText();
    }

    // Возвращает цену первой карточки билета
    public int getFirstPrice(){
        return Integer.parseInt(getFirstCard().findElement(price).getText().replaceAll(" ", ""));
    }



    // Ожилаем появления карточек билета на странице
    public void waitForSearchResults(){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver -> !findElements(cards).isEmpty()); // проверяет что список карточек не пустой
    }

}
