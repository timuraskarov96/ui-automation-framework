# UI Automation Framework

Учебный проект по автоматизации UI-тестирования на Java.

Проект создан для практического изучения Selenium WebDriver, построения собственного UI Automation Framework и применения Page Object Pattern, JUnit 5, AssertJ и Allure.

В проекте автоматизируются два учебных веб-приложения:

* **AutomationExercise** — изучение Page Object Pattern и базовых UI-сценариев.
* **Aviakassa** — автоматизация поиска авиабилетов и проверки результатов поиска.

---

## 📌 О проекте

Основная цель проекта — получить практический опыт разработки собственного UI Automation Framework, а не просто написать набор отдельных автотестов.

В рамках проекта изучаются:

* Java;
* Selenium WebDriver;
* JUnit 5;
* Gradle;
* AssertJ;
* WebDriverManager;
* Allure;
* Page Object Pattern;
* Explicit Wait;
* работа с несколькими вкладками браузера;
* CSS Selectors и XPath;
* работа с динамическими элементами;
* JUnit Extensions;
* создание screenshots;
* attachments в Allure.

---

## Технологический стек

| Технология             | Назначение                                |
| ---------------------- | ----------------------------------------- |
| **Java**               | Основной язык программирования            |
| **Gradle**             | Сборка проекта и управление зависимостями |
| **Selenium WebDriver** | Автоматизация браузера                    |
| **JUnit 5**            | Написание и запуск автотестов             |
| **AssertJ**            | Проверки и assertions                     |
| **WebDriverManager**   | Управление WebDriver                      |
| **Allure**             | Формирование тестовых отчётов             |
| **Lombok**             | Уменьшение количества boilerplate-кода    |

---

## Архитектура Framework

В проекте используется **Page Object Pattern**.

Архитектура разделяет:

* базовые компоненты Framework;
* управление WebDriver;
* конфигурацию;
* Page Objects;
* бизнес-действия;
* тесты;
* модели данных;
* вспомогательные классы;
* Allure / JUnit Extensions.

### BasePage

`BasePage` — базовый класс для Page Objects.

Содержит общие методы взаимодействия с элементами Selenium:

* поиск элементов;
* `click`;
* ввод текста;
* получение текста;
* ожидания;
* работа с WebElement.

### BaseTest

`BaseTest` — базовый класс для автотестов.

Используется для общей настройки тестовой среды и работы с Page Objects.

### ConfigReader

`ConfigReader` отвечает за чтение параметров из конфигурационного файла.

### DriverManager

`DriverManager` отвечает за настройку и получение WebDriver.

### Steps

В проекте используется отдельный слой `steps` для группировки бизнес-действий.

На данный момент реализован:

* `AvSteps` — действия, связанные с автоматизацией Aviakassa.

### Extensions

В проекте используются JUnit Extensions для работы с Allure.

Реализованы:

* `ScreenshotOnFailureExtension` — создание screenshot при падении теста;
* `ScreenshotOnSteps` — работа со screenshots отдельных шагов.

### Models

В `models` находятся модели данных, используемые в тестах.

На данный момент:

* `FlightCard` — модель данных авиабилета;
* `User` — модель пользователя.

### Pages

Page Objects разделены по тестируемым приложениям.

Для **AutomationExercise**:

* `HomePage`;
* `LoginPage`;
* `SignupPage`;
* `AccountPage`;
* `AccountCreatedPage`;
* `CreateAccountPage`.

Для **Aviakassa**:

* `HomePageAv`;
* `SearchResultPageAv`.

---

## 📁 Структура проекта

Актуальная структура проекта:

