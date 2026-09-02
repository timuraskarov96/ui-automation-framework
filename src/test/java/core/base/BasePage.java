package core.base;

import core.driver.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.Selenide.switchTo;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected JavascriptExecutor js;


    // Конструктор базовой страницы
    public BasePage() {
        this.driver = DriverManager.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        js = (JavascriptExecutor) driver;
    }

    // Открываем сайт
    public void open(String url) {
        driver.get(url);
    }

    // Находим элемент
    public WebElement find(By locator) {
        return driver.findElement(locator);
    }

    // Клик по элементу
    public void click(By locator) {
        find(locator).click();
    }

    // Ввод текста в поле с предварительной его очисткой
    public void writeText(By locator, String text) {
        WebElement element = find(locator);
        element.clear();
        element.sendKeys(text);
    }

    // Получение текста с элемента
    public String getText(By locator) {
        WebElement element = find(locator);
        return element.getText();
    }

    // Проверка отображения элемента
    public boolean isDisplayed(By locator) {
        WebElement element = find(locator);
        return element.isDisplayed();
    }

    // Возвращает список элементов по локатору
    protected List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }

    public void clearTextFieldFull(By locator){
        driver.findElement(locator).sendKeys(Keys.LEFT_CONTROL + "A");
        driver.findElement(locator).sendKeys(Keys.BACK_SPACE);
    }


     // Переключается на новую вкладку браузера.
    protected void switchToNewTab() {

        String currentWindow = driver.getWindowHandle();

        // Ждем открытия новой вкладки
        wait.until(driver -> driver.getWindowHandles().size() > 1);

        // Ищем новую вкладку и переключаемся на нее
        for (String window : driver.getWindowHandles()) {
            if (!window.equals(currentWindow)) {
                driver.switchTo().window(window);
                return;
            }
        }
    }

    protected void switchToNewTabSelenide() {
        switchTo().window(1);
    }

    // Ожидание появления локатора
    protected void waitForElementDisplayed(By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver -> driver.findElement(locator).isDisplayed());
    }


}
