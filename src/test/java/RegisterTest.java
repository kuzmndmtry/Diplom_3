import api.UserApi;
import dto.Browser;
import dto.NewUserData;
import dto.UserData;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import pageSteps.LoginPageSteps;
import pageSteps.MainPageSteps;
import pageSteps.RegisterPageSteps;
@RunWith(Parameterized.class)
public class RegisterTest {
    private WebDriver webDriver;
    private final String browser;
    private NewUserData newUserData;
    private UserApi userApi;
    @Parameterized.Parameters(name="Browser {0}")
    public static Object[][] browser() {
        return new Object[][]{
                {"yandex"},
                {"chrome"},
        };
    }
    public RegisterTest(String browser) {
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
    @DisplayName("Проверить успешную регистрацию.")
    public void checkSuccessfulRegistration() {
        LoginPageSteps loginPageSteps = new LoginPageSteps(webDriver);
        MainPageSteps mainPageSteps = new MainPageSteps(webDriver);
        RegisterPageSteps registerPageSteps = new RegisterPageSteps(webDriver);
        mainPageSteps.goToMainPage();
        mainPageSteps.goToLoginPage();
        loginPageSteps.clickUserRegister();
        registerPageSteps.setInputUserRegisterData(newUserData.getName(),
                newUserData.getEmail(),
                newUserData.getPassword());
        Assert.assertTrue(loginPageSteps.checkPageVisibility());
    }

    @Test
    @DisplayName("Проверить ошибку для некорректного пароля. Минимальный пароль — шесть символов.")
    public void checkRegistrationWithShortPassword() {
        LoginPageSteps loginPageSteps = new LoginPageSteps(webDriver);
        MainPageSteps mainPageSteps = new MainPageSteps(webDriver);
        RegisterPageSteps registerPageSteps = new RegisterPageSteps(webDriver);
        mainPageSteps.goToMainPage();
        mainPageSteps.goToLoginPage();
        loginPageSteps.clickUserRegister();
        registerPageSteps.setInputUserRegisterData(newUserData.getName(),
                newUserData.getEmail(),
                newUserData.getPassword().substring(0, 3));
        Assert.assertTrue(registerPageSteps.checkPasswordErrorIsVisible());
    }
}
