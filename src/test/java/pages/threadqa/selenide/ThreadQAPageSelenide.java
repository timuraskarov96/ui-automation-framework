package pages.threadqa.selenide;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import lombok.SneakyThrows;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ThreadQAPageSelenide extends BasePage {

    private final SelenideElement text =
            $x("//*[@data-testid='username-field']");

    private final SelenideElement email =
            $x("//input[@type='email' and @required]");

    private final SelenideElement password =
            $x("//input[@data-testid='password-field']");

    private final SelenideElement textarea =
            $x("//textarea[@data-testid='comment-field' and @maxlength='500']");

    private final SelenideElement select =
            $x("//button[@data-testid='country-dropdown']");

    private final SelenideElement russia =
            $x("//*[text()='Россия']");

    private final SelenideElement checkbox =
            $x("//input[@data-testid='terms-agreement']");

    private final SelenideElement checkbox2 =
            $x("//div[@class='flex items-center gap-3']//span[text()='Согласен с условиями использования']");

    private final SelenideElement radio =
            $x("//input[@data-testid='newsletter-no']");

    private final SelenideElement buttonMain =
            $x("//button[contains(@data-testid, 'primary-button')]");

    private final SelenideElement buttonSecondary =
            $x("//button[contains(@data-testid, 'secondary-button')]");

    private final SelenideElement buttonSuccess =
            $x("//button[contains(@data-testid, 'success-button')]");

    private final SelenideElement buttonDanger =
            $x("//button[contains(@data-testid, 'danger-button')]");

    private final SelenideElement notification =
            $x("//button[contains(@data-testid, 'show-alert-button')]");

    private final SelenideElement titleInformMessage =
            $x("//div/p[contains(text(),'Информационное сообщение')]");

    private final SelenideElement informMessage =
            $x("//div/p[starts-with(text(),'Это')]");

    private final SelenideElement modalWindow =
            $x("//button[@data-testid='open-modal-button']");

    private final SelenideElement modalWindowText =
            $x("//div/h4[contains(text(),'Особенности')]");

    private final SelenideElement modalWindowButton =
            $x("//button[@data-testid='modal-confirm-button']");

    private final SelenideElement externalLink =
            $x("//div//a[@data-testid='external-link']");

    private final SelenideElement textNewTab =
            $x("//*[contains(text(),'This domain')]");

    private final SelenideElement textNewTab2 =
            $x("//a//img[contains(@alt,'Homepage')]");

    private final SelenideElement toastNotification =
            $x("//button[@data-testid='notify-error']");

    private final SelenideElement toastNotification2 =
            $x("//div//p[contains(text(),'Произошла ошибка!')]");

    // МЕТОДЫ И ПРОВЕРКИ

    public ThreadQAPageSelenide openPage(){
        Selenide.open("https://lms.threadqa.ru/xpath-practice-hub/basics");
        return this;
    }

    public ThreadQAPageSelenide enterText(){
        $(text).setValue("Timur");
        return this;
    }

    public ThreadQAPageSelenide enterEmail(){
        $(email).setValue("123@mail.ru");
        return this;
    }

    public ThreadQAPageSelenide enterPassword(){
        $(password).setValue("123@mail.ru");
        return this;
    }

    public ThreadQAPageSelenide enterArea(){
        $(textarea).setValue("text!213!!");
        return this;
    }

    public ThreadQAPageSelenide testDropdown(){
        $(select).click();
        $(russia).click();
        return this;
    }

    public ThreadQAPageSelenide clickCheckbox(){
        $(checkbox).click();
        return this;
    }

    public ThreadQAPageSelenide clickRadio(){
        $(radio).click();
        return this;
    }

    public ThreadQAPageSelenide buttonMainIsDisplayed(){
        $(buttonMain).shouldBe(visible);
        return this;
    }

    public ThreadQAPageSelenide buttonSecondaryIsDisplayed(){
        $(buttonSecondary).shouldBe(visible);
        return this;
    }

    public ThreadQAPageSelenide buttonSuccessIsDisplayed(){
        $(buttonSuccess).shouldBe(visible);
        return this;
    }

    public ThreadQAPageSelenide buttonDangerIsDisplayed(){
        $(buttonDanger).shouldBe(visible);
        return this;
    }

    public ThreadQAPageSelenide checkDisplayedInformMessage(){
        $(notification).click();
        $(titleInformMessage).shouldBe(visible);
        $(informMessage).shouldBe(visible);
        return this;
    }

    @SneakyThrows
    public ThreadQAPageSelenide checkModalWindow(){
        $(modalWindow).click();
        $(modalWindowText).shouldBe(visible);
        $(modalWindowButton).click();
        return this;
    }

    public ThreadQAPageSelenide checkExternalLink(){
        $(externalLink).click();
        switchToNewTabSelenide();
        $(textNewTab).shouldBe(visible);
        $($x("//*[contains(text(),'Learn')]")).click();
        switchToNewTabSelenide();
        $(textNewTab2).shouldBe(visible);
        return this;
    }

    public ThreadQAPageSelenide checkToastNotification(){
        $(toastNotification).click();
        $(toastNotification2).shouldBe(visible);
        return this;
    }

}
