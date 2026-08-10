package pages.automationexercise;

import core.base.BasePage;
import org.openqa.selenium.By;

public class SignupPage extends BasePage {

    // Заголовок страницы
    private final By signupTitle = By.xpath("//h2[contains(text(), 'New User Signup!')]");

    // Поле Name
    private final By nameField = By.xpath("//input[@data-qa = 'signup-name']");

    // Поле Email
    private final By emailField = By.cssSelector("[data-qa='signup-email']");

    // Кнопка Signup
    private final By signupButton = By.cssSelector("[data-qa='signup-button']");

    // Проверка открытия стр регистрации
    public boolean isSignupPageOpened() {
        return isDisplayed(signupButton);
    }

    // Ввод Name
    public void enterName(String name) {
        writeText(nameField, name);
    }

    // Ввод email
    public void enterEmail(String email) {
        writeText(emailField, email);
    }

    // Нажатие на кнопку Login
    public void clickSignup() {
        click(signupButton);
    }

    // Выполняет первый этап регистрации
    public void login(String name, String email) {
        enterName(name);
        enterEmail(email);
        clickSignup();
    }
}
