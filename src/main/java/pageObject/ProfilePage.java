package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {
    private final WebDriver webDriver;
    private final WebDriverWait webDriverWait;

    public ProfilePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.webDriverWait = new WebDriverWait(webDriver, 3);
    }

    private final By LOGOUT_BUTTON = By.xpath("//*[text()='Выход']");
    private final By PROFILE_BUTTON = By.xpath("//*[text()='Профиль']");
    private final By  HISTORY_ORDER_BUTTON = By.xpath("//*[text()='История заказов']");
    private final By CONSTRUCTOR_BUTTON = By.xpath("//*[text()='Конструктор']");
    private final By  LOGO_BUTTON = By.className("AppHeader_header__logo__2D0X2");
    public void waitLogoutButton() {
        new WebDriverWait(webDriver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(LOGOUT_BUTTON));
    }public void waitProfileButton() {
        new WebDriverWait(webDriver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(PROFILE_BUTTON));
    }public void waitHistoryOrderButton() {
        new WebDriverWait(webDriver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(HISTORY_ORDER_BUTTON));
    }
    public void clickLogoutButton() {
        WebElement orderButtonTopPage = webDriver.findElement(LOGOUT_BUTTON);
        orderButtonTopPage.click();
    }
    public void waitConstructorButton() {
        new WebDriverWait(webDriver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(CONSTRUCTOR_BUTTON));
    }
    public void clickConstructorButton() {
        WebElement orderButtonTopPage = webDriver.findElement(CONSTRUCTOR_BUTTON);
        orderButtonTopPage.click();
    }
    public void waitLogoButton() {
        new WebDriverWait(webDriver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(LOGO_BUTTON));
    }
    public void clickLogoButton() {
        WebElement button = webDriver.findElement(LOGO_BUTTON);
        button.click();
    }
    public boolean pageIsVisible() {
        return !webDriver.findElements(LOGOUT_BUTTON).isEmpty()
                && !webDriver.findElements(PROFILE_BUTTON).isEmpty()
                && !webDriver.findElements(HISTORY_ORDER_BUTTON).isEmpty();
    }

}
