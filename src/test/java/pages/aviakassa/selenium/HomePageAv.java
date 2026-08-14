package pages.aviakassa.selenium;


import core.base.BasePage;
import io.qameta.allure.Step;
import models.FlightCard;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.LocalDate;

import static core.config.ConfigReader.getUrlAviakassa;
import static core.extensions.ScreenshotOnSteps.screenshot;

// Главная страница Aviakassa
public class HomePageAv extends BasePage {
;
                        // ЛОКАТОРЫ

    // Поле даты Туда
    private final By departureDateField =
            By.xpath("//div[@data-id='top-header.avia.search-form.segment.calendar-from']");

    // Поле даты Обратно
    private final By returnDateField =
            By.xpath("//div[@data-id='top-header.avia.search-form.segment.calendar-to']");

    // Заголовок открытого календаря
    private final By calendarHeader =
            By.xpath("//span[contains(text(),'Выберите дату')]");

    // Поле города Откуда
    private final By departureCityField =
            By.cssSelector("[data-id='top-header.avia.search-form.segment.departure-input-native_input']");

    // Поле города Куда
    private final By arrivalCityField =
            By.cssSelector("[data-id='top-header.avia.search-form.segment.arrival-input-native_input']");

    // Выбор города Туда и Обратно
    private By getCityLocator(String city){
        return By.xpath(String.format(
                "//span[contains(@class, '_1y3rdmrh') and contains(text(), '%s')]",
                city));
    }

    // Получение даты в календаре
    private By getDayLocator(LocalDate date){
//        return By.cssSelector(String.format("td[data-day='%s'] button", date));
        return By.xpath(String.format("//td[@data-day='%s']", date));
    }

    // Кнопка "Поиск"
    private By searchButton =
            By.cssSelector("[data-id='top-header.avia.search-form.segment.submit-button']");

                     // МЕТОДЫ


    @Step("Открыть главную страницу Aviakassa")
    public void openHomePage(){
        open(getUrlAviakassa());
        screenshot();
    }

    @Step("Открываем календарь \"Дата туда\"")
    public void openDepartureCalendar(){
        click(departureDateField);
        screenshot();

    }

    @Step("Открываем календарь \"Дата обратно\"")
    public void openReturnCalendar() {
        click(returnDateField);
        screenshot();
    }

    @Step("Выбираем дату \"Туда\"")
    public void selectDepartureDate(int year, int month, int day){
        openDepartureCalendar();
        LocalDate date = LocalDate.of(year, month, day);
        click(getDayLocator(date));
        screenshot();
    }

    @Step("Выбираем дату \"Обратно\"")
    public void selectReturnDate(int year, int month, int day){
        openReturnCalendar();
        LocalDate date = LocalDate.of(year, month, day);
        click(getDayLocator(date));
        screenshot();
    }

    @Step("Указываем город отправления")
    public void enterDepartureCity(String city){
        click(departureCityField);
        clearTextFieldFull(departureCityField);
        writeText(departureCityField, city);
        wait.until(ExpectedConditions.visibilityOfElementLocated(getCityLocator(city))); // Ожидание появление элемента с городом из списка
        click(getCityLocator(city));
    }

    @Step("Указываем город прибытия")
    public void enterArrivalCity(String city){
        click(arrivalCityField);
        clearTextFieldFull(arrivalCityField);
        writeText(arrivalCityField, city);
        click(getCityLocator(city));
    }

    @Step("Нажатие кнопки \"Поиск\"")
    public void clickSearchButton(){
        click(searchButton);
        screenshot();
    }

    @Step("Выполнить поиск {flightCard}")
    public void searchFlight(FlightCard flightCard) throws InterruptedException{
        enterDepartureCity(flightCard.getDepartureCity());
        enterArrivalCity(flightCard.getArrivalCity());
        selectDepartureDate(flightCard.getDepartureYear(), flightCard.getDepartureMonth(), flightCard.getDepartureDay());
        selectReturnDate(flightCard.getReturnYear(), flightCard.getReturnMonth(), flightCard.getReturnDay());
        clickSearchButton();
        switchToNewTab();
        Thread.sleep(5000);
    }
}
