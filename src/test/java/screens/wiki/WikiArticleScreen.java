package screens.wiki;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.androidUIAutomator;

public class WikiArticleScreen {

    private final String content = "new UiSelector().textContains(\"%s\")";

    private final SelenideElement image = $(AppiumBy.id("org.wikipedia.alpha:id/view_page_header_image"));
    private final SelenideElement error = $(AppiumBy.xpath("//*[@text='An error occurred']"));
    private final SelenideElement wikiGamesModal = $(AppiumBy.id("org.wikipedia.alpha:id/dialogContainer"));
    private final SelenideElement closeModalButton = $(AppiumBy.id("org.wikipedia.alpha:id/closeButton"));

    @Step("Закрыть модальное окно 'Wikipedia games', если оно появилось")
    public WikiArticleScreen closeWikiGamesModalIfExist() {
        if (this.wikiGamesModal.is(visible, Duration.ofMillis(10000))) {
            this.closeModalButton.click();
        }
        return this;
    }

    @Step("Проверить, что статья открылась")
    public WikiArticleScreen checkArticleScreen(String searchText, String subtitle) {
        $(androidUIAutomator(content.formatted(searchText))).shouldBe(visible);
        $(androidUIAutomator(content.formatted(subtitle))).shouldBe(visible);
        this.image.shouldBe(visible);
        return this;
    }

    @Step("Проверить, что статья открылась с ошибкой")
    public WikiArticleScreen checkArticleError(String searchText) {
        $(AppiumBy.xpath("//*[@text='%s']".formatted(searchText))).shouldBe(visible);
        this.error.shouldBe(visible);
        return this;
    }
}
