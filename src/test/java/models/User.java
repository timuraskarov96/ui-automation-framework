package models;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
// Модель пользователя
public class User {

    // Обращение
    private String title;

    // Имя
    private String firstName;

    // Фамилия
    private String lastName;

    // Email
    private String email;

    // Пароль
    private String password;

    // День рождения
    private String day;

    // Месяц рождения
    private String month;

    // Год рождения
    private String year;

    // Компания
    private String company;

    // Адрес
    private String firstAddress;

    // Адрес
    private String secondAddress;

    // Страна
    private String country;

    // Штат
    private String state;

    // Город
    private String city;

    // Индекс
    private String zipCode;

    // Телефон
    private String mobileNumber;

    // Подписка на новости
    private boolean subscribeNewsletter;

    // Подписка на специальные предложения
    private boolean receiveSpecialOffers;

}
