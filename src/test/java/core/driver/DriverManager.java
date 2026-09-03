package core.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class DriverManager {

    public static WebDriver driver;

    // Создает браузер.
    public static void initDriver(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().setSize(new Dimension(1920, 1080)); // настройки экрана при откртыии браузера
    }

    // Возвращает браузер.
    public static WebDriver getDriver(){
        return driver;
    }

    // Закрывает браузер
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

//    public static WebDriver downloadFileSettings() {
//
//        ChromeOptions options = new ChromeOptions();
//        Map<String, Object> prefs = new HashMap<>();
//
//
//        // 2. Отключаем диалог "Куда сохранить?"
//        prefs.put("download.prompt_for_download", false);
//
//        // 3. Разрешаем менять папку загрузок
//        prefs.put("download.directory_upgrade", true);
//
//        // 4. Включаем безопасный просмотр (обязательно!)
//        prefs.put("safebrowsing.enabled", true);
//
//        // 5. КЛЮЧЕВАЯ НАСТРОЙКА: отключаем защиту от скачивания!
//        prefs.put("safebrowsing.disable_download_protection", true);
//
//        // 6. Разрешаем автоматические скачивания
//        prefs.put("profile.default_content_setting_values.automatic_downloads", 1);
//
//        options.setExperimentalOption("prefs", prefs);
//        driver = new ChromeDriver(options);
//        return driver;
//    }

}
