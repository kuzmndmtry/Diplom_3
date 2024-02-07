import api.UserApi;
import dto.Browser;
import dto.NewUserData;
import dto.UserData;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageSteps.ForgotPasswordSteps;
import pageSteps.LoginPageSteps;
import pageSteps.MainPageSteps;
import pageSteps.RegisterPageSteps;
@RunWith(Parameterized.class)
public class LoginTest {
    private WebDriver webDriver;
    private final String browser;
    private NewUserData newUserData;
    private UserApi userApi;
    @Parameterized.Parameters (name="Browser {0}")
    public static Object[][] browser() {
        return new Object[][]{
                {"yandex"},
                {"chrome"},
        };
    }
    public LoginTest(String browser) {
        this.browser = browser;
    }
    @Before
    public void setup() {
        webDriver = Browser.getWebDriver(browser);
        userApi = new UserApi();
        newUserData = new NewUserData();

    }
    @After
    public void teardown() {
        webDriver.quit();
        UserData userData =
                userApi.loginUser(newUserData)
                        .as(UserData.class);
        if (userData.getAccessToken() != null) {
            userApi.deleteUser(userData.getAccessToken());
        }
    }
    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    public void loginFromMainPageByLoginButton() {
        userApi.createNewUser(newUserData);
        LoginPageSteps loginPageSteps = new LoginPageSteps(webDriver);
        MainPageSteps mainPageSteps = new MainPageSteps(webDriver);
        mainPageSteps.goToMainPage();
        mainPageSteps.goToLoginPage();
        loginPageSteps.setInputUserLoginData(newUserData.getEmail(),newUserData.getPassword());
        loginPageSteps.clickUserLogin();
        Assert.assertTrue(mainPageSteps.checkOrderCreateButton());

    }
    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    public void loginFromProfilePageByLoginButton() {
        userApi.createNewUser(newUserData);
        LoginPageSteps loginPageSteps = new LoginPageSteps(webDriver);
        MainPageSteps mainPageSteps = new MainPageSteps(webDriver);
        mainPageSteps.goToMainPage();
        mainPageSteps.goToLoginPageFromProfile();
        loginPageSteps.setInputUserLoginData(newUserData.getEmail(),newUserData.getPassword());
        loginPageSteps.clickUserLogin();
        Assert.assertTrue(mainPageSteps.checkOrderCreateButton());
    }
    @Test
    @DisplayName("Вход через кнопку в форме регистрации,")
    public void loginAfterRegistrationPageByLoginButton() {
        LoginPageSteps loginPageSteps = new LoginPageSteps(webDriver);
        MainPageSteps mainPageSteps = new MainPageSteps(webDriver);
        RegisterPageSteps registerPageSteps = new RegisterPageSteps(webDriver);
        mainPageSteps.goToMainPage();
        mainPageSteps.goToLoginPage();
        loginPageSteps.clickUserRegister();
        registerPageSteps.setInputUserRegisterData(newUserData.getName(),
                newUserData.getEmail(),
                newUserData.getPassword());
        loginPageSteps.setInputUserLoginData(newUserData.getEmail(),newUserData.getPassword());
        loginPageSteps.clickUserLogin();
        Assert.assertTrue(mainPageSteps.checkOrderCreateButton());
    }
    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void loginAfterForgotPasswordPageByLoginButton() {
        userApi.createNewUser(newUserData);
        LoginPageSteps loginPageSteps = new LoginPageSteps(webDriver);
        MainPageSteps mainPageSteps = new MainPageSteps(webDriver);
        ForgotPasswordSteps forgotPasswordSteps = new ForgotPasswordSteps(webDriver);
        mainPageSteps.goToMainPage();
        mainPageSteps.goToLoginPage();
        loginPageSteps.clickForgotPassword();
        forgotPasswordSteps.clickLoginButton();
        loginPageSteps.setInputUserLoginData(newUserData.getEmail(),newUserData.getPassword());
        loginPageSteps.clickUserLogin();
        Assert.assertTrue(mainPageSteps.checkOrderCreateButton());
    }
}
