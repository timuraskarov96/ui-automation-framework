package core.tests.automationexercise;

import core.base.BaseTest;
import core.config.ConfigReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.automationexercise.AccountPage;
import pages.automationexercise.HomePage;
import pages.automationexercise.LoginPage;

public class LogoutTest extends BaseTest {

    @Test
    public void shouldLogout(){
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        AccountPage accountPage = new AccountPage();

        homePage.openHomePage();
        Assertions.assertTrue(homePage.isHomePageOpened());
        homePage.clickSignupLogin();

        Assertions.assertTrue(loginPage.isLoginPageOpened());
        loginPage.login(ConfigReader.getEmail(), ConfigReader.getPassword());

        Assertions.assertTrue(accountPage.isUserLoggedIn());
        accountPage.clickLogout();

        Assertions.assertTrue((loginPage.isLoginPageOpened()));
    }
}
