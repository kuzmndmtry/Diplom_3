package pageSteps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageObject.MainPage;

public class MainPageSteps {
    private final WebDriver webDriver;

    public MainPageSteps(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Step
    public void goToMainPage() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.openMainPage();
    }

    @Step("Переход к экрану логина  по кнопке «Войти в аккаунт»")
    public void goToLoginPage() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.waitAuthButton();
        mainPage.clickAuthButton();
    }
    @Step("Переход к экрану логина  через кнопку «Личный кабинет»")
    public void goToLoginPageFromProfile() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.waitProfileButton();
        mainPage.clickProfileButton();
    }
    @Step("Проверить, что отобразилась кнопка 'Соберите бургер'")
    public boolean checkOrderCreateButton() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.waitOrderCreateButton();
        return mainPage.orderCreateButtonIsVisible();
    }
    @Step("Клик по кнопке Булки")
    public void clickBunsButton() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.waitBunsButton();
        mainPage.clickBunsButton();
    }
    @Step("Клик по кнопке Соусы")
    public void clickSaucesButton() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.waitSaucesButton();
        mainPage.clickSaucesButton();
    }
    @Step("Клик по кнопке Начинки")
    public void clickFillingsButton() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.waitFillingsButton();
        mainPage.clickFillingsButton();
    }
    @Step("Провериить, переход к заголовку Соусы")
    public boolean checkThatTheSaucesHeaderVisible() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.waitSaucesHeader();
        return  mainPage.headerSaucesIsVisible();
    }
    @Step("Провериить, переход к заголовку Булки")
    public boolean checkThatTheBunsHeaderVisible() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.waitSaucesHeader();
        return  mainPage.headerBunsIsVisible();
    }
    @Step("Провериить, переход к заголовку Начинки")
    public boolean checkThatTheFillingsHeaderVisible() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.waitSaucesHeader();
        return  mainPage.headerFillingsIsVisible();
    }







}
