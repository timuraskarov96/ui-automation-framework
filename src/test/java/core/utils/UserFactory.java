package core.utils;

import models.User;

// Фабрика создания пользователей
public class UserFactory {

    // Создает пользователя с тестовыми данными
    public static User createRandomUser(){
        return User.builder()
                .title("Mr")
                .firstName(TestDataGenerator.generateName())
                .lastName("Smith")
                .email(TestDataGenerator.generateEmail())
                .password("Password123")
                .day("10")
                .month("May")
                .year("1996")
                .company("QA Automation")
                .firstAddress("Central")
                .secondAddress("New")
                .country("India")
                .state("Samarskaya Oblast")
                .city("Samara")
                .zipCode("443099")
                .mobileNumber("79991234567")
                .subscribeNewsletter(true)
                .receiveSpecialOffers(true)
                .build();
    }
}
