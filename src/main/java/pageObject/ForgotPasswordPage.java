package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForgotPasswordPage {

    private final WebDriver webDriver;
    private final WebDriverWait webDriverWait;

    public ForgotPasswordPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.webDriverWait = new WebDriverWait(webDriver, 3);
    }

    private final By LOGIN_BUTTON = By.xpath("//*[text()='Войти']");
    public void clickLoginButton() {
        WebElement button = webDriver.findElement(LOGIN_BUTTON);
        button.click();
    }
    public void waitLoginButton() {
        new WebDriverWait(webDriver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BUTTON));
    }
}
