package pages.automationexercise;

import core.base.BasePage;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    // Заголовок страницы
    private final By loginTitle = By.xpath("//h2[contains(text(),'Login to your account')]");

    // Поле Email
    private final By emailField = By.xpath("//input[@data-qa= 'login-email']");

    // Поле Password
    private final By passwordField = By.xpath("//input[@data-qa= 'login-password']");

    // Кнопка Login
    private final By loginButton = By.xpath("//button[@data-qa= 'login-button']");

    // Сообщение об ошибке
    private final By loginErrorMessage =
            By.xpath("//p[contains(text(), 'Your email or password is incorrect!')]");

    // Ввод email
    public void enterEmail(String email){
        writeText(emailField, email);
    }

    // Вводит пароль
    public void enterPassword(String password) {
        writeText(passwordField, password);
    }

    // Нажатие на кнопку Login
    public void clickLogin(){
        click(loginButton);
    }

    // Выполняет авторизацию
    public void login(String email, String password){
        enterEmail(email);
        enterPassword(password);
        clickLogin();
    }

    // Проверяет открытие страницы Login
    public boolean isLoginPageOpened() {
        return isDisplayed(loginTitle);
    }

    // Проверяет отображение ошибки
    public boolean isLoginErrorDisplayed() {
        return isDisplayed(loginErrorMessage);
    }
}
