package core.utils;

import java.util.UUID;

// Генератор тестовых данных
public class TestDataGenerator {

    // Генерирует уникальный email
    public static String generateEmail(){
        return "user" + UUID.randomUUID() + "@mail.com";
    }

    // UUID.randomUUID() - Создает случайную уникальную строку.

    // Генерирует имя пользователя
    public static String generateName() {
        return "Bob";
    }

}
