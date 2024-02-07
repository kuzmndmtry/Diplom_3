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
import pageSteps.LoginPageSteps;
import pageSteps.MainPageSteps;
import pageSteps.ProfilePageSteps;

@RunWith(Parameterized.class)
public class ProfileTest {
    private WebDriver webDriver;
    private NewUserData newUserData;
    private UserApi userApi;
    private String browser;

    @Parameterized.Parameters (name="Browser {0}")
    public static Object[][] browser() {
        return new Object[][]{
                {"yandex"},
                {"chrome"},
        };
    }

    public ProfileTest(String browser) {
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
    @DisplayName("Переход в личный кабинет")
    public void checkTheTransitionToProfilePage() {
        userApi.createNewUser(newUserData);
        LoginPageSteps loginPageSteps = new LoginPageSteps(webDriver);
        MainPageSteps mainPageSteps = new MainPageSteps(webDriver);
        ProfilePageSteps profilePageSteps = new ProfilePageSteps(webDriver);
        mainPageSteps.goToMainPage();
        mainPageSteps.goToLoginPage();
        loginPageSteps.setInputUserLoginData(newUserData.getEmail(), newUserData.getPassword());
        loginPageSteps.clickUserLogin();
        mainPageSteps.goToLoginPageFromProfile();
        Assert.assertTrue(profilePageSteps.checkPageVisibility());
    }

    @Test
    @DisplayName("Выход по кнопке 'Выйти' в личном кабинете")
    public void checkLogout() {
        userApi.createNewUser(newUserData);
        LoginPageSteps loginPageSteps = new LoginPageSteps(webDriver);
        MainPageSteps mainPageSteps = new MainPageSteps(webDriver);
        ProfilePageSteps profilePageSteps = new ProfilePageSteps(webDriver);
        mainPageSteps.goToMainPage();
        mainPageSteps.goToLoginPage();
        loginPageSteps.setInputUserLoginData(newUserData.getEmail(), newUserData.getPassword());
        loginPageSteps.clickUserLogin();
        mainPageSteps.goToLoginPageFromProfile();
        profilePageSteps.logout();
        Assert.assertTrue(loginPageSteps.checkPageVisibility());
    }

    @Test
    @DisplayName("Переход по клику на 'Конструктор'")
    public void checkTheTransitionByClickingOnConstructor() {
        userApi.createNewUser(newUserData);
        LoginPageSteps loginPageSteps = new LoginPageSteps(webDriver);
        MainPageSteps mainPageSteps = new MainPageSteps(webDriver);
        ProfilePageSteps profilePageSteps = new ProfilePageSteps(webDriver);
        mainPageSteps.goToMainPage();
        mainPageSteps.goToLoginPage();
        loginPageSteps.setInputUserLoginData(newUserData.getEmail(), newUserData.getPassword());
        loginPageSteps.clickUserLogin();
        mainPageSteps.goToLoginPageFromProfile();
        profilePageSteps.clickConstructor();
        Assert.assertTrue(mainPageSteps.checkOrderCreateButton());
    }

    @Test
    @DisplayName("Переход по клику на Логотип")
    public void checkTheTransitionByClickingOnLogo() {
        userApi.createNewUser(newUserData);
        LoginPageSteps loginPageSteps = new LoginPageSteps(webDriver);
        MainPageSteps mainPageSteps = new MainPageSteps(webDriver);
        ProfilePageSteps profilePageSteps = new ProfilePageSteps(webDriver);
        mainPageSteps.goToMainPage();
        mainPageSteps.goToLoginPage();
        loginPageSteps.setInputUserLoginData(newUserData.getEmail(), newUserData.getPassword());
        loginPageSteps.clickUserLogin();
        mainPageSteps.goToLoginPageFromProfile();
        profilePageSteps.clickLogo();
        Assert.assertTrue(mainPageSteps.checkOrderCreateButton());
    }
}
