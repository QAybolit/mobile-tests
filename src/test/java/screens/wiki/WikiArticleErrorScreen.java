package screens.wiki;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class WikiArticleErrorScreen {

    private final SelenideElement error = $(AppiumBy.xpath("//*[@text='An error occurred']"));

    @Step("Проверить, что страница открылась с ошибкой")
    public WikiArticleErrorScreen checkArticleErrorScreen(String searchText) {
        $(AppiumBy.xpath("//*[@text='%s']".formatted(searchText))).shouldBe(visible);
        this.error.shouldBe(visible);
        return this;
    }
}
