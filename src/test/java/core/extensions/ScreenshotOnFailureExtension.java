package core.extensions;

import core.base.BasePage;
import core.base.BaseTest;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.ByteArrayInputStream;
import static core.driver.DriverManager.driver;

public class ScreenshotOnFailureExtension implements TestExecutionExceptionHandler {

    @Override
    public void handleTestExecutionException(ExtensionContext extensionContext, Throwable throwable) throws Throwable {

        // Созданние скриншота при падении автотеста и передаем ег ов Allure
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

        // Прикрепляем скриншот к Allure
            Allure.addAttachment("Screenshot on failure", "image/png", new ByteArrayInputStream(screenshot), ".png");

        // Передаем исходную ошибку обратно JUnit
        throw throwable;
    }
}
