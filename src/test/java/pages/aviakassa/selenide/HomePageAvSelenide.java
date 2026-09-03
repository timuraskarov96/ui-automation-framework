package pages.aviakassa.selenide;


import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;
import models.FlightCard;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.LocalDate;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static core.config.ConfigReader.getUrlAviakassa;
import static core.extensions.ScreenshotOnSteps.screenshot;

// Главная страница Aviakassa
public class HomePageAvSelenide extends BasePage {
;
                        // ЛОКАТОРЫ

    // Поле даты Туда
    private final SelenideElement departureDateField =
            $x("//div[@data-id='top-header.avia.search-form.segment.calendar-from']");

    // Поле даты Обратно
    private final SelenideElement returnDateField =
            $x("//div[@data-id='top-header.avia.search-form.segment.calendar-to']");

    // Заголовок открытого календаря
    private final SelenideElement calendarHeader =
            $("//span[contains(text(),'Выберите дату')]");

    // Поле города Откуда
    private final SelenideElement departureCityField =
            $("[data-id='top-header.avia.search-form.segment.departure-input-native_input']");

    // Поле города Куда
    private final SelenideElement arrivalCityField =
            $("[data-id='top-header.avia.search-form.segment.arrival-input-native_input']");

    // Выбор города Туда и Обратно
    private SelenideElement getCityLocator(String city){
        return $(byXpath(String.format("//span[contains(@class, '_1y3rdmrh') and contains(text(), '%s')]", city)));
    }

    // Получение даты в календаре
    private SelenideElement getDayLocator(LocalDate date){
//        return By.cssSelector(String.format("td[data-day='%s'] button", date));
        return $(byXpath(String.format("//td[@data-day='%s']", date)));
    }

    // Кнопка "Поиск"
    private SelenideElement searchButton =
            $("[data-id='top-header.avia.search-form.segment.submit-button']");

                     // МЕТОДЫ

    @Step("Открыть главную страницу Aviakassa")
    public void openHomePageS(){
        Selenide.open(getUrlAviakassa());
    }

    @Step("Открываем календарь \"Дата туда\"")
    public void openDepartureCalendarS(){
        $(departureDateField)
                .shouldBe(visible)
                .click();
    }

    @Step("Открываем календарь \"Дата обратно\"")
    public void openReturnCalendarS() {
        $(returnDateField)
                .shouldBe(visible)
                .click();
    }

    @Step("Выбираем дату \"Туда\"")
    public void selectDepartureDateS(int year, int month, int day){
        openDepartureCalendarS();
        LocalDate date = LocalDate.of(year, month, day);
        $(getDayLocator(date))
                .shouldBe(visible)
                .click();
    }

    @Step("Выбираем дату \"Обратно\"")
    public void selectReturnDateS(int year, int month, int day){
        openReturnCalendarS();
        LocalDate date = LocalDate.of(year, month, day);
        $(getDayLocator(date))
                .shouldBe(visible)
                .click();
    }

    @Step("Указываем город отправления")
    public void enterDepartureCityS(String city){
        $(departureCityField).shouldBe(visible).clear();
        $(departureCityField).sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
        $(departureCityField).setValue(city);
        $(getCityLocator(city)).shouldBe(visible).click();
    }

    @Step("Указываем город прибытия")
    public void enterArrivalCityS(String city){
        $(arrivalCityField).shouldBe(visible).clear();
        $(arrivalCityField).sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
        $(arrivalCityField).setValue(city);
        $(getCityLocator(city)).shouldBe(visible).click();
    }

    @Step("Нажатие кнопки \"Поиск\"")
    public void clickSearchButtonS(){
        $(searchButton).shouldBe(visible).click();
    }

    @Step("Выполнить поиск {flightCard}")
    public void searchFlightS(FlightCard flightCard){
        enterDepartureCityS(flightCard.getDepartureCity());
        enterArrivalCityS(flightCard.getArrivalCity());
        selectDepartureDateS(flightCard.getDepartureYear(), flightCard.getDepartureMonth(), flightCard.getDepartureDay());
        selectReturnDateS(flightCard.getReturnYear(), flightCard.getReturnMonth(), flightCard.getReturnDay());
        clickSearchButtonS();
        switchToNewTabSelenide();
    }
}
