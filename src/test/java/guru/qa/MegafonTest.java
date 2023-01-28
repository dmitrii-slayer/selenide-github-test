package guru.qa;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MegafonTest extends BaseTest {

    @DisplayName("Проверка разницы между $(\"div h1\") и $(\"div\").$(\"h1\")")
    @Test
    void megafonElementsTest() {
        open("https://altrep.megafon.ru/help/info/");
        String textInDivWithH1 = $("div h1").getText();
        System.out.println("text of $(\"div h1\"): " + textInDivWithH1); // Полезная информация
        String textInDivThenH1 = $("div").$("h1").getText(); // Element not found
        System.out.println("text of $(\"div\").$(\"h1\"): " + textInDivThenH1);
    }

}
