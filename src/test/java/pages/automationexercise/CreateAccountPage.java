package pages.automationexercise;

import core.base.BasePage;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountPage extends BasePage {

                            // ЛОКАТОРЫ:

    private final By
            registerTittle = By.xpath("//b[contains(text(),'Enter Account Information')]");

    // RadioButton Mr
    private final By mrRadioButton = By.id("id_gender1");

    // RadioButton Mrs
    private final By mrsRadioButton = By.id("id_gender2");

    // Поле пароль
    private final By passwordField = By.id("password");

    // День Рождения
    private final By dayDropdown = By.id("days");

    // Месяц Рождения
    private final By monthDropdown = By.id("months");

    // Год Рождения
    private final By yearDropdown = By.id("years");

    // Подписка на новости
    private final By newsletterCheckbox = By.id("newsletter");

    // Получение специальных предложений
    private final By specialOffersCheckbox = By.id("optin");

    // Поле First Name
    private final By firstNameField = By.id("first_name");

    // Поле Last Name
    private final By lastNameField = By.id("last_name");

    // Поле Company
    private final By companyField = By.id("company");

    // Поле Address1
    private final By firstAddressField = By.id("address1");

    // Поле Address2
    private final By secondAddressField = By.id("address2");

    // Выпадающий список Country
    private final By countryDropdown = By.id("country");

    // Поле State
    private final By stateField = By.id("state");

    // Поле City
    private final By cityField = By.id("city");

    // Поле Zip Code
    private final By zipCodeField = By.id("zipcode");

    // Поле Mobile Number
    private final By mobileNumberField = By.id("mobile_number");

    // Кнопка Create Account
    private final By createAccountButton = By.cssSelector("[data-qa='create-account']");

                                // МЕТОДЫ:

    // Выбирает обращение
    public void selectTitle(String title) {
        if (title.equalsIgnoreCase("Mr")) {
            click(mrRadioButton);
        } else if (title.equalsIgnoreCase("Mrs")) {
            click(mrsRadioButton);
        } else throw new IllegalArgumentException("Unknown title: " + title);
    }

    // Ввод пароля
    public void enterPassword(String password) {
        writeText(passwordField, password);
    }

    // Выбирает день рождения
    public void selectDay(String day) {
        new Select(find(dayDropdown)).selectByVisibleText(day);
    }

    // Выбирает месяц рождения
    public void selectMonth(String month) {
        new Select(find(monthDropdown)).selectByVisibleText(month);
    }

    // Выбирает год рождения
    public void selectYear(String year) {
        new Select(find(yearDropdown)).selectByVisibleText(year);
    }

    // Подписка на новости
    public void subscribeNewsletter(boolean subscribe) {
        if (subscribe != find(newsletterCheckbox).isSelected()) {
            click(newsletterCheckbox);
        }
        // если чекбокс не установлен, а subscribe = true, то чекбокс установится
    }

    // Подписка на специальные предложения
    public void subscribeSpecialOffers(boolean subscribe) {

        if (subscribe != find(specialOffersCheckbox).isSelected()) {
            click(specialOffersCheckbox);
        }
    }

    // Вводит имя
    public void enterFirstName(String firstName) {
        writeText(firstNameField, firstName);
    }

    // Вводит фамилию
    public void enterLastName(String lastName) {
        writeText(lastNameField, lastName);
    }

    // Вводит компанию
    public void enterCompany(String company) {
        writeText(companyField, company);
    }

    // Вводит адрес1
    public void enterFirstAddress(String firstAddress) {
        writeText(firstAddressField, firstAddress);
    }

    // Вводит адрес2
    public void enterSecondAddress(String secondAddress) {
        writeText(secondAddressField, secondAddress);
    }

    // Выбирает страну
    public void selectCountry(String country){
        new Select(find(countryDropdown)).selectByVisibleText(country);
    }
    // Вводит штат
    public void enterState(String state) {
        writeText(stateField, state);
    }

    // Вводит город
    public void enterCity(String city) {
        writeText(cityField, city);
    }

    // Вводит индекс
    public void enterZipCode(String zipCode) {
        writeText(zipCodeField, zipCode);
    }

    // Вводит телефон
    public void enterMobileNumber(String mobileNumber) {
        writeText(mobileNumberField, mobileNumber);
    }

    // Нажимает Create Account
    public void clickCreateAccount() {
        click(createAccountButton);
    }

    public void register(User user){
        selectTitle(user.getTitle());
        enterPassword(user.getPassword());
        selectDay(user.getDay());
        selectMonth(user.getMonth());
        selectYear(user.getYear());
        subscribeNewsletter(user.isSubscribeNewsletter());
        subscribeSpecialOffers(user.isReceiveSpecialOffers());
        enterFirstName(user.getFirstName());
        enterLastName(user.getLastName());
        enterCompany(user.getCompany());
        enterFirstAddress(user.getFirstAddress());
        enterSecondAddress(user.getSecondAddress());
        selectCountry(user.getCountry());
        enterState(user.getState());
        enterCity(user.getCity());
        enterZipCode(user.getZipCode());
        enterMobileNumber(user.getMobileNumber());
        clickCreateAccount();
    }

    // Проверяет открытие страницы Register
    public boolean isCreateAccountPageOpened() {
        return isDisplayed(registerTittle);
    }
}
