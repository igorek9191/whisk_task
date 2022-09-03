package smoke;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.junit5.SoftAssertsExtension;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import page_objects.ShoppingTab;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

@ExtendWith({SoftAssertsExtension.class})
@Feature("Deleting of shopping lists")
public class DeleteShoppingListTest extends BaseTest {

    private ShoppingTab shoppingTab;

    private final String name1 = "Some_list_name";
    private final String name2 = "Some_list_name_2";

    @Step("Creation of shopping lists")
//    @BeforeAll
    public void beforeAll() {
        //TODO
        Selenide.sleep(1000);
        shoppingTab = navBar.openShoppingTab();
        shoppingTab.clickCreateNewList();
        shoppingTab.enterListName(name1);
        shoppingTab.clickCreateList();
        shoppingTab.clickCreateNewList();
        shoppingTab.enterListName(name2);
        shoppingTab.clickCreateList();
        shoppingTab.getShoppingList(name1).shouldBe(visible);
        shoppingTab.getShoppingList(name2).shouldBe(visible);
    }

    @DisplayName("Deleting of shopping lists")
    @Test
    public void test() {
        open("https://ya.ru/");
        Selenide.sleep(3000);
//        shoppingTab.deleteList(name1);
//        shoppingTab.deleteList(name2);
//        shoppingTab.getShoppingList(name1).shouldBe(hidden);
//        shoppingTab.getShoppingList(name2).shouldBe(hidden);
    }
}