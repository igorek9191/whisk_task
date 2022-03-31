package page_objects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage {

    SelenideElement emailInput = $(By.id("_input-1"));
    SelenideElement continueButton = $x("//div[contains(text(),'Continue')]");

    SelenideElement passwordInput = $(By.id("_input-2"));
    SelenideElement logInButton = $x("//button[@data-testid='auth-login-button']");

    @Step("Sign in with login = {login} and password = {password}")
    public NavBar signIn(String login, String password) {
        emailInput.sendKeys(login);
        continueButton.click();
        passwordInput.sendKeys(password);
        logInButton.click();
        return page(NavBar.class);
    }
}
