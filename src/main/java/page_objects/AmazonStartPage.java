package page_objects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class AmazonStartPage {

    private SelenideElement searchInput = $(By.id("twotabsearchtextbox"));
    private SelenideElement searchButton = $(By.id("nav-search-submit-button"));

    public SearchResultPage searchForGood(String goodName){
        searchInput.sendKeys(goodName);
        searchButton.click();
        return page(SearchResultPage.class);
    }
}
