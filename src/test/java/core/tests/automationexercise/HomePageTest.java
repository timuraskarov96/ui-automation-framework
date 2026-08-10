package core.tests.automationexercise;

import core.base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.automationexercise.HomePage;

// Проверка открытия главной страницы
public class HomePageTest extends BaseTest {
    @Test
    void shouldOpenHomePage(){
        HomePage homePage = new HomePage();
        homePage.openHomePage();
        Assertions.assertTrue(homePage.isHomePageOpened());
    }
}
