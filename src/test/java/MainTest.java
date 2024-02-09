import dto.Browser;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import pageSteps.MainPageSteps;

@RunWith(Parameterized.class)
public class MainTest {
    private WebDriver webDriver;
    private String browser;

    @Parameterized.Parameters(name="Browser {0}")
    public static Object[][] browser() {
        return new Object[][]{
                {"yandex"},
                {"chrome"},
        };
    }

    public MainTest(String browser) {
        this.browser = browser;
    }

    @Before
    public void setup() {
        webDriver = Browser.getWebDriver(browser);
    }

    @After
    public void teardown() {
        webDriver.quit();
    }

    @Test
    @DisplayName("Переход по кнопке Булки")
    public void checkTheTransitionUsingTheBunsButton() {
        MainPageSteps mainPageSteps = new MainPageSteps(webDriver);
        mainPageSteps.goToMainPage();
        mainPageSteps.clickSaucesButton();
        mainPageSteps.clickBunsButton();
        Assert.assertTrue(mainPageSteps.checkThatTheBunsHeaderVisible());
    }

    @Test
    @DisplayName("Переход по кнопке Соусы")
    public void checkTheTransitionUsingTheSaucesButton() {
        MainPageSteps mainPageSteps = new MainPageSteps(webDriver);
        mainPageSteps.goToMainPage();
        mainPageSteps.clickSaucesButton();
        Assert.assertTrue(mainPageSteps.checkThatTheSaucesHeaderVisible());
    }

    @Test
    @DisplayName("Переход по кнопке Начинки")
    public void checkTheTransitionUsingTheFillingButton() {
        MainPageSteps mainPageSteps = new MainPageSteps(webDriver);
        mainPageSteps.goToMainPage();
        mainPageSteps.clickFillingsButton();
        Assert.assertTrue(mainPageSteps.checkThatTheFillingsHeaderVisible());
    }

}
