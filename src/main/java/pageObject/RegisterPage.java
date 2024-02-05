package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class RegistePage {
    private final WebDriver webDriver;
    private final WebDriverWait webDriverWait;

    public RegistePage (WebDriver webDriver){
        this.webDriver = webDriver;
        this.webDriverWait = new WebDriverWait(webDriver,3);
    }
    private final By nameInput =  By.className("text input__textfield text_type_main-default");
    private final By emailInput =  By.className("text input__textfield text_type_main-default");
    private final By passwordInput =  By.className("input pr-6 pl-6 input_type_password input_size_default");
    private final By registerButton = By.xpath("//*[text()='Зарегистрироваться']");
}
