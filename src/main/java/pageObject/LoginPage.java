package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private final WebDriver webDriver;
    private final WebDriverWait webDriverWait;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.webDriverWait = new WebDriverWait(webDriver, 3);
    }

    private final By EMAIL_INPUT = By.xpath("//input[@name='name']");

    private final By PASSWORD_INPUT = By.xpath("//input[@name='Пароль']");
    private final By LOGIN_BUTTON = By.xpath("//*[text()='Войти']");
    private final By REGISTER_BUTTON = By.xpath("//*[text()='Зарегистрироваться']");
    private final By FORGOT_PASSWORD_BUTTON = By.xpath("//*[text()='Восстановить пароль']");


    public void waitEmailInput() {
        new WebDriverWait(webDriver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(EMAIL_INPUT));
    }

    public void waitPasswordInput() {
        new WebDriverWait(webDriver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(PASSWORD_INPUT));
    }

    public void waitRegisterButton() {
        new WebDriverWait(webDriver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(REGISTER_BUTTON));
    }

    public void waitLoginButton() {
        new WebDriverWait(webDriver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BUTTON));
    }

    public void waitForgotPasswordButton() {
        new WebDriverWait(webDriver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(FORGOT_PASSWORD_BUTTON));
    }

    public void setEmail(String email) {
        WebElement name = webDriver.findElement(EMAIL_INPUT);
        name.sendKeys(email, Keys.TAB);
    }

    public void setPassword(String password) {
        WebElement name = webDriver.findElement(PASSWORD_INPUT);
        name.sendKeys(password, Keys.TAB);
    }

    public void clickLoginButton() {
        WebElement button = webDriver.findElement(LOGIN_BUTTON);
        button.click();
    }

    public void clickRegisterButton() {
        WebElement button = webDriver.findElement(REGISTER_BUTTON);
        button.click();
    }

    public void clickForgotPasswordButtonButton() {
        WebElement button = webDriver.findElement(FORGOT_PASSWORD_BUTTON);
        button.click();
    }

    public boolean pageIsVisible() {
        return !webDriver.findElements(EMAIL_INPUT).isEmpty()
                && !webDriver.findElements(PASSWORD_INPUT).isEmpty()
                && !webDriver.findElements(REGISTER_BUTTON).isEmpty();
    }

}
