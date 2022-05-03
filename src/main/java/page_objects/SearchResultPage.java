package page_objects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.SneakyThrows;
import org.openqa.selenium.By;

import java.util.OptionalDouble;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.ownText;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.valueOf;

public class SearchResultPage {

    private SelenideElement minPriceInput = $(By.id("low-price"));
    private SelenideElement maxPriceInput = $(By.id("high-price"));
    private SelenideElement goButton = $x("(//input[@type='submit'])[2]");

    private ElementsCollection actualPrices = $$x("//span[@class='a-price']//span[@class='a-offscreen']");

    public SearchResultPage filterByPrice(String minPrice, String maxPrice){
        minPriceInput.scrollIntoView(true);
        minPriceInput.sendKeys(minPrice);
        maxPriceInput.sendKeys(maxPrice);
        goButton.click();
        return this;
    }

    @SneakyThrows
    public ShoesPage clickExpensiveShoes(){
        double maxPrice;
        OptionalDouble optionalMaxPrice = actualPrices.stream()
                .map(element -> element.getOwnText().replace("$", ""))
                .mapToDouble(Double::parseDouble)
                .filter(value -> value > 20.00 && value < 60.00)
                .max();
        if(optionalMaxPrice.isPresent()) maxPrice = optionalMaxPrice.getAsDouble();
        else throw new Exception("No max price");

        ElementsCollection maxElements = actualPrices.filter(ownText("$" + valueOf(maxPrice)));
        maxElements.get(0).parent().scrollIntoView(true).click();
        return page(ShoesPage.class);
    }
}