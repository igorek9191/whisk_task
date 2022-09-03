package smoke;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.junit.jupiter.api.*;
import page_objects.ShoppingTab;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static enums.ITEM.*;

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
@Feature("Add popular items to list")
public class AddItemsToListTest extends BaseTest {

    private ShoppingTab shoppingTab;

//    @Step("Filling shopping list")
//    @BeforeAll
    public void beforeAll() {
        //TODO
        Selenide.sleep(1000);
        shoppingTab = navBar.openShoppingTab();
        shoppingTab.clickAddItemInput();
        shoppingTab
                .selectItem(MILK)
                .selectItem(BREAD)
                .selectItem(BUTTER)
                .selectItem(CHEESE)
                .selectItem(ONION)
                .pressEscape();
    }

    @DisplayName("Check of adding popular items to shopping list")
    @Test
    public void test1() {
        open("https://ya.ru/");
        Selenide.sleep(3000);
        $x("//*[data-id]").shouldBe(visible);

//        shoppingTab.itemInShoppingList(MILK).shouldBe(visible);
//        shoppingTab.itemInShoppingList(BREAD).shouldBe(visible);
//        shoppingTab.itemInShoppingList(BUTTER).shouldBe(visible);
//        shoppingTab.itemInShoppingList(CHEESE).shouldBe(visible);
//        shoppingTab.itemInShoppingList(ONION).shouldBe(visible);
    }

    @Step("Clearing shopping list")
//    @AfterAll
    public void clearShoppingList() {
        shoppingTab.removeItemFromShoppingList(MILK)
                .removeItemFromShoppingList(BREAD)
                .removeItemFromShoppingList(BUTTER)
                .removeItemFromShoppingList(CHEESE)
                .removeItemFromShoppingList(ONION);
        shoppingTab.getContentOfShoppingList().shouldBe(hidden);
    }
}