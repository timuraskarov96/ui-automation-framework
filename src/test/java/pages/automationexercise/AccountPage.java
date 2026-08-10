package pages.automationexercise;

import core.base.BasePage;
import org.openqa.selenium.By;

public class AccountPage extends BasePage {
    // Надпись "Logged in as"
    private final By loggedInAsLabel = By.xpath("//a[contains(text(), ' Logged in as ')]");

    // Кнопка Logout
    private final By logoutButton = By.xpath("//a[contains(text(), ' Logout')]");

    // Кнопка Delete Account
    private final By deleteAccountButton = By.xpath("//a[contains(text(),'Delete Account')]");

    // Проверяет успешную авторизацию
    public boolean isUserLoggedIn(){
        return isDisplayed(loggedInAsLabel);
    }

    // Выход из аккаунта
    public void clickLogout(){
        click(logoutButton);
    }

    // Удаление аккаунта
    public void clickDeleteAccount() {
        click(deleteAccountButton);
    }
}
