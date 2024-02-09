package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class RegisterPage {
    private final WebDriver webDriver;
    private final WebDriverWait webDriverWait;

    public RegisterPage(WebDriver webDriver){
        this.webDriver = webDriver;
        this.webDriverWait = new WebDriverWait(webDriver,3);
    }
    private final By REGISTER_BUTTON = By.xpath("//*[text()='Зарегистрироваться']");
    private final By NAME_INPUT = By.xpath("//*[label[text()='Имя']]/input");
    private final By EMAIL_INPUT = By.xpath("//*[label[text()='Email']]/input");
    private final By PASSWORD_INPUT =  By.xpath("//input[@name='Пароль']");
    private final By PASSWORD_ERROR =  By.xpath("//*[text()='Некорректный пароль']");

    public void waitEmailInput() {
        new WebDriverWait(webDriver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(EMAIL_INPUT));
    }
    public void waitPasswordInput() {
        new WebDriverWait(webDriver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(PASSWORD_INPUT));
    }
    public void waitNameInput() {
        new WebDriverWait(webDriver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(NAME_INPUT));
    }

    public boolean passwordErrorIsVisible() {
        return !webDriver.findElements(PASSWORD_ERROR).isEmpty();
    }
    public void setEmail(String email) {
        WebElement name = webDriver.findElement(EMAIL_INPUT);
        name.sendKeys(email, Keys.TAB);
    }
    public void setPassword(String password) {
        WebElement name = webDriver.findElement(PASSWORD_INPUT);
        name.sendKeys(password, Keys.TAB);
    }
    public void setName(String nameUser) {
        WebElement name = webDriver.findElement(NAME_INPUT);
        name.sendKeys(nameUser, Keys.TAB);
    }
    public void clickRegisterButton() {
        WebElement button = webDriver.findElement(REGISTER_BUTTON);
        button.click();
    }
}
