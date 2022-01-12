package test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class AnatationStepsVersion {

    @Step("Открываем главную страницу")
        public void openMainPage() {
            open("https://github.com");
        }

        @Step("Ищем репозиторий {repository}")
        public void searchForRepository(String repository) {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(repository);
            $(".header-search-input").submit();
        }

        @Step("Переходим в репозиторий {repository}")
        public void openRepositoryPage(String repository) {
            $(linkText(repository)).click();
        }

        @Step("Открываем Issues")
        public void openIssuesTab() {
            $(partialLinkText("Issues")).click();
        }

        @Step("Находим Issues с номером")
        public void shouldSeeIssueWithNumber(int number) {
            $(withText("#" + number)).should(Condition.visible);
        }

        @Attachment(value = "Screenshot", type = "text/html", fileExtension = "html")
        public byte[] attachPageSource() {
            return WebDriverRunner.source().getBytes(StandardCharsets.UTF_8);
        }


        @Test
        @Owner("eovechkina")
        @Feature("Issues")
        @Story("Поиск Issues не авторизованым пользователем")
        @DisplayName("Поиск Issues не авторизованым пользователем")
        @Severity(SeverityLevel.NORMAL)
        public void anatatedStepTest(){
            AnatationStepsVersion anatationSteps = new AnatationStepsVersion();
            anatationSteps.openMainPage();
            anatationSteps.searchForRepository("eroshenkoam/allure-example");
            anatationSteps.openRepositoryPage("eroshenkoam/allure-example");
            anatationSteps.openIssuesTab();
            anatationSteps.shouldSeeIssueWithNumber(68);
        }


    }
