package pages.threadqa.selenium;

import core.base.BasePage;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class ThreadQAPage extends BasePage {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    JavascriptExecutor js = (JavascriptExecutor) driver;

    private final By text =
            By.xpath("//*[@data-testid='username-field']");

    private final By email =
            By.xpath("//input[@type='email' and @required]");

    private final By password =
            By.xpath("//input[@data-testid='password-field']");

    private final By textarea =
            By.xpath("//textarea[@data-testid='comment-field' and @maxlength='500']");

    private final By select =
            By.xpath("//button[@data-testid='country-dropdown']");

    private final By russia =
            By.xpath("//*[text()='Россия']");

    private final By checkbox =
            By.xpath("//input[@data-testid='terms-agreement']");

    private final By checkbox2 =
            By.xpath("//div[@class='flex items-center gap-3']//span[text()='Согласен с условиями использования']");

    private final By radio =
            By.xpath("//input[@data-testid='newsletter-no']");

    private final By buttonMain =
            By.xpath("//button[contains(@data-testid, 'primary-button')]");

    private final By buttonSecondary =
            By.xpath("//button[contains(@data-testid, 'secondary-button')]");

    private final By buttonSuccess =
            By.xpath("//button[contains(@data-testid, 'success-button')]");

    private final By buttonDanger =
            By.xpath("//button[contains(@data-testid, 'danger-button')]");

    private final By notification =
            By.xpath("//button[contains(@data-testid, 'show-alert-button')]");

    private final By titleInformMessage =
            By.xpath("//div/p[contains(text(),'Информационное сообщение')]");

    private final By informMessage =
            By.xpath("//div/p[starts-with(text(),'Это')]");

    private final By modalWindow =
            By.xpath("//button[@data-testid='open-modal-button']");

    private final By modalWindowText =
            By.xpath("//div/h4[contains(text(),'Особенности')]");

    private final By modalWindowButton =
            By.xpath("//button[@data-testid='modal-confirm-button']");

    private final By externalLink =
            By.xpath("//div//a[@data-testid='external-link']");

    private final By textNewTab =
            By.xpath("//*[contains(text(),'This domain')]");

    private final By textNewTab2 =
            By.xpath("//a//img[contains(@alt,'Homepage')]");

    private final By toastNotification =
            By.xpath("//button[@data-testid='notify-error']");

    private final By toastNotification2 =
            By.xpath("//div//p[contains(text(),'Произошла ошибка!')]");


    private final By advancedElements =
            By.xpath("//button//span[text()='Продвинутые элементы' and @class='text-sm']");

    private final By launchButton =
            By.xpath("//button[@data-testid='start-loading-button']");

    private final By progressMeaning =
            By.xpath("//span[@data-testid='progress-percentage' and text()='100']");

    private final By progressBar =
            By.xpath("//div[@aria-valuenow='100']");

    private final By ready =
            By.xpath("//span[text()='Готово']");

    private final By draggable =
            By.xpath("//div[@draggable='true' and @data-testid='draggable-item']");

    private final By dragDropArea =
            By.xpath("//div[@id='drop-zone' and @data-testid='drag-drop-area']");

    private final By uploadButton =
            By.xpath("//input[@type='file']");

    private final By fileInfo =
            By.xpath("//div[@data-testid='file-info']");

    private final By downloadFile =
            By.xpath("//button[@data-testid='file-download-button']");



                   // МЕТОДЫ И ПРОВЕРКИ

    public ThreadQAPage openPage(){
        open("https://lms.threadqa.ru/xpath-practice-hub/basics");
        return this;
    }


    public ThreadQAPage enterText(){
        writeText(text, "Timur");
        return this;
    }

    public ThreadQAPage enterEmail(){
        writeText(email, "123@mail.ru");
        return this;
    }

    public ThreadQAPage enterPassword(){
        writeText(password, "123Qwerty");
        return this;
    }

    public ThreadQAPage enterArea(){
        writeText(textarea, "text!!!");
        return this;
    }


    public ThreadQAPage testDropdown(){
        actionOfClick(driver, select);
        click(russia);
        return this;
    }

    public ThreadQAPage clickCheckbox(){
        actionOfClick(driver, checkbox);
        return this;
    }

    public ThreadQAPage clickRadio(){
        actionOfClick(driver, radio);
        return this;
    }

    public ThreadQAPage buttonMainIsDisplayed(){
        isDisplayed(buttonMain);
        return this;
    }

    public ThreadQAPage buttonSecondaryIsDisplayed(){
        isDisplayed(buttonSecondary);
        return this;
    }

    public ThreadQAPage buttonSuccessIsDisplayed(){
        isDisplayed(buttonSuccess);
        return this;
    }

    public ThreadQAPage buttonDangerIsDisplayed(){
        isDisplayed(buttonDanger);
        return this;
    }

    public ThreadQAPage checkDisplayedInformMessage(){
        click(notification);
        isDisplayed(titleInformMessage);
        isDisplayed(informMessage);
        return this;
    }

    @SneakyThrows
    public ThreadQAPage checkModalWindow(){
        click(modalWindow);
        wait.until(ExpectedConditions.visibilityOfElementLocated(modalWindow));
        isDisplayed(modalWindowText);
        click(modalWindowButton);
        return this;
    }

    public ThreadQAPage checkExternalLink(){
        click(externalLink);
        switchToNewTab();
        isDisplayed(textNewTab);
        click(By.xpath("//*[contains(text(),'Learn')]"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(textNewTab2));
        isDisplayed(textNewTab2);
        return this;
    }

    public ThreadQAPage checkToastNotification(){
        click(toastNotification);
        isDisplayed(toastNotification2);
        return this;
    }


    public ThreadQAPage clickAdvancedElements(){
        actionOfClick(driver, advancedElements);
        return this;
    }

    public ThreadQAPage clickLaunchButton(){
        actionOfClick(driver, launchButton);
        return this;
    }

    public ThreadQAPage progressMeaningIsDisplayed(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(progressMeaning));
        isDisplayed(progressMeaning);
        return this;
    }

    public ThreadQAPage progressBarIsDisplayed(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(progressBar));
        isDisplayed(progressBar);
        return this;
    }

    public ThreadQAPage readyIsDisplayed(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(ready));
        isDisplayed(ready);
        return this;
    }

    public ThreadQAPage actionDragAndDrop(){
        actionDragAndDrop(find(draggable), find(dragDropArea));
        isDisplayed(By.xpath("//div//p[text()='Перетащите элемент сюда']"));
        return this;
    }

    public ThreadQAPage uploadFile(){
        uploadFile(uploadButton);
        isDisplayed(fileInfo);
        return this;
    }

    @SneakyThrows
    public ThreadQAPage downloadFile(){
        actionOfClick(driver, downloadFile);
        Thread.sleep(500);
        File file = waitForDownload("cucumber-example (2).jpg", 30);
        Assertions.assertTrue(file.exists());
        Assertions.assertTrue(file.getName().endsWith(".jpg"));
        return this;
    }
}



