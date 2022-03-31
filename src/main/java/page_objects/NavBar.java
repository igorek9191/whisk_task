package page_objects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class NavBar {

    private SelenideElement shoppingTab = $x("//a[contains(text(),'Shopping')]");
    private SelenideElement avatarButton = $x("//button[@data-testid='avatar-button']");
    private SelenideElement logOutButton = $x("//button[@data-testid='desktop-logout-button']");

    @Step("Opening of Shopping tab")
    public ShoppingTab openShoppingTab(){
        shoppingTab.click();
        return page(ShoppingTab.class);
    }

    @Step("Logout")
    public LoginPage logOut(){
        avatarButton.click();
        logOutButton.click();
        return page(LoginPage.class);
    }
}
