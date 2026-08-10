package core.tests.automationexercise;

import core.base.BaseTest;
import core.utils.TestDataGenerator;
import core.utils.UserFactory;
import models.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.automationexercise.*;

// Проверка успешной регистрации нового пользователя
public class RegistrationTest extends BaseTest {

    @Test
    void shouldRegister(){
        // Создаем тестового пользователя
        User user = UserFactory.createRandomUser();

        // Создаем Page Object
        HomePage homePage = new HomePage();
        SignupPage signupPage = new SignupPage();
        CreateAccountPage createAccountPage = new CreateAccountPage();
        AccountCreatedPage accountCreatedPage = new AccountCreatedPage();
        AccountPage accountPage = new AccountPage();

        // Открываем сайт
        homePage.openHomePage();

        // Переходим на страницу регистрации
        homePage.clickSignupLogin();

        // Проверяем открытие страницы регистрации
        Assertions.assertTrue(signupPage.isSignupPageOpened());

        // Первый этап регстрации
        signupPage.login(TestDataGenerator.generateName(), TestDataGenerator.generateEmail());

        // Проверяем открытие формы регистрации
        Assertions.assertTrue(createAccountPage.isCreateAccountPageOpened());

        // Заполняем форму регистрации
        createAccountPage.register(user);

        // Проверяем успешное создание аккаунта
        Assertions.assertTrue(accountCreatedPage.isAccountCreated());

        // Продолжаем
        accountCreatedPage.clickContinue();

        // Проверяем успешную авторизацию
        Assertions.assertTrue(accountPage.isUserLoggedIn());
    }
}
