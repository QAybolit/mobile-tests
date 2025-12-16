package screens.wiki;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class WikiSearchScreen {

    private final SelenideElement searchTitle = $(AppiumBy.id("org.wikipedia.alpha:id/main_toolbar"));
    private final SelenideElement searchInput = $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text"));
    private final SelenideElement resultsText = $(AppiumBy.id("org.wikipedia.alpha:id/search_empty_text"));
    private final SelenideElement exploreTab = $(AppiumBy.id("org.wikipedia.alpha:id/nav_tab_explore"));
    private final SelenideElement historyTitle = $(AppiumBy.id("org.wikipedia.alpha:id/history_title"));

    private final ElementsCollection searchResults = $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title"));

    @Step("Нажать на кнопку 'Explore' в таббаре")
    public WikiMainScreen clickExploreTab() {
        this.exploreTab.shouldBe(visible).click();
        return new WikiMainScreen();
    }

    @Step("Ввести в строку поиска '{searchText}'")
    public WikiSearchScreen searchArticle(String searchText) {
        this.searchInput.shouldBe(visible).sendKeys(searchText);
        return this;
    }

    @Step("Нажать на первый найденый результат в списке статей")
    public WikiArticleScreen chooseArticleInList() {
        this.searchResults.shouldHave(sizeGreaterThan(0)).first().click();
        return new WikiArticleScreen();
    }

    @Step("Проверить, что список найденых результатов пустой")
    public WikiSearchScreen checkArticleListIsEmpty() {
        this.searchResults.isEmpty();
        this.resultsText.shouldBe(visible).shouldHave(text("No results"));
        return this;
    }

    @Step("Проверить, что страница поиска открылась")
    public WikiSearchScreen checkSearchScreen() {
        this.searchTitle.shouldBe(visible);
        this.historyTitle.shouldBe(visible);
        return this;
    }

    @Step("Проверить, что список найденых результатов содержит искомое значение")
    public WikiSearchScreen checkArticleList(String searchValue) {
        this.searchResults.forEach(e -> e.shouldHave(text(searchValue)));
        return this;
    }

}
