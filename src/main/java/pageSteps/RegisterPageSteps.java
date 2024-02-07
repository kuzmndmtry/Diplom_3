package pageSteps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageObject.LoginPage;
import pageObject.MainPage;
import pageObject.RegisterPage;

public class RegisterPageSteps {

    private final WebDriver webDriver;

    public RegisterPageSteps(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Step("Ввод имени, email и пароля")
    public void setInputUserRegisterData(String name,String email, String password) {
        RegisterPage registerPage = new RegisterPage(webDriver);
        registerPage.waitNameInput();
        registerPage.waitEmailInput();
        registerPage.waitPasswordInput();
        registerPage.setName(name);
        registerPage.setEmail(email);
        registerPage.setPassword(password);
        registerPage.clickRegisterButton();
    }
    @Step("Проверить, что отобразилась ошибка 'Некорректный пароль'")
    public boolean checkPasswordErrorIsVisible() {
        RegisterPage registerPage = new RegisterPage(webDriver);
        return registerPage.passwordErrorIsVisible();
    }

}
