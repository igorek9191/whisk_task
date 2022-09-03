package smoke;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class Yandex1 extends BaseTest{

    @DisplayName("Yandex1")
    @Test
    public void test1() {
        open("https://ya.ru/");
        Selenide.sleep(3000);
        $x("//input[@id='text']").click();
    }
}
