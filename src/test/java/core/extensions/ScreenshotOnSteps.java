package core.extensions;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;

import static core.driver.DriverManager.driver;

public class ScreenshotOnSteps {

    public static void screenshot() {

        // Созданние скриншота при падении автотеста и передаем ег ов Allure
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

        // Прикрепляем скриншот к Allure
            Allure.addAttachment("Скриншот", "image/png", new ByteArrayInputStream(screenshot), ".png");
    }
}
