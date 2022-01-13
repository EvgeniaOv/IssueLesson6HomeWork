package test;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static javax.swing.text.html.parser.DTDConstants.NUMBER;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class LambdaVersion {
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int NUMBER = 68;

    @Test
    public void testIssueSearchLambda() {

        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });
        step("Поиск репозитория" + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });
        step("Переходим в репозиторий" + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });
        step("Открываем Issues", () -> {
            $(partialLinkText("Issues")).click();
        });
        step("Находим Issues с номером" + NUMBER, () -> {
            $(withText("#" + NUMBER)).should(Condition.visible);
        });

    }
}

