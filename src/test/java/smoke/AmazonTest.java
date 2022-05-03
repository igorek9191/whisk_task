package smoke;

import org.junit.jupiter.api.Test;
import page_objects.SearchResultPage;
import page_objects.ShoesPage;

public class AmazonTest extends BaseTest{

    private SearchResultPage searchResultPage;

    private ShoesPage shoesPage;
    @Test
    public void amazonTest(){
        searchResultPage = amazonStartPage.searchForGood("shoes");
        shoesPage = searchResultPage.filterByPrice("20", "60").clickExpensiveShoes();
        shoesPage.selectFirstExistingSize();
    }
}
