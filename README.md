# UI Automation Framework

Учебный проект по автоматизации UI-тестирования на Java.

Проект создан для практического изучения **Selenium WebDriver**, **Selenide**, построения собственного UI Automation Framework и применения **Page Object Pattern**, **JUnit 5**, **AssertJ** и **Allure**.

В проекте автоматизируются два учебных веб-приложения:

* **AutomationExercise** — изучение Page Object Pattern и базовых UI-сценариев.
* **Aviakassa** — автоматизация поиска авиабилетов и проверки результатов поиска.

Для Aviakassa реализованы две версии Page Objects:

* Selenium WebDriver;
* Selenide.

Это позволяет на практике сравнить подходы Selenium и Selenide и увидеть, как Selenide упрощает работу с элементами, ожиданиями и браузером.

---

## О проекте

Основная цель проекта — получить практический опыт разработки собственного UI Automation Framework, а не просто написать набор отдельных автотестов.

В рамках проекта изучаются:

* Java;
* Selenium WebDriver;
* Selenide;
* JUnit 5;
* Gradle;
* AssertJ;
* WebDriverManager;
* Allure;
* Lombok;
* Page Object Pattern;
* Explicit Wait;
* автоматические ожидания Selenide;
* работа с несколькими вкладками браузера;
* CSS Selectors и XPath;
* работа с динамическими элементами;
* JUnit Extensions;
* создание screenshots;
* attachments в Allure;
* организация бизнес-действий через Steps;
* сравнение Selenium и Selenide.

---

## Технологический стек

| Технология             | Назначение                                      |
| ---------------------- | ----------------------------------------------- |
| **Java**               | Основной язык программирования                  |
| **Gradle**             | Сборка проекта и управление зависимостями       |
| **Selenium WebDriver** | Автоматизация браузера                          |
| **Selenide**           | Упрощённая автоматизация браузера и работа с UI |
| **JUnit 5**            | Написание и запуск автотестов                   |
| **AssertJ**            | Проверки и assertions                           |
| **WebDriverManager**   | Управление WebDriver                            |
| **Allure**             | Формирование тестовых отчётов                   |
| **Lombok**             | Уменьшение количества boilerplate-кода          |

---

# Архитектура Framework

В проекте используется **Page Object Pattern**.

Архитектура разделяет:

* базовые компоненты Framework;
* управление WebDriver;
* конфигурацию;
* Page Objects;
* тесты;
* модели данных;
* вспомогательные классы;
* Allure 
---

## BasePage

`BasePage` — базовый класс для Selenium Page Objects.

Содержит общие методы взаимодействия с элементами Selenium:

* поиск элементов;
* `click`;
* ввод текста;
* получение текста;
* ожидания;
* работа с `WebElement`;
* работа с несколькими вкладками браузера.

Selenide Page Objects на текущем этапе используют возможности самого Selenide и постепенно избавляются от низкоуровневого управления WebDriver.

---

## BaseTest

`BaseTest` — базовый класс для автотестов.

Используется для:

* общей настройки тестовой среды;
* инициализации Page Objects;
* управления жизненным циклом тестов;
* подключения общих расширений Framework.

---

## ConfigReader

`ConfigReader` отвечает за чтение параметров из конфигурационного файла `config.properties`.

Конфигурация используется для хранения URL и других параметров проекта.

---

## DriverManager

`DriverManager` отвечает за настройку и получение WebDriver.

На текущем этапе Selenium используется как основа существующего Framework, а Selenide применяется для отдельной реализации UI-автоматизации Aviakassa.

---

# Steps

В проекте используется отдельный слой `steps` для группировки бизнес-действий.

Реализованы:

* `AvSteps` — бизнес-действия для Selenium-версии Aviakassa;
* `AvStepsSelenide` — бизнес-действия для Selenide-версии Aviakassa.

Использование Steps позволяет отделить последовательность действий пользователя от технической реализации Page Objects.

---

# Extensions

В проекте используются JUnit Extensions для работы с Allure и screenshots.

Реализованы:

* `ScreenshotOnFailureExtension` — создание screenshot при падении теста;
* `ScreenshotOnSteps` — создание screenshots отдельных шагов.

Screenshots и текстовые attachments используются для повышения информативности Allure Report.

---

# Models

В `models` находятся модели данных, используемые в тестах.

На данный момент:

* `FlightCard` — модель данных авиабилета;
* `User` — модель пользователя.

Например, `FlightCard` используется для передачи параметров поиска авиабилетов:

* город отправления;
* город назначения;
* дата вылета;
* дата возвращения.

---

# Page Objects

Page Objects разделены по тестируемым приложениям.

## AutomationExercise

Для AutomationExercise реализованы:

