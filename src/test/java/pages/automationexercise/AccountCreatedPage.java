package pages.automationexercise;

import core.base.BasePage;
import org.openqa.selenium.By;

public class AccountCreatedPage extends BasePage {

    // Заголовок ACCOUNT CREATED!
    private final By accountCreatedTitle =  By.xpath("//b[contains(text(), 'Account Created!')]");
    // Кнопка Continue
    private final By continueButton = By.cssSelector("[data-qa='continue-button']");

    // Проверяет успешное создание аккаунта
    public boolean isAccountCreated(){
        return isDisplayed(accountCreatedTitle);
    }

    // Нажимает Continue
    public void clickContinue() {
        click(continueButton);
    }
}
