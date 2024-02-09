package pageSteps;

import org.openqa.selenium.WebDriver;
import pageObject.LoginPage;
import io.qameta.allure.*;

public class LoginPageSteps {
    private final WebDriver webDriver;

    public LoginPageSteps(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Step("Ввод email и пароля")
    public void setInputUserLoginData(String email, String Password) {
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.waitEmailInput();
        loginPage.waitPasswordInput();
        loginPage.setEmail(email);
        loginPage.setPassword(Password);
    }
    @Step("Клик по кнопке входа")
    public void clickUserLogin() {
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.waitLoginButton();
        loginPage.clickLoginButton();
    }

    @Step("Клик по кнопке регистрации")
    public void  clickUserRegister() {
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.waitRegisterButton();
        loginPage.clickRegisterButton();
    }
    @Step("Клик по кнопке востановления пароля")
    public void  clickForgotPassword() {
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.waitForgotPasswordButton();
        loginPage.clickForgotPasswordButtonButton();
    }
    @Step("Проверка, что отобразился экран логина")
    public boolean checkPageVisibility() {
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.waitEmailInput();
        loginPage.waitPasswordInput();
        loginPage.waitRegisterButton();
        return loginPage.pageIsVisible();
    }





}
