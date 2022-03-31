package smoke;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import page_objects.LoginPage;
import page_objects.NavBar;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    protected LoginPage loginPage;
    protected NavBar navBar;

    private final String url = "https://my.whisk-dev.com/";
    private final String loginName = "igorekoktb@gmail.com";
    private final String password = "566049780";

    @BeforeAll
    public void beforeUIsuite() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(false));
        open();
        Selenide.webdriver().driver().getWebDriver().manage().window().maximize();
        loginPage = open(url, LoginPage.class);
        navBar = loginPage.signIn(loginName, password);
    }

    @AfterAll
    public void logOut() {
        navBar.logOut();
    }
}
