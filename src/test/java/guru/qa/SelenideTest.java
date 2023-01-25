package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTest {

    @BeforeAll
    static void configure() {
        Configuration.browserSize = "1920x1080";
    }

    @DisplayName("Проверка наличия SoftAssertions в wiki selenide")
    @Test
    void githubTest() {
        open("https://github.com/selenide/selenide");
        $("#wiki-tab").click();
        $("button.js-wiki-more-pages-link").click();
        $("#wiki-pages-box").shouldHave(text("SoftAssertions"));
        $("#wiki-pages-box").$(byText("SoftAssertions")).click();
        $("#wiki-content").shouldHave(text("Using JUnit5 extend test class"));
        $("#wiki-body").$(withText("Using JUnit5 extend test class")).shouldBe(visible);
    }

}
