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

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
@Feature("Add popular items to list")
public class AddItemsToListTest extends BaseTest {

    private ShoppingTab shoppingTab;

    private final String item1 = "Milk";
    private final String item2 = "Bread";
    private final String item3 = "Butter";
    private final String item4 = "Cheese";
    private final String item5 = "Onion";

    @Step("Filling shopping list")
    @BeforeAll
    public void beforeAll() {

        shoppingTab = navBar.openShoppingTab();
        shoppingTab.clickAddItemInput();
        shoppingTab
                .selectItem(item1)
                .selectItem(item2)
                .selectItem(item3)
                .selectItem(item4)
                .selectItem(item5)
                .pressEscape();
    }

    @DisplayName("Check of presence item " + item1 + " in shopping list")
    @Test
    public void test1() {
        shoppingTab.itemInShoppingList(item1).shouldBe(visible);
    }

    @DisplayName("Check of presence item " + item2 + " in shopping list")
    @Test
    public void test2() {
        shoppingTab.itemInShoppingList(item2).shouldBe(visible);
    }

    @DisplayName("Check of presence item " + item3 + " in shopping list")
    @Test
    public void test3() {
        shoppingTab.itemInShoppingList(item3).shouldBe(visible);
    }

    @DisplayName("Check of presence item " + item4 + " in shopping list")
    @Test
    public void test4() {
        shoppingTab.itemInShoppingList(item4).shouldBe(visible);
    }

    @DisplayName("Check of presence item " + item5 + " in shopping list")
    @Test
    public void test5() {
        shoppingTab.itemInShoppingList(item5).shouldBe(visible);
    }

    @Step("Clearing shopping list")
    @AfterAll
    public void clearShoppingList() {
        shoppingTab.removeItemFromShoppingList(item1)
                .removeItemFromShoppingList(item2)
                .removeItemFromShoppingList(item3)
                .removeItemFromShoppingList(item4)
                .removeItemFromShoppingList(item5);
        shoppingTab.getContentOfShoppingList().shouldBe(hidden);
    }
}