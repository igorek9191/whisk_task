package smoke;

import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import page_objects.ShoppingTab;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.visible;
import static enums.ITEM.BREAD;
import static enums.ITEM.BUTTER;
import static enums.ITEM.CHEESE;
import static enums.ITEM.MILK;
import static enums.ITEM.ONION;

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
@Feature("Add popular items to list")
public class AddItemsToListTest extends BaseTest {

    private ShoppingTab shoppingTab;

    @Step("Filling shopping list")
    @BeforeAll
    public void beforeAll() {
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
        shoppingTab.itemInShoppingList(MILK).shouldBe(visible);
        shoppingTab.itemInShoppingList(BREAD).shouldBe(visible);
        shoppingTab.itemInShoppingList(BUTTER).shouldBe(visible);
        shoppingTab.itemInShoppingList(CHEESE).shouldBe(visible);
        shoppingTab.itemInShoppingList(ONION).shouldBe(visible);
    }

    @Step("Clearing shopping list")
    @AfterAll
    public void clearShoppingList() {
        shoppingTab.removeItemFromShoppingList(MILK)
                .removeItemFromShoppingList(BREAD)
                .removeItemFromShoppingList(BUTTER)
                .removeItemFromShoppingList(CHEESE)
                .removeItemFromShoppingList(ONION);
        shoppingTab.getContentOfShoppingList().shouldBe(hidden);
    }
}