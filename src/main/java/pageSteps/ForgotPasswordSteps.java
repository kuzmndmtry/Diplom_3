package pageSteps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageObject.ForgotPasswordPage;

public class ForgotPasswordSteps {

    private final WebDriver webDriver;

    public ForgotPasswordSteps(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Step("Клик по кнопке 'Войти'")
    public void clickLoginButton() {
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(webDriver);
        forgotPasswordPage.waitLoginButton();
        forgotPasswordPage.clickLoginButton();
    }
}
