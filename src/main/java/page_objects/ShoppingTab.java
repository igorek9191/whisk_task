package page_objects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import enums.ITEM;
import io.qameta.allure.Step;
import lombok.Getter;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;
import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.Keys.BACK_SPACE;
import static org.openqa.selenium.Keys.ESCAPE;

@Getter
public class ShoppingTab extends NavBar {

    private SelenideElement itemInput = $x("//input[@placeholder='Add item']");
    private ElementsCollection deletingMessages = $$x("//div[@data-projection-id]");

    private SelenideElement createNewListButton = $x("//a[@data-testid='create-new-shopping-list-button']");
    private SelenideElement listNameInput = $x("//input[@placeholder='Name your list']");
    private SelenideElement createListButton = $x("//button[@data-testid='create-new-shopping-list-create-button']");
    private SelenideElement deleteListButton = $x("//button[@data-testid='shopping-list-delete-menu-button']");
    private SelenideElement confirmDeleteListButton = $x("//button[@data-testid='confirm-delete-button']");

    private SelenideElement contentOfShoppingList = $x("//div[contains(@class,'shopping-list')]");
    private SelenideElement shoppingListOptionsButton = $x("//button[@data-testid='vertical-dots-shopping-list-button']");
    private SelenideElement clearShoppingListButton = $x("//button[@data-testid='shopping-list-clear-list-menu-button']");

    private final String itemAutoCompleteXpathTemplate = "//div[@data-testid='desktop-add-item-autocomplete']//span[contains(text(),'%s')]";
    private final String listNameXpathTemplate = "//div[@data-testid='shopping-lists-list-name' and text()='%s']";
    private final String listOptionButtonTemplate = "//div[@data-testid='shopping-lists-list-name' and text()='%s']/ancestor::div[2]//button";
    private final String shoppingListItemXpathTemplate = "//span[@data-testid='shopping-list-item-name' and text()='%s']";
    private final String listWasDeleted = "List was deleted";
    private final String greenColor = "rgba(61, 199, 149, 1)";

    @Step("Clicking create New list button")
    public ShoppingTab clickCreateNewList() {
        createNewListButton.click();
        return this;
    }

    @Step("Entering name = {listName} for a new list")
    public ShoppingTab enterListName(String listName) {
        listNameInput.click();
        String value = listNameInput.getValue();
        char[] valueArray = value.toCharArray();
        for (int i = 0; i < valueArray.length; i++) {
            listNameInput.sendKeys(BACK_SPACE);
        }
        listNameInput.sendKeys(listName);
        return this;
    }

    @Step("Clicking Create list button")
    public ShoppingTab clickCreateList() {
        createListButton.click();
        return this;
    }

    public SelenideElement getShoppingList(String listName) {
        return $x(format(listNameXpathTemplate, listName));
    }

    @Step("Deleting list with name = {listName}")
    public ShoppingTab deleteList(String listName) {
        SelenideElement options = $x(format(listOptionButtonTemplate, listName));
        options.click();
        deleteListButton.click();
        confirmDeleteListButton.click();
        //need to wait according to logic of the application
        deletingMessages.find(text(listWasDeleted)).shouldBe(hidden, ofSeconds(7));
        return this;
    }

    @Step("Clicking on item input field")
    public ShoppingTab clickAddItemInput() {
        itemInput.shouldBe(enabled);
        itemInput.click();
        return this;
    }

    @Step("Selecting item with name = {item.text}")
    public ShoppingTab selectItem(ITEM item) {
        SelenideElement itemElement = $x(format(itemAutoCompleteXpathTemplate, item.getText()));
        itemElement.click();
        SelenideElement checkingDiv = itemElement.$x("./parent::div/preceding-sibling::div");
        checkingDiv.shouldHave(cssValue("background-color", greenColor));
        return this;
    }

    @Step("Pressing Escape")
    public ShoppingTab pressEscape() {
        Selenide.actions().sendKeys(ESCAPE).perform();
        return this;
    }

    public SelenideElement itemInShoppingList(ITEM item) {
        return $x(format(shoppingListItemXpathTemplate, item.getText()));
    }

    @Step("Removing item with name = {item.text} from list")
    public ShoppingTab removeItemFromShoppingList(ITEM item) {
        SelenideElement selenideItem = $x(format(shoppingListItemXpathTemplate, item.getText()));
        Selenide.actions()
                .moveToElement(selenideItem)
                .clickAndHold(selenideItem)
                .moveByOffset(200, 0)
                .release().perform();
        //need to wait according to logic of the application
        deletingMessages.find(text(item.getText())).shouldBe(hidden, ofSeconds(7));
        return this;
    }
}