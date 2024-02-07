package pageSteps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageObject.LoginPage;
import pageObject.ProfilePage;

public class ProfilePageSteps {
    private final WebDriver webDriver;

    public ProfilePageSteps(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    @Step("Клик по кнопке Выход")
    public void  logout() {
         ProfilePage profilePage = new ProfilePage(webDriver);
        profilePage.waitLogoutButton();
        profilePage.clickLogoutButton();
    }
    @Step("Клик по кнопке Конструктор")
    public void  clickConstructor() {
        ProfilePage profilePage = new ProfilePage(webDriver);
        profilePage.waitConstructorButton();
        profilePage.clickConstructorButton();
    }
    @Step("Клик по LOGO")
    public void  clickLogo() {
        ProfilePage profilePage = new ProfilePage(webDriver);
        profilePage.waitLogoButton();
        profilePage.clickLogoButton();
    }
    @Step("Проверить, что отобразился экран логина")
    public boolean checkPageVisibility() {
        ProfilePage profilePage = new ProfilePage(webDriver);
        profilePage.waitProfileButton();
        profilePage.waitHistoryOrderButton();
        profilePage.waitLogoutButton();
        return profilePage.pageIsVisible();
    }
}
