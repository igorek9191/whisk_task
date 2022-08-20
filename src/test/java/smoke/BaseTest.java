package smoke;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.extern.slf4j.Slf4j;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;
import page_objects.LoginPage;
import page_objects.NavBar;
import property_handling.GeneralProperties;

import static com.codeborne.selenide.Selenide.open;

@Slf4j
public class BaseTest {

    protected LoginPage loginPage;
    protected NavBar navBar;

    private GeneralProperties generalProperties = ConfigFactory.create(GeneralProperties.class);

    @BeforeAll
    public void beforeUIsuite() {
        log.info("===========================================================");
        log.info("Starting new test class: " + this.getClass().getSimpleName());
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(false));
        open();
        Selenide.webdriver().driver().getWebDriver().manage().window().maximize();

        loginPage = open(generalProperties.url(), LoginPage.class);
        navBar = loginPage.signIn(generalProperties.loginName(), generalProperties.password());
    }

//    @AfterAll
    public void logOut() {
        navBar.logOut();
    }
}
