package smoke;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideConfig;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.codeborne.selenide.webdriver.DefaultDriverFactory;
import com.codeborne.selenide.webdriver.DriverFactory;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.extern.slf4j.Slf4j;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import page_objects.LoginPage;
import page_objects.NavBar;
import property_handling.GeneralProperties;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

@Slf4j
public class BaseTest {

    protected LoginPage loginPage;
    protected NavBar navBar;

    private GeneralProperties generalProperties = ConfigFactory.create(GeneralProperties.class);

//    @BeforeAll
    public void beforeUIsuite() {
        Configuration.headless = true;

        log.info("===========================================================");
        log.info("Starting new test class: " + this.getClass().getSimpleName());
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(false));
        open();
        Selenide.webdriver().driver().getWebDriver().manage().window().maximize();

        //TODO
//        loginPage = open(generalProperties.url(), LoginPage.class);
//        navBar = loginPage.signIn(generalProperties.loginName(), generalProperties.password());
    }

    private static void setUpDriver(String browserName) throws Exception {
        MutableCapabilities capabilities = null;
        switch (browserName) {
            case "chrome" -> {
                capabilities = new ChromeOptions();
                capabilities.setCapability("browserVersion", "103.0");

            }
            case "firefox" -> {
                capabilities = new FirefoxOptions();
                capabilities.setCapability("browserVersion", "103.0");

            }
            default -> throw new Exception("No such browser like '" + browserName + "'");
        }
        capabilities.setCapability("selenoid:options", new HashMap<String, Object>() {{
            /* How to add test badge */
            put("name", "Test badge...");

            put("enableVNC", true);

            /* How to set session timeout */
            put("sessionTimeout", "15m");

            /* How to add "trash" button */
            put("labels", new HashMap<String, Object>() {{put("manual", "true");}});
            /* How to set timezone */
            put("env", new ArrayList<String>() {{add("TZ=UTC");}});

            /* How to enable video recording */
            put("enableVideo", true);
        }});

        Configuration.remote="http://localhost:4444/wd/hub";
        Configuration.browserCapabilities = capabilities;
        Configuration.screenshots = true;
        Configuration.timeout=10000;
    }

//    @BeforeAll
    public void withSelenoid() throws Exception {
        String browser = System.getProperty("browser");
        setUpDriver(browser);

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(false));

//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.setCapability("browserVersion", "103.0");
//        chromeOptions.setCapability("selenoid:options", new HashMap<String, Object>() {{
//            /* How to add test badge */
//            put("name", "Test badge...");
//
//            put("enableVNC", true);
//
//            /* How to set session timeout */
//            put("sessionTimeout", "15m");
//
//            /* How to add "trash" button */
//            put("labels", new HashMap<String, Object>() {{put("manual", "true");}});
//            /* How to set timezone */
//            put("env", new ArrayList<String>() {{add("TZ=UTC");}});
//
//            /* How to enable video recording */
//            put("enableVideo", true);
//        }});

//        Configuration.remote="http://localhost:4444/wd/hub";
//        Configuration.browserCapabilities = chromeOptions;
//        Configuration.screenshots = true;
//        Configuration.timeout=10000;

        open();
        Selenide.webdriver().driver().getWebDriver().manage().window().maximize();

//        loginPage = open(generalProperties.url(), LoginPage.class);
//        navBar = loginPage.signIn(generalProperties.loginName(), generalProperties.password());
    }

//    @AfterAll
    public void logOut() {
        navBar.logOut();
    }
}
