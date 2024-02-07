package pageObject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private final WebDriver webDriver;
    private final WebDriverWait webDriverWait;

    public MainPage (WebDriver webDriver){
        this.webDriver = webDriver;
        this.webDriverWait = new WebDriverWait(webDriver,3);
    }
    public static final String BASE_URI = "https://stellarburgers.nomoreparties.site";

    //Локаторы
    private final By AUTH_BUTTON = By.xpath("//*[text()='Войти в аккаунт']");
    private final By PROFILE_BUTTON = By.xpath("//*[text()='Личный Кабинет']");
    private final By ORDER_CREATE_BUTTON = By.xpath("//*[text()='Соберите бургер']");
    private final By BUNS_BUTTON = By.xpath("//*[span[text()='Булки']]");
    private final By SAUCES_BUTTON = By.xpath("//*[span[text()='Соусы']]");
    private final By FILLINGS_BUTTON = By.xpath("//*[span[text()='Соусы']]");
    private final By BUNS_TAB = By.xpath("//*/div[span[text()='Булки']]");
    private final By SAUCES_TAB  = By.xpath("//*/div[span[text()='Соусы']]");
    private final By FILLINGS_TAB = By.xpath("//*/div[span[text()='Соусы']]");

    //Методы  ожидания
    public void openMainPage() {
        webDriver.get(BASE_URI);
    }
    public void waitAuthButton() {
        new WebDriverWait(webDriver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(AUTH_BUTTON));
    }
    public void waitProfileButton() {
        new WebDriverWait(webDriver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(PROFILE_BUTTON));
    }
    public void waitOrderCreateButton() {
        new WebDriverWait(webDriver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(ORDER_CREATE_BUTTON));
    }
    public void waitBunsButton() {
        new WebDriverWait(webDriver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(BUNS_BUTTON));
    }
    public void waitSaucesButton() {
        new WebDriverWait(webDriver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(SAUCES_BUTTON));
    }
    public void waitFillingsButton() {
        new WebDriverWait(webDriver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(FILLINGS_BUTTON));
    }public void waitBunsHeader() {
        new WebDriverWait(webDriver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(BUNS_TAB));
    }
    public void waitSaucesHeader() {
        new WebDriverWait(webDriver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(SAUCES_TAB));
    }
    public void waitFillingsHeader() {
        new WebDriverWait(webDriver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(FILLINGS_TAB));
    }
    public void clickAuthButton() {
        WebElement button = webDriver.findElement(AUTH_BUTTON);
        button.click();
    }
    public void clickProfileButton() {
        WebElement button = webDriver.findElement(PROFILE_BUTTON);
        button.click();
    }
    public void clickBunsButton() {
        WebElement button = webDriver.findElement(BUNS_BUTTON);
        button.click();
    }
    public void clickFillingsButton() {
        WebElement button = webDriver.findElement(FILLINGS_BUTTON);
        button.click();
    }
    public void clickSaucesButton() {
        WebElement button = webDriver.findElement(SAUCES_BUTTON);
        button.click();
    }
    public boolean orderCreateButtonIsVisible() {
        return !webDriver.findElements(ORDER_CREATE_BUTTON).isEmpty();
    }
    public boolean headerBunsIsVisible() {
        return webDriver.findElement(BUNS_TAB).isDisplayed()
                && webDriver.findElement(BUNS_TAB).getAttribute("class").contains("current");
    }
    public boolean headerSaucesIsVisible() {
        return webDriver.findElement(SAUCES_TAB).isDisplayed()
                && webDriver.findElement(SAUCES_TAB).getAttribute("class").contains("current");
    }

    public boolean headerFillingsIsVisible() {
        return webDriver.findElement(FILLINGS_TAB).isDisplayed()
                && webDriver.findElement(SAUCES_TAB).getAttribute("class").contains("current");
    }




}
