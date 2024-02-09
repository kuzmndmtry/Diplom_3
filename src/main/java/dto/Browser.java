package dto;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Browser {
    public static WebDriver getWebDriver(String browser) {
        ChromeOptions options = new ChromeOptions();
        switch (browser) {
            case "yandex":
                System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver-120");
                return new ChromeDriver(options.setBinary("/Applications/Yandex.app/Contents/MacOS/Yandex"));
            case "chrome":
            default:
                System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver-121");
                return new ChromeDriver(options);
        }
    }
}