```text
UIFrameWorkProject/
│
├── src/
│   │
│   ├── test/
│   │   │
│   │   ├── java/
│   │   │   │
│   │   │   ├── core/
│   │   │   │   │
│   │   │   │   ├── base/
│   │   │   │   │   ├── BasePage.java
│   │   │   │   │   └── BaseTest.java
│   │   │   │   │
│   │   │   │   ├── config/
│   │   │   │   │   └── ConfigReader.java
│   │   │   │   │
│   │   │   │   ├── driver/
│   │   │   │   │   └── DriverManager.java
│   │   │   │   │
│   │   │   │   ├── extensions/
│   │   │   │   │   ├── ScreenshotOnFailureExtension.java
│   │   │   │   │   └── ScreenshotOnSteps.java
│   │   │   │   │
│   │   │   │   ├── steps/
│   │   │   │   │   └── AvSteps.java
│   │   │   │   │
│   │   │   │   ├── tests/
│   │   │   │   │   │
│   │   │   │   │   ├── automationexercise/
│   │   │   │   │   │   ├── HomePageTest.java
│   │   │   │   │   │   ├── LoginTest.java
│   │   │   │   │   │   ├── LogoutTest.java
│   │   │   │   │   │   └── RegistrationTest.java
│   │   │   │   │   │
│   │   │   │   │   └── aviakassa/
│   │   │   │   │       └── AviakassaSearchTest.java
│   │   │   │   │
│   │   │   │   └── utils/
│   │   │   │
│   │   │   ├── models/
│   │   │   │   ├── FlightCard.java
│   │   │   │   └── User.java
│   │   │   │
│   │   │   └── pages/
│   │   │       │
│   │   │       ├── automationexercise/
│   │   │       │   ├── AccountCreatedPage.java
│   │   │       │   ├── AccountPage.java
│   │   │       │   ├── CreateAccountPage.java
│   │   │       │   ├── HomePage.java
│   │   │       │   ├── LoginPage.java
│   │   │       │   └── SignupPage.java
│   │   │       │
│   │   │       └── aviakassa/
│   │   │           ├── HomePageAv.java
│   │   │           └── SearchResultPageAv.java
│   │   │
│   │   └── resources/
│   │
│   └── resources/
│       └── config.properties
│
├── build.gradle
├── settings.gradle
├── gradlew
├── gradlew.bat
├── README.md
└── .gitignore
```

---

## 🧪 Автотесты

### AutomationExercise

На AutomationExercise реализованы Page Objects и базовые UI-тесты.

#### Авторизация

* успешный вход;
* неверный пароль;
* Logout.

#### Регистрация

* создание аккаунта;
* проверка успешной регистрации.

#### Дополнительные сценарии

По мере развития проекта тестовое покрытие AutomationExercise будет расширяться.

---

### Aviakassa

Для Aviakassa реализирована автоматизация поиска авиабилетов и проверки страницы результатов.

Основной сценарий:

1. Открытие главной страницы Aviakassa.
2. Выбор города отправления.
3. Выбор города назначения.
4. Выбор даты вылета.
5. Выбор даты возвращения.
6. Запуск поиска.
7. Ожидание загрузки результатов.
8. Проверка найденных билетов.

Проверяется:

* открытие страницы результатов;
* наличие хотя бы одного билета;
* авиакомпания первого билета;
* время вылета;
* дата вылета;
* город отправления;
* город назначения;
* цена билета.

---

## 📊 Allure Report

В проект интегрирован **Allure Report**.

Для улучшения информативности отчётов используются:

* `@Step`;
* attachments;
* Скриншоты при падении теста, а аткже отдельных шагов;

Пример структуры Allure-отчёта:

```text
shouldSearchFlights
│
├── Открыть главную страницу Aviakassa
│
├── Выполнить поиск FlightCard(...)
│
├── Проверка открытия страницы поиска билетов
│
├── Проверка отображения первой карточки билета
│
├── Проверка авиакомпании
│
├── Проверка времени вылета
│
├── Проверка даты вылета
│
├── Проверка города отправления
│
├── Проверка города назначения
│
└── Проверка цены билета
```

При падении теста к отчёту прикрепляется screenshot состояния браузера.

---

## 🚀 Запуск проекта

### Клонирование проекта

```bash
git clone <repository-url>
```

Перейти в директорию проекта:

```bash
cd UIFrameWorkProject
```

### Запуск всех тестов

Windows:

```bash
gradlew test
```

Linux / macOS:

```bash
./gradlew test
```

---

## 📋 Запуск отдельного теста

Например, запуск тестов Aviakassa:

```bash
gradlew test --tests "core.tests.aviakassa.AviakassaSearchTest"
```

---