* `HomePage`;
* `LoginPage`;
* `SignupPage`;
* `AccountPage`;
* `AccountCreatedPage`;
* `CreateAccountPage`.

Все эти Page Objects на текущем этапе реализованы с использованием Selenium WebDriver.

---

## Aviakassa — Selenium

Для Selenium-версии Aviakassa реализованы:

* `HomePageAv`;
* `SearchResultPageAv`.

Эти классы используют Selenium WebDriver, `By`, `WebElement`, ожидания и другие стандартные возможности Selenium.

---

## Aviakassa — Selenide

Для Selenide-версии Aviakassa реализованы:

* `HomePageAvSelenide`;
* `SearchResultPageAvSelenide`.

Selenide-версия использует:

* `SelenideElement`;
* `ElementsCollection`;
* `$`;
* `$$`;
* `shouldBe()`;
* `shouldHave()`;
* встроенные ожидания Selenide;
* упрощённую работу с вкладками браузера.

Selenide-реализация создаётся как отдельная версия Page Objects, чтобы не ломать уже работающий Selenium Framework и одновременно сравнивать оба подхода.

---

# Структура проекта


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
│   │   │   │   │   ├── AvSteps.java
│   │   │   │   │   └── AvStepsSelenide.java
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
│   │   │           │
│   │   │           ├── selenide/
│   │   │           │   ├── HomePageAvSelenide.java
│   │   │           │   └── SearchResultPageAvSelenide.java
│   │   │           │
│   │   │           └── selenium/
│   │   │               ├── HomePageAv.java
│   │   │               └── SearchResultPageAv.java
│   │   │
│   │   └── resources/
│   │
│   └── resources/
│       └── config.properties
│
├── build.gradle
├── settings.gradle
├── gradle/
├── gradlew
├── gradlew.bat
├── README.md
└── .gitignore
```

---

# Автотесты

## AutomationExercise

На AutomationExercise реализованы Page Objects и базовые UI-тесты.

### Авторизация

* успешный вход;
* неверный пароль;
* Logout.

### Регистрация

* создание аккаунта;
* проверка успешной регистрации.

По мере развития проекта тестовое покрытие AutomationExercise может расширяться.

---

# Aviakassa

Для Aviakassa реализована автоматизация поиска авиабилетов и проверки страницы результатов.

На текущем этапе существует Selenium и Selenide реализация.

Основной сценарий:

1. Открытие главной страницы Aviakassa.
2. Выбор города отправления.
3. Выбор города назначения.
4. Выбор даты вылета.
5. Выбор даты возвращения.
6. Запуск поиска.
7. Переключение на страницу результатов.
8. Ожидание загрузки результатов.
9. Проверка найденных билетов.

Проверяется:

* открытие страницы результатов;
* наличие билетов;
* авиакомпания первого билета;
* время вылета;
* дата вылета;
* город отправления;
* город назначения;
* цена билета.

---

# 🔄 Selenium vs Selenide

Одной из целей проекта является практическое сравнение Selenium WebDriver и Selenide.

## Selenium

В Selenium-версии используются:

```java
By
WebElement
WebDriverWait
ExpectedConditions
driver.findElement()
driver.findElements()
driver.switchTo()
```

Разработчик самостоятельно управляет поиском элементов и ожиданиями.

---

## Selenide

В Selenide-версии используются:

```java
SelenideElement
ElementsCollection
$()
$$()
shouldBe()
shouldHave()
switchTo()
```

Selenide автоматически выполняет ожидание элементов в большинстве типичных сценариев.

Например, Selenium:

```java
new WebDriverWait(driver, Duration.ofSeconds(10))
        .until(driver -> !findElements(cards).isEmpty());
```

В Selenide:

```java
cards.shouldHave(sizeGreaterThan(0));
```

Это позволяет сделать код Page Objects более компактным и декларативным.

---

# Allure Report

В проект интегрирован **Allure Report**.

Для улучшения информативности отчётов используются:

* `@Step`;
* attachments;
* screenshots при падении тестов;
* screenshots отдельных шагов.

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

При падении теста к соответствующему шагу прикрепляется screenshot состояния браузера.

---

#  Запуск проекта

## Клонирование проекта

```bash
git clone https://github.com/timuraskarov96/ui-automation-framework.git
```

Перейти в директорию проекта:

```bash
cd ui-automation-framework
```

---

## Запуск всех тестов

### Windows PowerShell

```powershell
.\gradlew test
```

### Linux / macOS

```bash
./gradlew test
```

---

## Полный прогон с очисткой

Windows:

```powershell
.\gradlew clean test
```

Linux / macOS:

```bash
./gradlew clean test
```

---

## Запуск отдельного теста

Например, запуск теста Aviakassa:

```powershell
.\gradlew test --tests "core.tests.aviakassa.AviakassaSearchTest"
```

---

