package page_objects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.not;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

@Slf4j
public class ShoesPage {

    private SelenideElement addToCartButton = $(By.id("add-to-cart-button"));
    private SelenideElement selector =  $x("//select[@name='dropdown_selected_size_name']");
    private ElementsCollection selectOptions = $$x("//select[@name='dropdown_selected_size_name']//option");
    private SelenideElement outOfStockMessage = $(By.id("outOfStock"));
    private SelenideElement productTitle = $(By.id("productTitle"));

    public ShoesPage selectFirstExistingSize(){
        for(SelenideElement option : selectOptions){
            selector.click();
            option.click();
            if(outOfStockMessage.is(not(visible))) break;
        }
        log.info("we have found shoes with title: " + productTitle.getText());
        log.info("the size is: " + selector.getSelectedOption().getText());
        return this;
    }

}