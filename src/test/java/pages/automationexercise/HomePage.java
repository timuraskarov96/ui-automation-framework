package pages.automationexercise;

import core.base.BasePage;
import core.config.ConfigReader;
import org.openqa.selenium.By;

public class HomePage extends BasePage {

    // Кнопка "Signup / Login
    private final By signupLoginButton = By.xpath("//a[contains(text(), 'Signup / Login')]");

    // Кнопка "Products"
    private final By productsButton = By.xpath("//a[contains(text(), ' Products')]");

    // Кнопка "Cart"
    private final By cartButton = By.xpath("//a[contains(text(), ' Cart')]");

    // Кнопка "Contact us"
    private final By contactUsButton = By.xpath("//a[contains(text(), ' Contact us')]");

    // Лого сайта
    private final By logo = By.xpath("//div[@class='logo pull-left']");

    // Открытие главной страницы
    public void openHomePage(){
        open(ConfigReader.getUrlAutomationexercise());
    }

    // Переход на страницу авторизации
    public void clickSignupLogin(){
        click(signupLoginButton);
    }

    // Переходит на страницу товаров
    public void clickProducts() {
        click(productsButton);
    }

    // Переходит в корзину
    public void clickCart() {
        click(cartButton);
    }

    // Переходит в Contact Us
    public void clickContactUs() {
        click(contactUsButton);
    }

    // Проверяет, что главная страница открыта
    public boolean isHomePageOpened(){
        return isDisplayed(logo);
    }
}
